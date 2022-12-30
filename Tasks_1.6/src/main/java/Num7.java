import java.util.Scanner;

public class Num7 {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        System.out.println(x * (1 + x) / 2);
    }
}