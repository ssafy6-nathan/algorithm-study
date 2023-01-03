import java.util.Scanner;

public class BOJ_1094_막대기 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();

        int result = 0;

        while (num > 0){
            if(num % 2 == 1){
                result++;
            }
            num /= 2;
        }

        System.out.println(result);
    }
}
