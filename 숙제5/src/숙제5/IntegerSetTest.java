package 숙제5;

public class IntegerSetTest {
    public static void main(String[] args) {
        System.out.println("1. 객체 생성 및 초기화(공집합) 테스트");
        IntegerSet setA = new IntegerSet();
        IntegerSet setB = new IntegerSet();
        System.out.println("초기 Set A: " + setA); 
        System.out.println("초기 Set B: " + setB);

        System.out.println("\n2. 원소 삽입 테스트 (A: 10, 25, 50 / B: 25, 50, 80)");
        setA.insertElement(10);
        setA.insertElement(25);
        setA.insertElement(50);

        setB.insertElement(25);
        setB.insertElement(50);
        setB.insertElement(80);

        System.out.println("결과 Set A: " + setA);
        System.out.println("결과 Set B: " + setB);

  
        System.out.println("\n3. 합집합(Union) 테스트 (A 합 B)");
        IntegerSet unionSet = IntegerSet.union(setA, setB);
        System.out.println("A ∪ B: " + unionSet); // 예상: 10 25 50 80


        System.out.println("\n4. 교집합(Intersection) 테스트 (A 교 B)");
        IntegerSet intersectSet = IntegerSet.intersection(setA, setB);
        System.out.println("A ∩ B: " + intersectSet); 

     
        System.out.println("\n5. 원소 삭제 테스트 (A에서 10, 25, 50 삭제)");
        setA.deleteElement(10);
        setA.deleteElement(25);
        setA.deleteElement(50);
        System.out.println("삭제 후 Set A: " + setA);

 
        System.out.println("\n6. 비교 테스트");
        IntegerSet setC = new IntegerSet();
        setC.insertElement(25);
        setC.insertElement(50);
        
        System.out.println("Set B: " + setB);
        System.out.println("Set C: " + setC);
        System.out.println("B와 C는 같은가? : " + setB.isEqualTo(setC)); 
        
        setC.insertElement(80);
        System.out.println("C에 80 삽입 후 B와 C는 같은가? : " + setB.isEqualTo(setC)); // true


        System.out.println("\n7. 경계값 및 예외 상황 테스트");
        System.out.print("105 삽입 시도: ");
        setA.insertElement(105); // 에러 메시지 출력 확인
    }
}