import java.util.Scanner;

public class Num3 {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        // Объявление видов животных
        int chicken = 2;
        int cow = 4;
        int pig = 4;
        // Кол-во куриц
        int x = scanner.nextInt();
        // Кол-во коров
        int y = scanner.nextInt();
        // Кол-во свинок
        int z = scanner.nextInt();
        System.out.println(x * chicken + y * cow + z * pig);
    }
}