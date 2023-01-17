import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BOJ_26260_이가_빠진_이진_트리 {
    static int N;
    static int[] arr;
    static List<Integer> list;
    static int num;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = Integer.parseInt(scanner.nextLine());
        list = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        num = Integer.parseInt(scanner.nextLine());
        list.remove((Integer) (-1));
        list.add(num);
        arr = list.stream().sorted().mapToInt(Integer::intValue).toArray();

        System.out.println(postorder(0, N - 1));

    }

    static private String postorder(int start, int end){
        if (start == end){
            return String.valueOf(arr[start])+ " ";
        }
        int mid = (start + end) / 2;
        return (postorder(start, mid - 1)) + (postorder(mid + 1, end)) + (arr[mid]) + " ";
    }
}
