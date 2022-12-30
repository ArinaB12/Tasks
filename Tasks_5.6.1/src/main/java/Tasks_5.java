import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.*;
import org.apache.commons.codec.*;


public class Tasks_5 {
    public static void main(String[] args) {
        System.out.println("№1\nencrypt (\"Hello\") -> " + Num1_1("Hello"));
        System.out.println("decrypt ([ 72, 33, -73, 84, -12, -3, 13, -13, -68 ]) -> " + Num1_2(new int[]{ 72, 33, -73, 84, -12, -3, 13, -13, -68 }));
        System.out.println("encrypt (\"Sunshine\") -> " + Num1_1("Sunshine"));

        System.out.println("№2\ncanMove (\"Rook\", \"A8\", \"H8\") -> " + Num2("Rook", "A8", "H8"));
        System.out.println("canMove (\"Bishop\", \"A7\", \"G1\") -> " + Num2("Bishop", "A7", "G1"));
        System.out.println("canMove (\"Queen\", \"C4\", \"D6\") -> " + Num2("Queen", "C4", "D6"));

        System.out.println("№3\ncanComplete(\"butl\", \"beautiful\") -> " + Num3("butl", "beautiful"));
        System.out.println("canComplete(\"butlz\", \"beautiful\") -> " + Num3("butlz", "beautiful"));
        System.out.println("canComplete(\"tulb\", \"beautiful\") -> " + Num3("tulb", "beautiful"));

        System.out.println("№4\nsumDigProd(16, 28) -> " + Num4(16, 28));
        System.out.println("sumDigProd(0) -> " + Num4(0));
        System.out.println("sumDigProd(1, 2, 3, 4, 5, 6) -> " + Num4(1, 2, 3, 4, 5, 6));

        System.out.println("№5\nsameVowelGroup([\"many\", \"carriage\", \"emit\", \"apricot\", \"animal\"]) -> " + Num5(new String[]{"many", "carriage", "emit", "apricot", "animal"}));
        System.out.println("sameVowelGroup([\"hoops\", \"chuff\", \"bot\", \"bottom\"]) -> " + Num5(new String[]{"hoops", "chuff", "bot", "bottom"}));

        System.out.println("№6\nvalidateCard(1234567890123456) -> " + Num6("1234567890123456"));
        System.out.println("validateCard(1234567890123452) -> " + Num6("1234567890123452"));

        System.out.println("№7\nnumToEng(0) -> " + Num7(0));
        System.out.println("numToEng(18) -> " + Num7(18));
        System.out.println("numToEng(126) -> " + Num7(126));
        System.out.println("numToEng(909) -> " + Num7(909));

        System.out.println("№8\ngetHash(\"password123\") -> " + Num8("password123"));
        System.out.println("getHash(\"Fluffy@home\") -> " + Num8("Fluffy@home"));
        System.out.println("getHash(\"Hey dude!\") -> " + Num8("Hey dude!"));

        System.out.println("№9\ncorrectTitle(\"jOn SnoW, kINg IN thE noRth.\") -> " + Num9("jOn SnoW, kINg IN thE noRth."));
        System.out.println("correctTitle(\"sansa stark, lady of winterfell.\") -> " + Num9("sansa stark, lady of winterfell."));
        System.out.println("correctTitle(\"TYRION LANNISTER, HAND OF THE QUEEN.\") -> " + Num9("TYRION LANNISTER, HAND OF THE QUEEN."));


        System.out.println("№10_hexes");
        for(StringBuilder hex: hexLattice(19)) {
            System.out.printf(hex.toString());
        }


    }
    public static String Num1_1(String s) {
        char [] strChars = s.toCharArray();
        int[] x = new int[s.length()];
        x[0] = strChars[0];
        for (int i = 1; i < strChars.length; i++){
            x[i] = strChars[i] - strChars[i-1];
        }
        String stringAnswer = Arrays.toString(x);
        return (stringAnswer);
    }

    public static String Num1_2(int[] x){
        String s = "";
        int[] y = new int[x.length];
        y[0] = x[0];
        for (int i = 1; i < x.length; i++) {
            y[i] = x[i] + y[i-1];
        }
        for (int i = 0; i < y.length; i++){
            s += (char) y[i];
        }
        return (s);
    }

