package 숙제5;

public class HugeInteger {
    private int[] digits = new int[40]; 

    public HugeInteger() {
        
    }

   
    public void parse(String s) {
        for (int i = 0; i < 40; i++) digits[i] = 0;

        int len = s.length();
        int startIdx = 40 - len; 

        for (int i = 0; i < len; i++) {
           
            digits[startIdx + i] = s.charAt(i) - '0';
        }
    }

   
    public static HugeInteger add(HugeInteger h1, HugeInteger h2) {
        HugeInteger result = new HugeInteger();
        int carry = 0;

        for (int i = 39; i >= 0; i--) {
            int sum = h1.digits[i] + h2.digits[i] + carry;
            result.digits[i] = sum % 10;
            carry = sum / 10;
        }
        return result;
    }


    public static HugeInteger subtract(HugeInteger h1, HugeInteger h2) {
        HugeInteger result = new HugeInteger();
        int borrow = 0;

        for (int i = 39; i >= 0; i--) {
            int sub = h1.digits[i] - h2.digits[i] - borrow;
            if (sub < 0) {
                sub += 10;
                borrow = 1;
            } else {
                borrow = 0;
            }
            result.digits[i] = sub;
        }
        return result;
    }


    public boolean isGreaterThan(HugeInteger other) {
        for (int i = 0; i < 40; i++) {
            if (this.digits[i] > other.digits[i]) return true;
            if (this.digits[i] < other.digits[i]) return false;
        }
        return false; // 같으면 false
    }

 
    public boolean isEqualTo(HugeInteger other) {
        for (int i = 0; i < 40; i++) {
            if (this.digits[i] != other.digits[i]) return false;
        }
        return true;
    }

 
    public boolean isNotEqualTo(HugeInteger other) { 
    	return !isEqualTo(other); 
    }
    
    public boolean isLessThan(HugeInteger other) {
    	return other.isGreaterThan(this); 
    }
    
    public boolean isGreaterThanOrEqualTo(HugeInteger other) {
    	return isGreaterThan(other) || isEqualTo(other); 
    }
    
    public boolean isLessThanOrEqualTo(HugeInteger other) {
    	return isLessThan(other) || isEqualTo(other); 
    }
   
    public boolean isZero() {
        for (int d : digits) if (d != 0) return false;
        return true;
    }


    public String toString() {
        String res = "";    
        boolean start = false; 

        for (int i = 0; i < 40; i++) {
          
            if (start == false && digits[i] != 0) {
                start = true; 
            }

        
            if (start == true) {
                res = res + digits[i];
            }
        }

        if (res.equals("")) {
            return "0";
        } else {
            return res;
        }
    }
}