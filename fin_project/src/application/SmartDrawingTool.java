package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.ToolBar;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

import java.io.*;
import java.util.Stack;

public class SmartDrawingTool extends Application {

    private Pane canvas = new Pane();
    private String currentMode = "RECTANGLE"; 
    private Shape currentShape = null;        
    
    private Stack<DrawingAction> undoStack = new Stack<>();
    private Stack<DrawingAction> redoStack = new Stack<>();

    private double startX, startY;
    private double lastSceneX, lastSceneY;
    
    // ✨ 크기조절/이동하기 '직전'의 도형 모습을 사진 찍어둘 변수
    private Shape shapeBeforeModify = null; 
    
    private ColorPicker colorPicker = new ColorPicker(Color.TRANSPARENT);

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();

        ToolBar toolBar = new ToolBar();
        Button btnRect = new Button("직사각형");
        Button btnCircle = new Button("원");
        Button btnLine = new Button("직선");
        Button btnTriangle = new Button("삼각형");
        Button btnMove = new Button("✋ 이동");     
        Button btnEraser = new Button("🧽 지우개"); 
        Button btnFill = new Button("🪣 페인트통"); 
        Button btnResize = new Button("크기조절");
        Button btnUndo = new Button("⬅ Undo");
        Button btnRedo = new Button("➡ Redo");
        Button btnSave = new Button("💾 저장");
        Button btnLoad = new Button("📂 불러오기");

        toolBar.getItems().addAll(btnRect, btnCircle, btnLine, btnTriangle, btnMove, btnEraser, btnFill, btnResize, btnUndo, btnRedo, btnSave, btnLoad);
        root.setTop(toolBar);

        VBox rightMenu = new VBox(15); 
        rightMenu.setPadding(new Insets(15));
        rightMenu.setStyle("-fx-background-color: #f0f0f0; -fx-border-color: #cccccc; -fx-border-width: 0 0 0 1;"); 
        
        Label lblColor = new Label("🎨 퀵 팔레트");
        FlowPane miniPalette = new FlowPane();
        miniPalette.setHgap(5);
        miniPalette.setVgap(5);
        miniPalette.setPrefWrapLength(90); 
        
        Color[] quickColors = {
            Color.BLACK, Color.WHITE, Color.RED, Color.ORANGE, 
            Color.YELLOW, Color.GREEN, Color.BLUE, Color.PURPLE, Color.TRANSPARENT
        };
        
        for (Color c : quickColors) {
            Rectangle colorBox = new Rectangle(25, 25, c);
            colorBox.setStroke(Color.GRAY);
            colorBox.setOnMouseClicked(new PaletteClickHandler(c));
            miniPalette.getChildren().add(colorBox);
        }
        
        Label lblCustom = new Label("🎨 추가 색상/투명도");
        rightMenu.getChildren().addAll(lblColor, miniPalette, lblCustom, colorPicker);
        root.setRight(rightMenu);

        canvas.setStyle("-fx-background-color: white;");
        Rectangle clipRect = new Rectangle();
        clipRect.widthProperty().bind(canvas.widthProperty());
        clipRect.heightProperty().bind(canvas.heightProperty());
        canvas.setClip(clipRect);
        root.setCenter(canvas);

        ButtonHandler btnHandler = new ButtonHandler();
        btnRect.setOnAction(btnHandler);
        btnCircle.setOnAction(btnHandler);
        btnLine.setOnAction(btnHandler);
        btnTriangle.setOnAction(btnHandler);
        btnMove.setOnAction(btnHandler);     
        btnEraser.setOnAction(btnHandler);   
        btnFill.setOnAction(btnHandler);     
        btnResize.setOnAction(btnHandler);
        btnUndo.setOnAction(btnHandler);
        btnRedo.setOnAction(btnHandler);
        btnSave.setOnAction(btnHandler);
        btnLoad.setOnAction(btnHandler);

        CanvasMouseHandler mouseHandler = new CanvasMouseHandler();
        canvas.setOnMousePressed(mouseHandler);
        canvas.setOnMouseDragged(mouseHandler);
        canvas.setOnMouseReleased(mouseHandler);

