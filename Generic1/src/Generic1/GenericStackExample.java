// 1. 제네릭 클래스 MyStack (public을 붙이지 않으면 한 파일에 같이 둘 수 있어!)
package Generic1;

class MyStack<AAA> {
    private Object[] data; // new AAA[] 배열 생성이 불가능하므로 최상위 Object 배열 사용
    private int top;       // 스택의 현재 위치를 나타내는 인덱스

    // 생성자
    public MyStack(int capacity) {
        data = new Object[capacity]; // Object 배열로 공간 할당
        top = 0;                     // top은 0으로 초기화
    }

    // 데이터를 넣는 push 메서드
    public void push(AAA item) {
        data[top++] = item; // 현재 top 위치에 저장하고 top 인덱스를 1 증가
    }

    // 데이터를 빼내는 pop 메서드
    @SuppressWarnings("unchecked")
    public AAA pop() {
        // top을 1 감소시킨 뒤 해당 위치의 Object 데이터를 AAA 타입으로 형변환하여 반환
        return (AAA) data[--top];
    }

    // 스택이 비어있는지 확인하는 메서드
    public boolean isEmpty() {
        return top == 0; // top이 0이면 비어있는 상태
    }
}

// 2. 메인 클래스 (파일 이름은 반드시 GenericStackExample.java 여야 함)
public class GenericStackExample {

    // [제네릭 메서드] printArray를 메인 클래스 안으로 이동시켰어!
    public static <AAA> void printArray(AAA[] array) {
        for (AAA element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    // 전체 프로젝트에서 실행을 담당하는 유일한 main 메서드
    public static void main(String[] args) {
        
        // --------------------------------------------------
        // [1번 예제] 제네릭 메서드 테스트
        // --------------------------------------------------
        System.out.println("=== [1] 제네릭 메서드 출력 결과 ===");
        Integer[] intArray = {1, 2, 3, 4, 5};
        Double[] doubleArray = {1.1, 2.2, 3.3, 4.4, 5.5};

        // 하나의 제네릭 메서드로 서로 다른 타입의 배열을 모두 처리
        printArray(intArray);
        printArray(doubleArray);
        System.out.println(); // 줄바꿈


        // --------------------------------------------------
        // [2번 예제] 제네릭 클래스(스택) 테스트
        // --------------------------------------------------
        System.out.println("=== [2] 제네릭 스택 출력 결과 ===");
        
        // Integer 타입의 스택 활용
        MyStack<Integer> intStack = new MyStack<>(100);
        intStack.push(10);
        intStack.push(20);
        
        System.out.println("Pop: " + intStack.pop()); // 후입선출에 따라 20 출력
        System.out.println("Pop: " + intStack.pop()); // 10 출력

        // Double 타입의 스택 활용
        MyStack<Double> doubleStack = new MyStack<>(100);
        doubleStack.push(1.1);
        doubleStack.push(2.2);
        
        System.out.println("Pop: " + doubleStack.pop()); // 2.2 출력
    }
}