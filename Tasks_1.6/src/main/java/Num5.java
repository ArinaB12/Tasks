import java.util.Scanner;

public class Num5 {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        if (a + b == N) {
            System.out.println("added");
        }
        else if (a - b == N) {
            System.out.println("subtracted");
        }
        else if (a * b == N) {
            System.out.println("multiplied");
        }
        else if (a / b == N) {
            System.out.println("divided");
        }
        else  {
            System.out.println("none");
        }
    }
}