        Scene scene = new Scene(root, 1100, 600); 
        primaryStage.setTitle("객체지향 스마트 드로잉 툴 (최종판: 상태 스냅샷 Undo)");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // =========================================================================
    // 🌟 사용자의 '행동'을 기록하는 클래스
    // =========================================================================
    class DrawingAction {
        String type; // "DRAW", "ERASE", "FILL", "MODIFY"(크기조절/이동)
        Shape shape; 
        Color oldColor, newColor;
        Shape oldState, newState; // ✨ 수정되기 전/후의 '스냅샷' 객체 보관용

        public DrawingAction(String type, Shape shape) {
            this.type = type;
            this.shape = shape;
        }

        public DrawingAction(String type, Shape shape, Color oldColor, Color newColor) {
            this.type = type;
            this.shape = shape;
            this.oldColor = oldColor;
            this.newColor = newColor;
        }

        // ✨ 모양/위치가 바뀌었을 때를 위한 생성자
        public DrawingAction(String type, Shape targetShape, Shape oldState, Shape newState) {
            this.type = type;
            this.shape = targetShape;
            this.oldState = oldState;
            this.newState = newState;
        }
    }

    // =========================================================================
    // 🌟 [핵심 도우미 메서드] 도형의 쌍둥이(Clone)를 만들거나 수치를 복사하는 기능
    // =========================================================================
    private Shape cloneShape(Shape s) {
        Shape clone = null;
        if (s instanceof Rectangle) {
            Rectangle r = (Rectangle) s;
            clone = new Rectangle(r.getX(), r.getY(), r.getWidth(), r.getHeight());
        } else if (s instanceof Ellipse) {
            Ellipse e = (Ellipse) s;
            clone = new Ellipse(e.getCenterX(), e.getCenterY(), e.getRadiusX(), e.getRadiusY());
        } else if (s instanceof Line) {
            Line l = (Line) s;
            clone = new Line(l.getStartX(), l.getStartY(), l.getEndX(), l.getEndY());
        } else if (s instanceof Polygon) {
            Polygon p = (Polygon) s;
            // ✨ 에러 해결 부분: Shape 타입인 clone에 바로 넣지 않고, 임시 Polygon 객체를 거쳐갑니다!
            Polygon tempPoly = new Polygon();
            tempPoly.getPoints().addAll(p.getPoints());
            clone = tempPoly; // 완성된 다각형을 형변환(업캐스팅)하여 반환
        }
        return clone;
    }

    private void copyProperties(Shape source, Shape target) {
        if (source instanceof Rectangle && target instanceof Rectangle) {
            Rectangle s = (Rectangle) source; Rectangle t = (Rectangle) target;
            t.setX(s.getX()); t.setY(s.getY()); t.setWidth(s.getWidth()); t.setHeight(s.getHeight());
        } else if (source instanceof Ellipse && target instanceof Ellipse) {
            Ellipse s = (Ellipse) source; Ellipse t = (Ellipse) target;
            t.setCenterX(s.getCenterX()); t.setCenterY(s.getCenterY()); t.setRadiusX(s.getRadiusX()); t.setRadiusY(s.getRadiusY());
        } else if (source instanceof Line && target instanceof Line) {
            Line s = (Line) source; Line t = (Line) target;
            t.setStartX(s.getStartX()); t.setStartY(s.getStartY()); t.setEndX(s.getEndX()); t.setEndY(s.getEndY());
        } else if (source instanceof Polygon && target instanceof Polygon) {
            Polygon s = (Polygon) source; Polygon t = (Polygon) target;
            t.getPoints().setAll(s.getPoints());
        }
    }

    class PaletteClickHandler implements EventHandler<MouseEvent> {
        private Color myColor; 
        public PaletteClickHandler(Color c) { this.myColor = c; }
        @Override
        public void handle(MouseEvent event) { colorPicker.setValue(myColor); }
    }

    // =========================================================================
    // 🌟 버튼 클릭 이벤트 핸들러
    // =========================================================================
    class ButtonHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            Button clickedBtn = (Button) event.getSource();
            String text = clickedBtn.getText();

