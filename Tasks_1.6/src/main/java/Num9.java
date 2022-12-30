public class Num9 {
    public static void main(String[] args) {
        int[] arr = new int[args.length];
        for (int x = 0; x < arr.length; x++){
            arr[x] = Integer.parseInt(args[x]);
        }
        System.out.println(sumOfCubes(arr));
    }

    static int sumOfCubes(int[] arr) {
        int sum = 0;
        for (int y : arr) {
            sum += Math.pow(y, 3);
        }
        return sum;
    }
}