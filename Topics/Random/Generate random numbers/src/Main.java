import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        Random random = new Random(a + b);
        int sum = 0;

        for(int x = 0; x < n; x++){
            sum += random.nextInt(b - a + 1) + a;

        }

        System.out.println(sum);


    }
}