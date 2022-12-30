import java.util.Scanner;

public class Num4 {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        double prob = scanner.nextDouble();
        int prize = scanner.nextInt();
        int pay = scanner.nextInt();
        System.out.println(prob * prize > pay);
    }
}