package 숙제5;

public class Rational {
    private int numerator;   // 분자
    private int denominator; // 분모

    public Rational() {
        this(1, 1); 
    }

    public Rational(int numerator, int denominator) {
    	if (denominator == 0) {
            System.out.println("분모에 0이 들어와 1로 자동 설정합니다.");
            denominator = 1; 
        }
        int commonDivider = gcd(numerator, denominator);
        this.numerator = numerator / commonDivider;
        this.denominator = denominator / commonDivider;
    
    }

    // (유클리드 호제법)
    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }


    public static Rational add(Rational r1, Rational r2) {
        int num = r1.numerator * r2.denominator + r2.numerator * r1.denominator;
        int den = r1.denominator * r2.denominator;
        return new Rational(num, den);
    }

 
    public static Rational subtract(Rational r1, Rational r2) {
        int num = r1.numerator * r2.denominator - r2.numerator * r1.denominator;
        int den = r1.denominator * r2.denominator;
        return new Rational(num, den);
    }

    public static Rational multiply(Rational r1, Rational r2) {
        int num = r1.numerator * r2.numerator;
        int den = r1.denominator * r2.denominator;
        return new Rational(num, den);
    }

    public static Rational divide(Rational r1, Rational r2) {
        int num = r1.numerator * r2.denominator;
        int den = r1.denominator * r2.numerator;
        return new Rational(num, den);
    }

    public String toString() {
        return "(" + numerator + "/" + denominator + ")";
    }


    public String toFloatingPointString(int precision) {
        double value = (double) numerator / denominator;
        return String.format("%." + precision + "f", value);
    }
}