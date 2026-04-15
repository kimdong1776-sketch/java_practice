package 숙제5;

public class IntegerSet {
    private boolean[] set;

    public IntegerSet() {
        set = new boolean[101];
    }

    public static IntegerSet union(IntegerSet set1, IntegerSet set2) {
        IntegerSet newSet = new IntegerSet();
        for (int i = 0; i <= 100; i++) {
      
            if (set1.set[i] || set2.set[i]) {
                newSet.set[i] = true;
            }
        }
        return newSet;
    }

    public static IntegerSet intersection(IntegerSet set1, IntegerSet set2) {
        IntegerSet newSet = new IntegerSet();
        for (int i = 0; i <= 100; i++) {
            if (set1.set[i] && set2.set[i]) {
                newSet.set[i] = true;
            }
        }
        return newSet;
    }

    public void insertElement(int k) {
        if (k >= 0 && k <= 100) {
            set[k] = true;
        } else {
            System.out.println("범위를 벗어난 숫자입니다 (0-100).");
        }
    }

    public void deleteElement(int m) {
        if (m >= 0 && m <= 100) {
            set[m] = false;
        }
    }

    public String toString() {
        String result = "";
        boolean isEmpty = true;

        for (int i = 0; i <= 100; i++) {
            if (set[i]) {
                result += i + " "; 
                isEmpty = false;
            }
        }
        return isEmpty ? "---" : result; 
    }


    public boolean isEqualTo(IntegerSet other) {
        for (int i = 0; i <= 100; i++) {
            if (this.set[i] != other.set[i]) {
                return false;
            }
        }
        return true; 
    }
}