    public static boolean Num2(String figure, String start, String end) {
        int y_start = Integer.parseInt(start.substring(1));
        int y_end = Integer.parseInt(end.substring(1));
        String x = "-ABCDEFGH";
        int x_start = x.indexOf(start.charAt(0));
        int x_end = x.indexOf(end.charAt(0));
        int delta_x = Math.abs(x_end - x_start);
        int delta_y = Math.abs(y_end - y_start);
        if (figure.equals("Pawn")) {
            if (delta_x == 0 & delta_y < 3) {
                return (true);
            }
        }
        if (figure.equals("Knight")) {
            if ((delta_x + delta_y == 3) & (delta_x == 1 | delta_y == 1)) {
                return (true);
            }
        }
        if (figure.equals("Bishop")) {
            if (delta_x == delta_y) {
                return (true);
            }
        }
        if (figure.equals("Rook")) {
            if (delta_x == 0 | delta_y == 0) {
                return (true);
            }
        }
        if (figure.equals("Queen")) {
            if (delta_x == delta_y | delta_x == 0 | delta_y == 0) {
                return (true);
            }
        }
        if (figure.equals("King")) {
            if (delta_x < 2 & delta_y < 2) {
                return (true);
            }
        }
        return (false);
    }

    public static boolean Num3(String word, String full_word){
        char[] word_char = word.toCharArray();
        char[] full_word_char = full_word.toCharArray();
        int previous_index = -1;
        int n = 0;
        for (int i = 0; i < word_char.length; i++) {
            for (int j = previous_index+1; j < full_word_char.length; j++) {
                if ((word_char[i] == full_word_char[j])){
                    n += 1;
                    previous_index = j;
                }
            }
        }
        return (word_char.length == n);
    }

    public static int Num4(int ... args){
        int sum = 0;
        for (int i = 0; i < args.length; i++) {
            sum += args[i];
        }
        String number_str = Integer.toString(sum);
        while (number_str.length() > 1) {
            char[] chars = number_str.toCharArray();
            int[] digits = new int[chars.length];
            for (int i = 0; i < chars.length; i++) {
                digits[i] = Integer.parseInt(String.valueOf(chars[i]));
            }
            sum = 1;
            for (int i = 0; i < digits.length; i++) {
                sum = sum * digits[i];
            }
            number_str = Integer.toString(sum);
        }
        return (sum);
    }

    public static Set<String> Num5(String[] arr){
        ArrayList<String> preReady = new ArrayList<>();
        Set<String> answer = new TreeSet<>();
        Set<Character> vowels_grouped = new TreeSet<>();
        vowels_grouped.add('a');
        vowels_grouped.add('e');
        vowels_grouped.add('o');
        vowels_grouped.add('y');
        vowels_grouped.add('u');
        vowels_grouped.add('i');
        for (int i = 0; i < arr.length; i++){
            char[] current_word = new char[i];
            current_word = arr[i].toCharArray();
            Set<Character> word_vowels = new TreeSet<>();
            ArrayList<Character> vowels = new ArrayList<>();
            for (int j = 0; j < current_word.length; j++) {
                word_vowels.add(current_word[j]);
            }
            for (char x : vowels_grouped){
                if (word_vowels.contains(x)) {
                    vowels.add(x);
                }
            }
            Collections.sort(vowels);
            String words = String.valueOf(vowels);
            preReady.add(words);
            for (int p = 0; p < preReady.size(); p++) {
                for (int z = p + 1; z < preReady.size(); z++) {
                    answer.add(arr[0]);
                    if (preReady.get(p).equals(preReady.get(z))) {
                        answer.add(arr[i]);
                    }else{
                        answer.add(arr[0]);
                    }
                }
            }
        }
        return (answer);
    }

