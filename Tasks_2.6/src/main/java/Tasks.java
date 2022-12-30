import java.util.Arrays;
import java.util.stream.IntStream;
import java.lang.String;

public class Tasks {
    public static void main(String[] args){
        System.out.println("№1");
        System.out.println("repeat(mice, 5) -> " + Num1 ("mice", 5));
        System.out.println("repeat(hello, 3) -> " + Num1 ("hello", 3));
        System.out.println("repeat(stop, 1) -> " + Num1 ("stop", 1));

        System.out.println("№2");
        System.out.println("differenceMaxMin([10, 4, 1, 4, -10, -50, 32, 21]) -> " + Num2 (new int[] {10, 4, 1, 4, -10, -50, 32, 21}));
        System.out.println("differenceMaxMin([44, 32, 86, 19]) -> " + Num2 (new int[] {44, 32, 86, 19}));

        System.out.println("№3");
        System.out.println("isAvgWhole([1, 3]) -> " + Num3 (new int[] {1, 3}));
        System.out.println("isAvgWhole([1, 2, 3, 4]) -> " + Num3 (new int[] {1, 2, 3, 4}));
        System.out.println("isAvgWhole([1, 5, 6]) -> " + Num3 (new int[] {1, 5, 6}));
        System.out.println("isAvgWhole([1, 1, 1]) -> " + Num3 (new int[] {1, 1, 1}));
        System.out.println("isAvgWhole([9, 2, 2, 5]) -> " + Num3 (new int[] {9, 2, 2, 5}));

        System.out.println("№4");
        System.out.println("cumulativeSum([1, 2, 3]) -> " + Arrays.toString(Num4 (new int[] {1, 2, 3})));
        System.out.println("cumulativeSum([1, -2, 3]) -> " + Arrays.toString(Num4 (new int[] {1, -2, 3})));
        System.out.println("cumulativeSum([3, 3, -2, 408, 3, 3]) -> " + Arrays.toString(Num4 (new int[] {3, 3, -2, 408, 3, 3})));

        System.out.println("№5");
        System.out.println("getDecimalPlaces(43.20) -> " + Num5 ("43.20"));
        System.out.println("getDecimalPlaces(400) -> " + Num5 ("400"));

        System.out.println("№6");
        System.out.println("Fibonacci(3) -> " + Num6 (3));
        System.out.println("Fibonacci(7) -> " + Num6 (7));
        System.out.println("Fibonacci(12) -> " + Num6 (12));

        System.out.println("№7");
        System.out.println("isValid(59001) -> " + Num7 ("59001"));
        System.out.println("isValid(853a7) -> " + Num7 ("853a7"));
        System.out.println("isValid(732 32) -> " + Num7 ("732 32"));
        System.out.println("isValid(393939) -> " + Num7 ("393939"));

        System.out.println("№8");
        System.out.println("isStrangePair(\"ratio\", \"orator\")) -> " + Num8 ("ratio", "orator"));
        System.out.println("isStrangePair(\"sparkling\", \"groups\") -> " + Num8 ("sparkling", "groups"));
        System.out.println("isStrangePair(\"bush\", \"hubris\") -> " + Num8 ("bush", "hubris"));
        System.out.println("isStrangePair(\"\", \"\") -> " + Num8 ("", ""));

        System.out.println("№9");
        System.out.println("isPrefix(\"automation\", \"auto-\") -> " + isPrefix ("automation", "auto-"));
        System.out.println("isSuffix(\"arachnophobia\", \"-phobia\") -> " + isSufix ("arachnophobia", "-phobia"));
        System.out.println("isPrefix(\"retrospect\", \"sub-\") -> " + isPrefix ("retrospect", "sub-"));
        System.out.println("isSuffix(\"vocation\", \"-logy\") -> " + isSufix ("vocation", "-logy"));

        System.out.println("№10");
        System.out.println("boxSeq(0)-> " + Num10 (0));
        System.out.println("boxSeq(1) -> " + Num10 (1));
        System.out.println("boxSeq(2) -> " + Num10 (2));
    }
    public static String Num1(String x, int y){
        String z="";
        for (int i = 0; i < x.length(); i++){
            for (int j = 0; j < y; j++)
                z += x.charAt(i);
        }
        return (z);
    }

    public static int Num2(int [] x){
        Arrays.sort(x);
        return (x[x.length-1] - x[0]);
    }

    public static boolean Num3(int [] x){
        int y = IntStream.of(x).sum();
        int z = x.length;
        return (y % z == 0);
    }

    public static int [] Num4(int [] x) {
        int y = 0;
        for(int i = 0; i < x.length; i++) {
            x[i] += y;
            y = x[i];
        }
        return (x);
    }

    public static int Num5(String x){
        if (x.contains(".")) {
            int y = x.length() - x.indexOf('.') - 1;
            return (y);
        }
        return 0;
    }

    public static int Num6(int x) {
        if (x == 0 || x == 1) {
            return 1;
        }
        else return Num6(x-1) + Num6(x-2);
    }

    public static boolean Num7(String x) {
        return ((x.length() == 5) && (x.matches("[0-9]+")));
    }

    public static boolean Num8(String x, String y) {
        if (x.length() == 0 && y.length() == 0){
            return true;
        }
        return ((x.charAt(0) == y.charAt(y.length()-1)) && (x.charAt(x.length()-1) == y.charAt(0)));
    }

    public static boolean isPrefix(String x, String pref){
        pref = pref.replace("-","");
        return (x.startsWith(pref));
    }

    public static boolean isSufix(String x, String suf){
        suf = suf.replace("-","");
        return (x.endsWith(suf));
    }

    public static int Num10(int x) {
        if(x % 2 == 0)
            return (x);
        else
            return (x+2);
    }
}
