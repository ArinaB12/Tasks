public class Tasks {

    public static void main(String[] args){
        System.out.println("Задача1");
        System.out.println("remainer(1, 3) -> " + Num1 (1,3));
        System.out.println("remainer(3, 4) -> " + Num1 (3,4));
        System.out.println("remainer(-9, 45) -> " + Num1 (-9,45));
        System.out.println("remainer(5, 5) -> " + Num1 (5,5));
        System.out.println("Задача 2");
        System.out.println("triArea(3, 2) -> " + Num2 (3, 2));
        System.out.println("triArea(7, 4) -> " + Num2 (7, 4));
        System.out.println("triArea(10, 10) -> " + Num2 (10, 10));
        System.out.println("Задача 3");
        System.out.println("animals(2, 3, 5) -> " + Num3 (2, 3, 5));
        System.out.println("animals(1, 2, 3) -> " + Num3 (1, 2, 3));
        System.out.println("animals(5, 2, 8) -> " + Num3 (5, 2, 8));
        System.out.println("Задача 4");
        System.out.println("profitableGamble(0.2, 50, 9) -> " + Num4 ( 0.2, 50, 9));
        System.out.println("profitableGamble(0.9, 1, 2) -> " + Num4 (0.9, 1, 2));
        System.out.println("profitableGamble(0.9, 3, 2) -> " + Num4 (0.9, 3, 2));
        System.out.println("Задача 5");
        System.out.println("operation(24, 15, 9) -> " + Num5 (24, 15, 9));
        System.out.println("operation(24, 26, 2) -> " + Num5 (24, 26, 2));
        System.out.println("operation(15, 11, 11) -> " + Num5 (15, 11, 11));
        System.out.println("Задача 6");
        System.out.println("ctoa('A') -> " + Num6 ('A'));
        System.out.println("ctoa('m') -> " + Num6 ('m'));
        System.out.println("ctoa('[') -> " + Num6 ('['));
        System.out.println("ctoa('\\') -> " + Num6 ('\\'));
        System.out.println("Задача 7");
        System.out.println("addUpTo(3) -> " + Num7 (3));
        System.out.println("addUpTo(10) -> " + Num7 (10));
        System.out.println("addUpTo(7) -> " + Num7 (7));
        System.out.println("Задача 8");
        System.out.println("nextEdge(8, 10) -> " + Num8 (8, 10));
        System.out.println("nextEdge(5, 7) -> " + Num8 (5, 7));
        System.out.println("nextEdge(9, 2) -> " + Num8 (9, 2));
        System.out.println("Задача 9");
        System.out.println("sumOfCubes([1, 5, 9]) -> " + Num9 (new int[]{1, 5, 9}));
        System.out.println("sumOfCubes([3, 4, 5]) -> " + Num9 (new int[]{3, 4, 5}));
        System.out.println("sumOfCubes([2]) -> " + Num9 (new int[]{2}));
        System.out.println("sumOfCubes([]) -> " + Num9 (new int[]{0}));
        System.out.println("Задача 10");
        System.out.println("abcmath(42, 5, 10) -> " + Num10 (42, 5, 10));
        System.out.println("abcmath(5, 2, 1) -> " + Num10 (5, 2, 1));
        System.out.println("abcmath(1, 2, 3) -> " + Num10 (1, 2, 3));
    }

    public static int Num1(int x, int y){
        return (x % y);
    }

    public static int Num2(int x, int y){
        return (x * y / 2);
    }

    public static int Num3(int x, int y, int z){
        int chicken = 2;
        int cow = 4;
        int pig = 4;
        return (x * chicken + y * cow + z * pig);
    }

    public static boolean Num4(double prob, int prize, int pay){
        return (prob * prize > pay);
    }

    public static String Num5(int N, int a, int b){
        if (a + b == N) {
            return ("added");
        }
        else if (a - b == N) {
            return ("subtracted");
        }
        else if (a * b == N) {
            return ("multiplied");
        }
        else if (a / b == N) {
            return ("divided");
        }
        else  {
            return ("none");
        }
    }

    public static int Num6(char c){
            return (int) c;
    }

    public static int Num7(int x){
        return (x * (1 + x) / 2);
    }

    public static int Num8(int x, int y){
        return (x + y - 1);
    }

    public static int Num9(int [] arr){
            int sum = 0;
            for(int i = 0; i < arr.length; i++){
                sum += Math.pow(arr[i], 3);
            }
            return sum;
    }

    public static boolean Num10(int a, int b, int c){
        return ((a<<b)%c==0);
    }
}
