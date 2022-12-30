import java.util.ArrayList;
import java.util.Objects;

public class Tasks_4 {
    public static void main(String args[]){
        System.out.println("№1\n10,7 hello my name is Bessie and this is my essay ->\n"
                + Num1(10, 7,  "hello my name is Bessie and this is my essay"));

        System.out.println("№2\nsplit(\"()()()\") -> " + Num2("()()()"));
        System.out.println("split(\"((()))\") -> " + Num2("((()))"));
        System.out.println("split(\"((()))(())()()(()())\") -> " + Num2("((()))(())()()(()())"));
        System.out.println("split(\"((())())(()(()()))\") -> " + Num2("((())())(()(()()))"));

        System.out.println("№3\ntoCamelCase(\"hello_edabit\") -> " +Num3("hello_edabit"));
        System.out.println("toSnakelCase(\"helloEdabit\") -> " +Num3("helloEdabit"));
        System.out.println("toCamelCase(\"is_modal_open\") -> " +Num3("is_modal_open"));
        System.out.println("toSnakeCase(\"getColor\")-> " +Num3("getColor"));

        System.out.println("№4\noverTime([9, 17, 30, 1.5]) -> " + Num4(new double[] {9, 17, 30, 1.5}));
        System.out.println("overTime([16, 18, 30, 1.8]) -> " + Num4(new double[] {16, 18, 30, 1.8}));
        System.out.println("overTime([13.25, 15, 30, 1.5]) -> " + Num4(new double[] {13.25, 15, 30, 1.5}));

        System.out.println("№5\nBMI(\"205 pounds\", \"73 inches\") -> " + Num5("205 pounds", "73 inches"));
        System.out.println("BMI(\"55 kilos\", \"1.65 meters\") -> " + Num5("55 kilos", "1.65 meters"));
        System.out.println("BMI(\"154 pounds\", \"2 meters\") -> " + Num5("154 pounds", "2 meters"));

        System.out.println("№6\nbugger(39) -> " + Num6 (39));
        System.out.println("bugger(999) -> " + Num6 (999));
        System.out.println("bugger(4) -> " + Num6 (4));

        System.out.println("№7\ntoStarShorthand(\"abbccc\") -> " + Num7 ("abbccc"));
        System.out.println("toStarShorthand(\"77777geff\") -> " + Num7 ("77777geff"));
        System.out.println("toStarShorthand(\"abc\") -> " + Num7 ("abc"));
        System.out.println("toStarShorthand(\"\") -> " + Num7 (""));

        System.out.println("№8\ndoesRhyme(\"Sam I am!\", \"Green eggs and ham.\") -> " + Num8 ("Sam I am!", "Green eggs and ham."));
        System.out.println("doesRhyme(\"Sam I am!\", \"Green eggs and HAM.\") -> " + Num8 ("Sam I am!", "Green eggs and HAM."));
        System.out.println("doesRhyme(\"You are off to the races\", \"a splendid day.\") -> " + Num8 ("You are off to the races", "a splendid day."));
        System.out.println("doesRhyme(\"and frequently do?\", \"you gotta move.\") -> " + Num8 ("and frequently do?", "you gotta move."));


        System.out.println("№9\ntrouble(451999277, 41177722899) -> " + Num9 (451999277, 41177722899L));
        System.out.println("trouble(1222345, 12345) -> " + Num9 (1222345, 12345));
        System.out.println("trouble(666789, 12345667) -> " + Num9 (666789, 12345667));
        System.out.println("trouble(33789, 12345337) -> " + Num9 (33789, 12345337));


        System.out.println("№10\ncountUniqueBooks(\"AZYWABBCATTTA\", 'A')-> " + Num10 ("AZYWABBCATTTA", 'A'));
        System.out.println("countUniqueBooks(\"$AA$BBCATT$C$$B$\", '$') -> " + Num10 ("$AA$BBCATT$C$$B$", '$'));
        System.out.println("countUniqueBooks(\"ZZABCDEF\", 'Z') -> " + Num10 ("ZZABCDEF", 'Z'));

    }

    public static String  Num1(int n, int k, String str){
        StringBuilder str2 = new StringBuilder();
        int y = k;
        for (var x : str.split(" ")){
            if (y >= x.length()){
               str2.append(x + " ");
               y -= x.length();
            } else {
                str2.append("\n" + x + " ");
                y = k - x.length();
            }
        }
        return (str2.toString());
    }

