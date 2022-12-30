import java.util.Scanner;

public class Num2 {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        // Высота
        int x = scanner.nextInt();
        // Основание
        int y = scanner.nextInt();
        // Площадь
        System.out.println(x * y / 2);
    }
}