    public static boolean Num6(String number){
        long number2 = Long.parseLong(number);
        char [] number_char = Long.toString(number2).toCharArray();
        int[] digit_arr = new int[number_char.length];
        for (int i = 0; i < digit_arr.length-1; i++) {
            digit_arr[i] = Integer.parseInt(String.valueOf(number_char[i]));
        }
        int control_digit = Integer.parseInt(String.valueOf(number_char[number_char.length-1]));
        if ((digit_arr.length < 13) | (digit_arr.length > 19)) {
            return (false);
        }
        for (int i = 0; i < digit_arr.length; i++) {
            if (i % 2 == digit_arr.length % 2) {
                int doubleDigit = digit_arr[i] * 2;
                if(doubleDigit > 9){
                    doubleDigit = 2 * digit_arr[i] - 9;
                }
                digit_arr[i] = doubleDigit;
            }
        }
        int sum = 0;
        for (int i = 0; i < digit_arr.length; i++){
            sum += digit_arr[i];
        }
        int last_of_sum = Integer.parseInt(String.valueOf(String.valueOf(sum).charAt(String.valueOf(sum).length()-1)));
        return (10-last_of_sum == control_digit);
    }

    public static String Num7(int number){
        int units = number % 10;
        int dozens = (number % 100 - units) / 10;
        int hundreds = (number - dozens - units) / 100;
        StringBuilder answer = new StringBuilder();
        String[] digit_words = new String[]{"-", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] dozens_words = new String[]{"-", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
        String[] dozens_before = new String[]{"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        if (hundreds > 0) {
            answer.append(digit_words[hundreds]);
            answer.append(" hundred ");
        }
        if (dozens > 1) {
            answer.append(dozens_words[dozens] + " ");
            if (units > 0) {
                answer.append(digit_words[units]);
            }
        } else if (dozens > 0) {
            answer.append(dozens_before[units]);
        } else {
            answer.append(digit_words[units]);
        }
        return (answer.toString());
    }

    public static String Num8(String str){
        String sha = org.apache.commons.codec.digest.DigestUtils.sha256Hex(str);
        return (sha);
    }

    public static String Num9(String str){
        str = str.toLowerCase();
        String[] words = str.split(" ");
        for (int i = 0; i < words.length; i++) {
            if ((!words[i].equals("and")) && (!words[i].equals("the")) && (!words[i].equals("of")) && (!words[i].equals("in"))) {
                words[i] = words[i].substring(0, 1).toUpperCase() + words[i].substring(1);
                String defis = words[i];
                for (int j = 0; j < defis.length(); j++) {
                    if (defis.charAt(j) == '-') {
                        int first_after = words[i].indexOf("-") + 1;
                        words[i] = words[i].substring(0, 1).toUpperCase() + words[i].substring(1, first_after) + words[i].substring(first_after , first_after + 1).toUpperCase() + words[i].substring(first_after+1);
                    }
                }
            }
        }
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            answer.append(words[i] + " ");
        }
        return (answer.toString());
    }

    //№10
    public static StringBuilder[] hexLattice(int n){
        if (n == 1) {
            return (new StringBuilder[]{new StringBuilder("o")});
        }
        int x = 1;
        int centernum = 0;
        boolean rightnum = false;
        for (int i = 1; x <= n; i++) {
            x += 6 * i;
            centernum = (i*2)+1;
            if (x == n) {
                rightnum = true;
                break;
            }
        }
        if (!rightnum){
            return (new StringBuilder[]{new StringBuilder("Incorrect number")});
        }
        StringBuilder[] hexfigure = new StringBuilder[centernum];
        StringBuilder currentstr = new StringBuilder();
        for (int i=0; i<centernum; i++) {
            currentstr = new StringBuilder("");
            if (i==centernum/2) { //центральная строка в которой будут o
                for (int j=0; j<centernum; j++) {
                    currentstr.append("o ");
                }
                currentstr.replace(currentstr.length()-1, currentstr.length(), "\n");
            } else if (i < centernum/2){ //что будет выше нее строки и также сколько в них о
                int lengthString = centernum + i - centernum/2;
                for (int j=0; j<centernum/2-i; j++) {
                    currentstr.append(" ");
                }
                for (int j=0; j<lengthString; j++) {
                    currentstr.append("o ");
                }
                currentstr.replace(currentstr.length()-1, currentstr.length(), "\n");
            } else { //все что ниже средней строки
                int lengthString = centernum - i + (centernum-1)/2;
                for (int j=0; j<i-centernum/2; j++) {
                    currentstr.append(" ");
                }
                for (int j=0; j<lengthString; j++) {
                    currentstr.append("o ");
                }
                currentstr.replace(currentstr.length()-1, currentstr.length(), "\n");
            }
            hexfigure[i] = currentstr;
        }
        return (hexfigure);
    }
}