    public static String Num2(String str){
        ArrayList<String> spl = new ArrayList<>();
        int x = 0, y = 0, j = 0;
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == '(')
                x +=1;
            if (str.charAt(i) == ')'){
                y +=1;
                if (x == y) {
                    spl.add(str.substring(j, i+1));
                    j = i+1;
                }
            }
        }
        return (spl.toString());
    }

    public static String Num3(String str){
        StringBuilder str2 = new StringBuilder();
        for (int i = 0; i < str.length(); i++){
            if (Character.isUpperCase(str.charAt(i))){
                str2.append("_" + Character.toLowerCase(str.charAt(i)));
                i +=1;
            } else if (str.charAt(i) == '_'){
                str2.append(Character.toUpperCase(str.charAt(i+1)));
                i +=1;
            } else {
                str2.append(str.charAt(i));
            }
        }
        return (str2.toString());
    }

    public static String Num4(double[] x){
       StringBuilder str = new StringBuilder("$");
       double y;
       if (x[1] > 17.0)
           y = (17 - x[0]) * x[2] + (x[1] - 17) * x[3] * x[2];
       else
           y = (x[1] - x[0]) * x[2];
       str.append(String.format("%.2f", y));
       return (str.toString());
    }

    public static String Num5(String weight, String height) {
        String[] weight2 = weight.split(" ");
        String[] height2 = height.split(" ");
        double Weight = Integer.parseInt(weight2[0]);
        double Height = Double.parseDouble(height2[0]);
        double x;
        String i;
        if(weight2[1].matches("kilos")) {
            if(height2[1].matches("meters"))
                x = Weight / (Height * Height);
            else
                x = Weight / ((Height / 39.37) * (Height / 39.37));
        }
        else {
            Weight = Weight / 2.205;
            if(height2[1].matches("meters"))
                x = Weight / (Height * Height);
            else
                x = Weight / ((Height / 39.37) * (Height / 39.37));
        }
        if(x < 18.5)
            i = " Underweight";
        else if(x >= 18.5 && x <= 24.9)
            i = " Normal weight";
        else
            i = " Overweight";
        return (String.format(String.format("%.1f", x) + i));
    }

    public static int Num6(int x){
        int y = 0, z = 1;
        StringBuilder str = new StringBuilder(Integer.toString(x));
        while(str.length() > 1){
            for(int i = 0; i < str.length(); i++){
                z *= Character.getNumericValue(str.charAt(i));
            }
            str.setLength(0);
            str.append(z);
            z = 1;
            y ++;
        }
        return (y);
    }

    public static String Num7(String str) {
        if(str.length() == 0)
            return ("");
        StringBuilder x = new StringBuilder();
        for(int i = 0; i < str.length(); i++){
            int j = i, n = 1;
            while(str.length()-1 > j && str.charAt(i) == str.charAt(j+1)) {
                j += 1;
                n += 1;
            }
            i = j;
            x.append(str.charAt(i));
            if(n != 1) {
                x.append("*" + n);
            }
        }
        return (x.toString());
    }

    public static boolean Num8(String str1, String str2) {
        char[] x = new char[] {'a','e','i','o','u','y'};
        StringBuilder y = new StringBuilder();
        StringBuilder z = new StringBuilder();
        for(int i = str1.lastIndexOf(" ") + 1; i < str1.length(); i++){
            for(int j = 0; j < x.length; j++) {
                if (Character.toLowerCase(str1.charAt(i)) == x[j])
                    y.append(Character.toLowerCase(str1.charAt(i)));
            }
        }
        for(int i = str2.lastIndexOf(" ") + 1; i < str2.length(); i++){
            for (int j = 0; j < x.length; j++) {
                if (Character.toLowerCase(str2.charAt(i)) == x[j])
                    z.append(Character.toLowerCase(str2.charAt(i)));
            }
        }
        return ((y.toString()).equals(z.toString()));
    }

    public static boolean Num9(long num1, long num2) {
        String Num1 = Long.toString(num1);
        String Num2 = Long.toString(num2);
        for(int i = 1; i < Num1.length()-1; i++) {
            if(Num1.charAt(i) == Num1.charAt(i-1) && Num1.charAt(i) == Num1.charAt(i+1)) {
                int x = Num1.charAt(i);
                for (int n = 0; n < Num2.length()-1; n++) {
                    if (x == Num2.charAt(n) && x == Num2.charAt(n+1))
                        return (true);
                }
            }
        }
        return (false);
    }

    public static int Num10(String str, char e){
        ArrayList<Character> x = new ArrayList<>();
        int n = 0;
        boolean ne = false;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == e){
                ne = !ne;
            }
            if(ne){
                if(!x.contains(str.charAt(i))){
                    x.add(str.charAt(i));
                    n++;
                }
            }
        }
        return (n-1);
    }
}