            switch (text) {
                case "직사각형": currentMode = "RECTANGLE"; break;
                case "원": currentMode = "CIRCLE"; break;
                case "직선": currentMode = "LINE"; break;
                case "삼각형": currentMode = "TRIANGLE"; break; 
                case "✋ 이동": currentMode = "MOVE"; break;       
                case "🧽 지우개": currentMode = "ERASER"; break;   
                case "🪣 페인트통": currentMode = "FILL"; break;     
                case "크기조절": currentMode = "RESIZE"; break;
                
                case "⬅ Undo":
                    if (!undoStack.isEmpty()) {
                        DrawingAction action = undoStack.pop();
                        
                        if (action.type.equals("DRAW")) {
                            canvas.getChildren().remove(action.shape); 
                        } else if (action.type.equals("ERASE")) {
                            canvas.getChildren().add(action.shape); 
                        } else if (action.type.equals("FILL")) {
                            action.shape.setFill(action.oldColor); 
                        } else if (action.type.equals("MODIFY")) {
                            // ✨ 크기나 위치를 저장해둔 '옛날 사진'대로 덮어씌움!
                            copyProperties(action.oldState, action.shape);
                        }
                        
                        redoStack.push(action);
                    }
                    break;
                    
                case "➡ Redo":
                    if (!redoStack.isEmpty()) {
                        DrawingAction action = redoStack.pop();
                        
                        if (action.type.equals("DRAW")) {
                            canvas.getChildren().add(action.shape); 
                        } else if (action.type.equals("ERASE")) {
                            canvas.getChildren().remove(action.shape); 
                        } else if (action.type.equals("FILL")) {
                            action.shape.setFill(action.newColor); 
                        } else if (action.type.equals("MODIFY")) {
                            // ✨ 크기나 위치를 다시 '최신 사진'대로 덮어씌움!
                            copyProperties(action.newState, action.shape);
                        }
                        
                        undoStack.push(action);
                    }
                    break;
                    
                case "💾 저장": saveToFile(); break;
                case "📂 불러오기": loadFromFile(); break;
            }
        }
    }

    // =========================================================================
    // 🌟 마우스 조작 이벤트 핸들러
    // =========================================================================
    class CanvasMouseHandler implements EventHandler<MouseEvent> {
        @Override
        public void handle(MouseEvent event) {
            
            if (event.getEventType() == MouseEvent.MOUSE_PRESSED) {
                startX = event.getX();
                startY = event.getY();

                if (currentMode.equals("RESIZE") || currentMode.equals("MOVE") || currentMode.equals("ERASER") || currentMode.equals("FILL")) {
                    if (event.getTarget() instanceof Shape) {
                        currentShape = (Shape) event.getTarget();
                        
                        if (currentMode.equals("ERASER")) {
                            undoStack.push(new DrawingAction("ERASE", currentShape)); 
                            canvas.getChildren().remove(currentShape);
                            redoStack.clear();
                            currentShape = null; 
                        } 
                        else if (currentMode.equals("FILL")) {
                            Color oldColor = (Color) currentShape.getFill();
                            Color newColor = colorPicker.getValue();
                            currentShape.setFill(newColor);
                            
                            undoStack.push(new DrawingAction("FILL", currentShape, oldColor, newColor));
                            redoStack.clear();
                            currentShape = null;
                        }
                        else if (currentMode.equals("RESIZE") || currentMode.equals("MOVE")) {
                            lastSceneX = event.getSceneX();
                            lastSceneY = event.getSceneY();
                            // ✨ 마우스를 꾹 누른 순간, 바뀌기 전 도형의 쌍둥이(스냅샷)를 생성!
                            shapeBeforeModify = cloneShape(currentShape);
                        }
                    } else {
                        currentShape = null; 
                    }
                } 
                else if (currentMode.equals("RECTANGLE")) {
                    Rectangle rect = new Rectangle(startX, startY, 0, 0);
                    rect.setStroke(Color.BLACK);
                    rect.setFill(colorPicker.getValue()); 
                    currentShape = rect;
                    canvas.getChildren().add(rect);
                } 
                else if (currentMode.equals("CIRCLE")) {
                    Ellipse circle = new Ellipse(startX, startY, 0, 0);
                    circle.setStroke(Color.BLACK);
                    circle.setFill(colorPicker.getValue());
                    currentShape = circle;
                    canvas.getChildren().add(circle);
                } 
                else if (currentMode.equals("LINE")) {
                    Line line = new Line(startX, startY, startX, startY);
                    line.setStroke(Color.BLACK);
                    currentShape = line;
                    canvas.getChildren().add(line);
                }
                else if (currentMode.equals("TRIANGLE")) { 
                    Polygon triangle = new Polygon();
                    triangle.getPoints().addAll(startX, startY, startX, startY, startX, startY);
                    triangle.setStroke(Color.BLACK);
                    triangle.setFill(colorPicker.getValue());
                    currentShape = triangle;
                    canvas.getChildren().add(triangle);
                }
            }
            
            else if (event.getEventType() == MouseEvent.MOUSE_DRAGGED) {
                double currentX = event.getX();
                double currentY = event.getY();

                if (currentMode.equals("ERASER")) {
                    for (int i = canvas.getChildren().size() - 1; i >= 0; i--) {
                        javafx.scene.Node node = canvas.getChildren().get(i);
                        if (node.contains(currentX, currentY)) {
                            undoStack.push(new DrawingAction("ERASE", (Shape)node));
                            canvas.getChildren().remove(i);
                            redoStack.clear();
                        }
                    }
                    return; 
                }

                if (currentShape == null) return;

                if (currentShape instanceof Rectangle) {
                    Rectangle rect = (Rectangle) currentShape;
                    // 동후님 요청사항: 예전 방식 그대로 유지
                    if (currentMode.equals("RESIZE")) {
                        rect.setWidth(Math.abs(currentX - rect.getX()));
                        rect.setHeight(Math.abs(currentY - rect.getY()));
                    } 
                    else if (currentMode.equals("MOVE")) {
                        double dx = event.getSceneX() - lastSceneX;
                        double dy = event.getSceneY() - lastSceneY;
                        rect.setX(rect.getX() + dx);
                        rect.setY(rect.getY() + dy);
                    } 
                    else {
                        rect.setX(Math.min(startX, currentX));
                        rect.setY(Math.min(startY, currentY));
                        rect.setWidth(Math.abs(currentX - startX));
                        rect.setHeight(Math.abs(currentY - startY));
                    }
                } 
                else if (currentShape instanceof Ellipse) {
                    Ellipse circle = (Ellipse) currentShape;
                    if (currentMode.equals("MOVE")) {
                        double dx = event.getSceneX() - lastSceneX;
                        double dy = event.getSceneY() - lastSceneY;
                        circle.setCenterX(circle.getCenterX() + dx);
                        circle.setCenterY(circle.getCenterY() + dy);
                    } else {
                        circle.setRadiusX(Math.abs(currentX - circle.getCenterX()));
                        circle.setRadiusY(Math.abs(currentY - circle.getCenterY()));
                    }
                } 
                else if (currentShape instanceof Line) {
                    Line line = (Line) currentShape;
                    if (currentMode.equals("MOVE")) {
                        double dx = event.getSceneX() - lastSceneX;
                        double dy = event.getSceneY() - lastSceneY;
                        line.setStartX(line.getStartX() + dx);
                        line.setStartY(line.getStartY() + dy);
                        line.setEndX(line.getEndX() + dx);
                        line.setEndY(line.getEndY() + dy);
                    } else {
                        line.setEndX(currentX);
                        line.setEndY(currentY);
                    }
                }
                else if (currentShape instanceof Polygon) { 
                    Polygon triangle = (Polygon) currentShape;
                    if (currentMode.equals("MOVE")) {
                        double dx = event.getSceneX() - lastSceneX;
                        double dy = event.getSceneY() - lastSceneY;
                        for (int i = 0; i < triangle.getPoints().size(); i += 2) {
                            triangle.getPoints().set(i, triangle.getPoints().get(i) + dx);       
                            triangle.getPoints().set(i+1, triangle.getPoints().get(i+1) + dy); 
                        }
                    } else {
                        double minX = (currentMode.equals("RESIZE")) ? triangle.getPoints().get(2) : startX;
                        double minY = (currentMode.equals("RESIZE")) ? triangle.getPoints().get(1) : startY;
                        triangle.getPoints().setAll((minX + currentX) / 2, minY, minX, currentY, currentX, currentY);
                    }
                }
                
                if (currentMode.equals("MOVE")) {
                    lastSceneX = event.getSceneX();
                    lastSceneY = event.getSceneY();
                }
            }
            
            else if (event.getEventType() == MouseEvent.MOUSE_RELEASED) {
                if (currentShape != null) {
                    // 새로 그렸을 때
                    if (!currentMode.equals("RESIZE") && !currentMode.equals("MOVE") && !currentMode.equals("ERASER") && !currentMode.equals("FILL")) {
                        undoStack.push(new DrawingAction("DRAW", currentShape));
                        redoStack.clear();
                    } 
                    // ✨ 크기조절/이동이 끝났을 때
                    else if (currentMode.equals("RESIZE") || currentMode.equals("MOVE")) {
                        Shape shapeAfterModify = cloneShape(currentShape); // 조작이 끝난 후의 쌍둥이 사진
                        // (종류, 대상도형, 옛날사진, 최신사진) 순서로 스택에 저장!
                        undoStack.push(new DrawingAction("MODIFY", currentShape, shapeBeforeModify, shapeAfterModify));
                        redoStack.clear();
                        shapeBeforeModify = null; // 초기화
                    }
                }
                currentShape = null;
            }
        }
    }

    // =========================================================================
    // 🌟 파일 입출력 로직 
    // =========================================================================
    private void saveToFile() {
        try (PrintWriter pw = new PrintWriter(new FileWriter("drawing_data.txt"))) {
            for (javafx.scene.Node node : canvas.getChildren()) {
                if (node instanceof Rectangle) {
                    Rectangle r = (Rectangle) node;
                    pw.println("RECT " + r.getX() + " " + r.getY() + " " + r.getWidth() + " " + r.getHeight() + " " + r.getFill().toString());
                } else if (node instanceof Ellipse) {
                    Ellipse e = (Ellipse) node;
                    pw.println("CIRCLE " + e.getCenterX() + " " + e.getCenterY() + " " + e.getRadiusX() + " " + e.getRadiusY() + " " + e.getFill().toString());
                } else if (node instanceof Line) {
                    Line l = (Line) node;
                    pw.println("LINE " + l.getStartX() + " " + l.getStartY() + " " + l.getEndX() + " " + l.getEndY());
                } else if (node instanceof Polygon) { 
                    Polygon p = (Polygon) node;
                    pw.println("TRIANGLE " + p.getPoints().get(0) + " " + p.getPoints().get(1) + " " + p.getPoints().get(2) + " " + p.getPoints().get(3) + " " + p.getPoints().get(4) + " " + p.getPoints().get(5) + " " + p.getFill().toString());
                }
            }
            System.out.println("💾 콘솔: 도형과 색상이 파일에 저장되었습니다!");
        } catch (IOException e) {
            System.out.println("❌ 콘솔: 파일 저장 중 에러가 발생했습니다.");
        }
    }

    private void loadFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader("drawing_data.txt"))) {
            canvas.getChildren().clear(); 
            undoStack.clear();
            redoStack.clear();

            String line;
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(" ");
                Shape shape = null;
                
                if (tokens[0].equals("RECT")) {
                    shape = new Rectangle(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3]), Double.parseDouble(tokens[4]));
                    shape.setFill(Color.valueOf(tokens[5])); 
                } else if (tokens[0].equals("CIRCLE")) {
                    shape = new Ellipse(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3]), Double.parseDouble(tokens[4]));
                    shape.setFill(Color.valueOf(tokens[5]));
                } else if (tokens[0].equals("LINE")) {
                    shape = new Line(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3]), Double.parseDouble(tokens[4]));
                } else if (tokens[0].equals("TRIANGLE")) { 
                    shape = new Polygon(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3]), Double.parseDouble(tokens[4]), Double.parseDouble(tokens[5]), Double.parseDouble(tokens[6]));
                    shape.setFill(Color.valueOf(tokens[7]));
                }
                
                if (shape != null) {
                    shape.setStroke(Color.BLACK);
                    if (tokens[0].equals("LINE")) shape.setFill(Color.TRANSPARENT);
                    canvas.getChildren().add(shape);
                    undoStack.push(new DrawingAction("DRAW", shape));
                }
            }
            System.out.println("📂 콘솔: 저장된 파일에서 색상과 도형을 불러왔습니다!");
        } catch (FileNotFoundException e) {
            System.out.println("❌ 콘솔: 저장된 파일이 없습니다.");
        } catch (IOException e) {
            System.out.println("❌ 콘솔: 데이터를 읽는 중 오류가 발생했습니다.");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}