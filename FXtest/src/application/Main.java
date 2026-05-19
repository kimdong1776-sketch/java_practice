package application;
	
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

import javafx.stage.Stage;

public class Main extends Application { // 본인의 클래스 이름에 맞게 수정하세요

    @Override
    public void start(Stage primaryStage) {
        // 1. 화면에 표시할 라벨 생성 (여기에 본인 이름을 적으세요!)
        Label nameLabel = new Label("김동후 (2025003170)"); 
        
        // 글자 크기를 조금 더 크게 설정 (선택 사항)
   
        // 2. 레이아웃 생성 및 라벨 추가 (가운데 정렬을 위해 StackPane 사용)
        StackPane root = new StackPane();
        root.getChildren().add(nameLabel);

        // 3. 씬(Scene) 생성 (가로 400, 세로 200 크기의 창)
        Scene scene = new Scene(root, 400, 200);

        // 4. 무대(Stage) 설정 및 보여주기
        primaryStage.setTitle("JavaFX 과제 제출");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}