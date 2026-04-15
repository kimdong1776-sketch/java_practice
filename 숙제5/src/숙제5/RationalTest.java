package 숙제5;

public class RationalTest {
    public static void main(String[] args) {

        Rational r1 = new Rational(2, 4); // 
        Rational r2 = new Rational(1, 3);
        
 
        
        System.out.println("r1 (2/4 입력): " + r1); 
        System.out.println("r2 (1/3 입력): " + r2);

  
        System.out.println("\n--- 사칙연산 테스트 ---");
        
        Rational sum = Rational.add(r1, r2);
        System.out.println(r1 + " + " + r2 + " = " + sum); 

        Rational sub = Rational.subtract(r1, r2);
        System.out.println(r1 + " - " + r2 + " = " + sub); 

        Rational mul = Rational.multiply(r1, r2);
        System.out.println(r1 + " * " + r2 + " = " + mul);

        Rational div = Rational.divide(r1, r2);
        System.out.println(r1 + " / " + r2 + " = " + div); 

     
        System.out.println("\n--- 실수 출력 테스트 ---");
        System.out.println("r1을 소수로 (2자리): " + r1.toFloatingPointString(2));
        System.out.println("sum을 소수로 (5자리): " + sum.toFloatingPointString(5)); 
    }
}