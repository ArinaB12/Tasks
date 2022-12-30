public class Tasks {
    public static void main(String[] args) {

        System.out.println("№1");
        System.out.println("solutions(1, 0, -1) -> " + Num1(1, 0, -1));
        System.out.println("solutions(1, 0, -1) -> " + Num1(1, 0, 0));
        System.out.println("solutions(1, 0, -1) -> " + Num1(1, 0, 1));

        System.out.println("№2");
        System.out.println("findZip(\"all zip files are zipped\") -> " + Num2("all zip files are zipped"));
        System.out.println("findZip(\"all zip files are compressed\") -> " + Num2("all zip files are compressed"));

        System.out.println("№3");
        System.out.println("checkPerfect(6) -> " + Num3(6));
        System.out.println("checkPerfect(28) -> " + Num3(28));
        System.out.println("checkPerfect(496) -> " + Num3(496));
        System.out.println("checkPerfect(12) -> " + Num3(12));
        System.out.println("checkPerfect(97) -> " + Num3(97));

        System.out.println("№4");
        System.out.println("flipEndChars(\"Cat, dog, and mouse.\") -> " + Num4(new StringBuilder("Cat, dog and mouse.")));
        System.out.println("flipEndChars(\"ada\") -> " + Num4(new StringBuilder("ada")));
        System.out.println("flipEndChars(\"Ada\") -> " + Num4(new StringBuilder("Ada")));
        System.out.println("flipEndChars(\"z\") -> " + Num4(new StringBuilder("z")));

        System.out.println("№5");
        System.out.println("isValidHexCode(\"#CD5C5C\") -> " + Num5("#CD5C5C"));
        System.out.println("isValidHexCode(\"#CD5C58C\") -> " + Num5("#CD5C58C"));
        System.out.println("isValidHexCode(\"#CD5C5Z\") -> " + Num5("#CD5C5Z"));
        System.out.println("isValidHexCode(\"#CD5C&C\") -> " + Num5("#CD5C&C"));
        System.out.println("isValidHexCode(\"CD5C5C\") -> " + Num5("CD5C5C"));

        System.out.println("№6");
        System.out.println("same([1, 3, 4, 4, 4], [2, 5, 7]) -> " + Num6(new int[]{1, 3, 4, 4, 4}, new int[]{2, 5, 7}));
        System.out.println("same([9, 8, 7, 6], [4, 4, 3, 1]) -> " + Num6(new int[]{9, 8, 7, 6}, new int[]{4, 4, 3, 1}));
        System.out.println("same([2], [3, 3, 3, 3, 3]) -> " + Num6(new int[]{2}, new int[]{3, 3, 3, 3, 3}));

        System.out.println("№7");
        System.out.println("isKaprekar(3) -> " + Num7(3));
        System.out.println("isKaprekar(5) -> " + Num7(5));
        System.out.println("isKaprekar(297) -> " + Num7(297));

        System.out.println("№8");
        System.out.println("longestZero(\"01100001011000\") -> \"" + Num8("01100001011000") +"\"");
        System.out.println("longestZero(\"100100100\") -> \"" + Num8("100100100") +"\"");
        System.out.println("longestZero(\"11111\") -> \"" + Num8("11111") +"\"");

        System.out.println("№9");
        System.out.println("nextPrime(12) -> " + Num9(12));
        System.out.println("nextPrime(24) -> " + Num9(24));
        System.out.println("nextPrime(11) -> " + Num9(11));

        System.out.println("№10");
        System.out.println("rightTriangle(3, 4, 5) -> " + Num10(3, 4, 5));
        System.out.println("rightTriangle(145, 105, 100) -> " + Num10(145, 105, 100));
        System.out.println("rightTriangle(70, 130, 110) -> " + Num10(70, 130, 110));
    }

    public static int Num1(int a, int b, int c) {
        if (b * b - 4 * a * c > 0)
            return (2);
        else if (b * b - 4 * a * c == 0)
            return (1);

        else return (0);
    }

    public static int Num2(String x) {
        return x.indexOf("zip", x.indexOf("zip") + 1);
    }

    public static boolean Num3(int x) {
        int y = 0;
        for (int i = 1; i <= x / 2; i++) {
            if (x % i == 0)
                y += i;
        }
        return (x == y);
    }

    public static String Num4(StringBuilder x) {
        char y = x.charAt(0);
        if (x.length() < 2)
            return ("Incompatible.");
        else if (x.charAt(0) != x.charAt(x.length() - 1)) {
            x.setCharAt(0, x.charAt(x.length() - 1));
            x.setCharAt(x.length() - 1, y);
            return (x.toString());
        }
        return ("Two's a pair.");
    }

    public static boolean Num5(String x) {
        return (x.matches("#[0-9A-Fa-f]{6}"));
    }

    public static boolean Num6(int[] x, int[] y) {
        int n = 0;
        int k = 0;
        for (int i = 0; i < x.length - 1; i++)
            if (x[i] != x[i + 1])
                n += 1;
        for (int j = 0; j < y.length - 1; j++)
            if (y[j] != y[j + 1])
                k += 1;
        return (n == k);
    }

    public static boolean Num7(int x) {
        String y = Integer.toString(x * x);
        if(y.length() == 1) {
            return Integer.parseInt(y) == x;
        }
        int l = Integer.parseInt(y.substring(0, y.length() / 2));
        int r = Integer.parseInt(y.substring(y.length()/2));
        return (l + r == x);
    }

    /*public static String Num8(String x){
        int n = 0;
        int max = 0;
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < x.length(); i++){
            if (x.charAt(i) == '0') {
                n += 1;
            }
            else{
                if (max < n) {
                    max = n;
                }
                n = 0;
            }
        }
        for (int j = 0; j < n; j++)
            s.append("0");
        return (s.toString());
    }*/

    public static String Num8(String x){
        StringBuilder s = new StringBuilder();
        StringBuilder max = new StringBuilder();
        for (int i = 0; i < x.length(); i++){
            if (x.charAt(i) == '0') {
                s.append("0");
            }
            else{
                if (max.length() < s.length()) {
                    max.delete(0, max.length());
                    max.replace(0, max.length(),s.toString());
                }
                s.delete(0, s.length());
            }
        }
        return (max.toString());
    }

    public static int Num9(int x){
        int y = x;
        while(true) {
            if(y % 2 == 0){
                y += 1;
                continue;
            }
            boolean check = true;
            for(int i = 3; i <= y/2; i++) {
                if(y % i == 0) {
                    check = false;
                    break;
                }
            }
            if(check){return (y);}
            y += 1;
        }
    }

    public static boolean Num10(int x, int y, int z){
        if(x > y && x > z)
            return (x*x == y*y + z*z);
        else if(y > x && y > z)
            return (y*y == x*x + z*z);
        else
            return (z*z == x*x + y*y);
    }
}
