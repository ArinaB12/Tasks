import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Tasks6 {
    public static void main(String[] args) {
        System.out.println("№1\nbell(1) -> " + Num1(1));
        System.out.println("bell(2) -> " + Num1(2));
        System.out.println("bell(3) -> " + Num1(3));

        System.out.println("№2\ntranslateWord(\"flag\") -> " + Num2_1("flag"));
        System.out.println("№2\ntranslateWord(\"Apple\") -> " + Num2_1("Apple"));
        System.out.println("translateWord(\"button\") -> " + Num2_1("button"));
        System.out.println("translateWord(\"\") -> " + Num2_1(""));
        System.out.println("translateSentence(\"I like to eat honey waffles.\") -> " + Num2_2("I like to eat honey waffles."));
        System.out.println("translateSentence(\"Do you think it is going to rain today?\") -> " + Num2_2("Do you think it is going to rain today?"));

        System.out.println("№3\nvalidColor(\"rgb(0,0,0)\") -> " + Num3("rgb(0,0,0)"));
        System.out.println("validColor(\"rgb(255,256,255)\") -> " + Num3("rgba(255,256,255)"));
        System.out.println("validColor(\"rgba(0,0,0,0.123456789)\") -> " + Num3("rgba(0,0,0,0.123456789)"));


        System.out.println("№4\nvalidColor(\"https://edabit.com?a=1&b=2&a=2\", [\"b\"]) -> " + Num4("https://edabit.com?a=1&b=2&a=2", new String[]{"b"}));
        System.out.println("validColor(\"https://edabit.com?a=1&b=2&a=2\") -> " + Num4("https://edabit.com?a=1&b=2&a=2", new String[] {} ));

        System.out.println("№5\ngetHashTags(\"How the Avocado Became the Fruit of the Global Trade\") -> " + Num5("How the Avocado Became the Fruit of the Global Trade"));
        System.out.println("getHashTags(\"Why You Will Probably Pay More for Your Christmas Tree This Year\") -> " + Num5("Why You Will Probably Pay More for Your Christmas Tree This Year"));
        System.out.println("getHashTags(\"Hey Parents, Surprise, Fruit Juice Is Not Fruit\") -> " + Num5("Hey Parents, Surprise, Fruit Juice Is Not Fruit"));
        System.out.println("getHashTags(\"Visualizing Science\") -> " + Num5("Visualizing Science"));

        System.out.println("№6\nulam(4) -> " + Num6(4));
        System.out.println("ulam(9) -> " + Num6(9));
        System.out.println("ulam(206) -> " + Num6(206));

        System.out.println("№7\nnonRepeating(\"abcabcbb\") -> " + Num7("abcabcbb"));
        System.out.println("nonRepeating(\"aaaaaa\") -> " + Num7("aaaaaa"));
        System.out.println("nonRepeating(\"abcde\") -> " + Num7("abcde"));
        System.out.println("nonRepeating(\"abcda\") -> " + Num7("abcda"));

        System.out.println("№8\nconvertToRoman(2) -> " + Num8(2));
        System.out.println("convertToRoman(12) -> " + Num8(12));
        System.out.println("convertToRoman(12) -> " + Num8(3999));

        System.out.println("№9\nformula(\"6 * 4 = 24\") -> " + Num9("6 * 4 = 24"));
        System.out.println("formula(\"18 / 17 = 2\") -> " + Num9("18 / 17 = 2"));
        System.out.println("formula(\"16 * 10 = 160 = 14 + 120\") -> " + Num9("16 * 10 = 160 = 14 + 120"));

        System.out.println("№10\npalindrome(\"6 * 4 = 24\") -> " + Num10(11211230));
        System.out.println("palindrome(13001120) -> " + Num10(13001120));
        System.out.println("palindrome(23336014) -> " + Num10(23336014));
        System.out.println("palindrome(11) -> " + Num10(11));
    }

    public static int Num1(int number){
        int bellNumbers = 0;
        for (int k = 0; k <= number; k++) {
            bellNumbers += DoStirlingNumbers(number, k);
        }
        return (bellNumbers);
    }
    private static int DoStirlingNumbers(int number, int k) {
        if (number >= 0 && number == k) {
            return (1);
        }
        if (number > 0 && k == 0 || k > 0 && number == 0) {
            return (0);
        }
        return (DoStirlingNumbers(number - 1, k - 1) + k * DoStirlingNumbers(number - 1, k));
    }

    public static String Num2_1(String str){
        char[] chars = str.toCharArray();
        StringBuilder answer = new StringBuilder();
        Pattern pattern = Pattern.compile("^[aeiouAEIOU]");
        Matcher matcher = pattern.matcher(str);
        if (str.length() != 0)
            if (matcher.find()){
                answer.append(str + "yay");
            } else {
                answer.append(str.substring(1) + str.substring(0, 1) + "ay");
            } else return ("");
        return (answer.toString());
    }

    public static String Num2_2(String str){
        str = str.substring(0, str.length());
        String[] words = str.split(" ");
        StringBuilder answer = new StringBuilder();
        String chars = " ";
        if (words.length != 0) {
            for (int j = 0; j < words.length-1; j++) {
                chars = words[j];
                Pattern pattern = Pattern.compile("^[aeiouAEIOU]");
                Matcher matcher = pattern.matcher(chars);
                if (matcher.find()) {
                    answer.append(chars + "yay");
                    answer.append(" ");
                } else {
                    answer.append(chars.substring(1) + chars.substring(0, 1) + "ay");
                    answer.append(" ");
                }
            }
            answer.append(words[words.length-1]);
        }else
            return("");
        return (answer.toString());
    }

    public static boolean Num3(String str) {
        int scobe = str.indexOf("(");
        int scobe2 = str.indexOf(")");
        String rgb = str.substring(0, scobe);
        boolean answer = false;
        String numbers = str.substring(scobe + 1, scobe2);
        if (rgb.equals("rgb")) {
            String[] stringNumbers = numbers.split(",");
            for (int i = 0; i < stringNumbers.length; i++) {
                int[] finalNumbers = new int[stringNumbers.length];
                for (int j = 0; j < finalNumbers.length; j++) {
                    finalNumbers[j] = Integer.parseInt(stringNumbers[i]);
                    int format = finalNumbers[j];
                    if (format >= 0) {
                        if (format > 255) {
                            return (false);
                        } else {
                            answer = !answer;
                        }
                    }
                }
            }
        }
        if (rgb.equals("rgba")) {
            String[] stringNumbers = numbers.split(",");
            for (int i = 0; i < stringNumbers.length; i++) {
                double[] rgbFormats = new double[stringNumbers.length];
                rgbFormats[i] = Double.parseDouble(stringNumbers[i]);
                int end = rgbFormats.length - 1;
                double alpha = rgbFormats[end];
                for (int j = 0; j < end; j++) {
                    if ((rgbFormats[j] >= 0 && rgbFormats[j] <= 255) && (alpha >= 0 && alpha <= 1)) {
                        answer = true;
                    }
                }
            }
        }
        return (answer);
    }

    public static String Num4(String url, String[] exclusions) {
        Map<String, String> params = new HashMap<String, String>();
        String[] urlSplit = url.split("\\?");
        if (urlSplit.length < 2) {
            return (url);
        }
        String[] rawParams = urlSplit[1].split("&");
        for (String rawParam : rawParams) {
            String[] paramSplit = rawParam.split("=");
            if (paramSplit.length == 2) {
                params.put(paramSplit[0], paramSplit[1]);
            }
        }
        if (exclusions != null) {
            for (String exclusion : exclusions) {
                params.remove(exclusion);
            }
        }
        StringBuilder resultUrl = new StringBuilder(urlSplit[0] + "?");
        Iterator<String> namesIterator = params.keySet().iterator();
        while (namesIterator.hasNext()) {
            String name = namesIterator.next();
            resultUrl.append(name + "=" + params.get(name));
            if (namesIterator.hasNext()) {
                resultUrl.append("&");
            }
        }
        return (resultUrl.toString());
    }

    public static String Num5(String str) {
        StringBuilder answer = new StringBuilder();
        String[] words = str.split(" ");
        String longest1 = "";
        String longest2 = "";
        String longest3 = "";
        int length1 = 0;
        int length2 = 0;
        int length3 = 0;
        ArrayList<Integer> length = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            length.add(words[i].length());
        }
        Collections.sort(length);
        length1 = length.get(length.size() - 1);
        length2 = length.get(length.size() - 2);
        if (words.length > 2) {
            length3 = length.get(length.size() - 3);
        }
        for (int g = 0; g < words.length; g++) {
            if (words[g].length() == length1) {
                longest1 = words[g];
                break;
            }
        }
        for (int g = 0; g < words.length; g++) {
            if ((words[g].length() == length2) && !(words[g].equals(longest1))) {
                longest2 = words[g];
                break;
            }
        }
        for (int g = 0; g < words.length; g++) {
            if ((words[g].length() == length3) && !(words[g].equals(longest1)) && !(words[g].equals(longest2))) {
                longest3 = words[g];
                break;
            }
        }
        if (words.length > 2) {
            answer.append("#" + longest1);
            answer.append(" ");
            answer.append("#" + longest2);
            answer.append(" ");
            answer.append("#" + longest3);
        } else {
            answer.append("#" + longest1);
            answer.append(" ");
            answer.append("#" + longest2);
        }
        return (answer.toString());
    }

    public static int Num6(int n){
        ArrayList<Integer> ulamNumbers = new ArrayList<>();
        ulamNumbers.add(1);
        ulamNumbers.add(2);
        for (int i = 3; i < 2000; i++) {
            int count = 0;
            for (int j = 0; j < ulamNumbers.size() - 1; j++) {
                for (int k = j + 1; k < ulamNumbers.size(); k++) {
                    if (ulamNumbers.get(j) + ulamNumbers.get(k) == i) {
                        count++;
                    }
                    if (count > 1) {
                        break;
                    }
                }
                if (count > 1) {
                    break;
                }
            }
            if (count == 1) {
                ulamNumbers.add(i);
            }
        }
        return (ulamNumbers.get(n-1));
    }
    public static String Num7(String str){
        Set<Character> chars = new TreeSet<>();
        for(int i = 0; i < str.length(); i++){
            chars.add(str.charAt(i));
        }
        Iterator<Character> i = chars.iterator();
        StringBuilder answer = new StringBuilder();
        while (i.hasNext()) {
            answer.append(i.next());
        }
        return (answer.toString());
    }
    public static String Num8(int n){
        int units = n % 10;
        int ten = n / 10;
        int hundred = n / 100;
        int thousand = n / 1000;
        String[] digits = new String[]{"-", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String[] tens = new String[]{"-", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] hundreds = new String[]{"-", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] thousands = new String[]{"-", "M", "MM", "MMM"};
        StringBuilder answer = new StringBuilder();
        if(thousand > 0){
            answer.append(thousands[thousand]);
            String number = String.valueOf(hundred).substring(1);
            hundred = Integer.parseInt(number);
        }
        if(hundred > 0){
            answer.append(hundreds[hundred]);
            String number = String.valueOf(ten).substring(2);
            ten = Integer.parseInt(number);
        }
        if(ten > 0){
            answer.append(tens[ten]);
        }
        if(units > 0){
            answer.append(digits[units]);
        }
        return (answer.toString());
    }
    public static boolean Num9(String str){
        String[] chars = str.split(" ");
        int firstNumber = Integer.parseInt(chars[0]);
        int secondNumber = Integer.parseInt(chars[2]);
        int result = Integer.parseInt(chars[4]);
        String operationFirst = chars[1];
        if(chars.length > 5){
            int thirdNumber = Integer.parseInt(chars[6]);
            int forthNumber = Integer.parseInt(chars[8]);
            String operationSecond = chars[7];
            int resultOne =0;
            int resultSec = 0;
            if(operationFirst.equals("*") || operationSecond.equals("*")){
                if(operationFirst.equals("*")) {
                    resultOne = firstNumber * secondNumber;
                }
                else{
                    resultSec = thirdNumber * forthNumber;
                }
            }
            else if(operationFirst.equals("/") || operationSecond.equals("/")){
                if(operationFirst.equals("/")) {
                    resultOne = firstNumber / secondNumber;
                }
                else{
                    resultSec = thirdNumber / forthNumber;
                }
            }
            else if(operationFirst.equals("+") || operationSecond.equals("+")){
                if(operationFirst.equals("+")) {
                    resultOne = firstNumber + secondNumber;
                }
                else{
                    resultSec = thirdNumber + forthNumber;
                }
            }
            else if(operationFirst.equals("-") || operationSecond.equals("-")){
                if(operationFirst.equals("-")) {
                    resultOne = firstNumber - secondNumber;
                }
                else{
                    resultSec = thirdNumber - forthNumber;
                }
            }
            return (resultOne == resultSec);
        } else{
            int isResult = 0;
            if(operationFirst.equals("*")){
                isResult = firstNumber * secondNumber;
            }
            else if(operationFirst.equals("+")){
                isResult = firstNumber + secondNumber;
            }
            else if(operationFirst.equals("/")){
                isResult = firstNumber / secondNumber;
            }
            else if(operationFirst.equals("-")){
                isResult = firstNumber + secondNumber;
            }
            return (isResult == result);
        }
    }
    public static boolean Num10(int n){
        StringBuilder reverseString = new StringBuilder();
        String number = String.valueOf(n);
        boolean result = false;
        for (int i = number.length() - 1; i >= 0; i--) {
            reverseString.append(number.charAt(i));
        }
        if(!(number.equals(reverseString.toString()))) {
            if(!(number.length() == 2)){
                String newString = "";
                String compare = "";
                for (int i = 0; i < number.length() - 1; i++) {
                    for (int k = i + 1; k < number.length(); k++) {
                        StringBuilder stringNumber = new StringBuilder();
                        int firstNumber = Integer.parseInt(String.valueOf(number.charAt(i)));
                        int secondNumber = Integer.parseInt(String.valueOf(number.charAt(k)));
                        int newN = firstNumber + secondNumber;
                        newString = String.valueOf(newN);
                        stringNumber.append(newString);
                        compare = stringNumber.toString();
                    }
                }
                StringBuilder reverseString2 = new StringBuilder();
                for (int i = newString.length() - 1; i >= 0; i--) {
                    reverseString2.append(newString.charAt(i));
                }
                if (compare.equals(reverseString2.toString())){
                    result = true;
                }
                else{
                    return (false);
                }
            }
        } else{
            result = true;
        }
        return (result);
    }
}

