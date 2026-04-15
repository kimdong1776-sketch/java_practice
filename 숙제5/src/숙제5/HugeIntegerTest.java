package 숙제5;

public class HugeIntegerTest {
    public static void main(String[] args) {
        HugeInteger n1 = new HugeInteger();
        HugeInteger n2 = new HugeInteger();


        n1.parse("1234567890123456789012345678901234567890");
        n2.parse("987654321098765432109876543210987654321");

        System.out.println("N1: " + n1);
        System.out.println("N2: " + n2);

 
        HugeInteger sum = HugeInteger.add(n1, n2);
        System.out.println("Sum: " + sum);


        System.out.println("N1 > N2? : " + n1.isGreaterThan(n2));
        System.out.println("N2 > N1? : " + n2.isGreaterThan(n1));

   
        HugeInteger diff = HugeInteger.subtract(n2, n1);
        System.out.println("Difference (N2 - N1): " + diff);
        
  
        HugeInteger zero = new HugeInteger();
        System.out.println("Is Zero? : " + zero.isZero());
    }
}