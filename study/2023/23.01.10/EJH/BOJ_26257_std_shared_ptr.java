import java.util.*;

public class BOJ_26257_std_shared_ptr {

    static class Node{
        private int num;

        public Node(int num) {
            this.num = num;
        }
        public int getNum() {
            return num;
        }
        public void setNum(int num) {
            this.num = num;
        }
    }

    static int N, M, Q;
    static List<Node> shared_ptr;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        N = arr[0];
        M = arr[1];
        Q = arr[2];

        shared_ptr = new ArrayList<>();


        for (int i = 0; i < M; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            shared_ptr.add(new Node(number));
        }

        for (int i = 0; i < Q; i++) {
            String[] command = (scanner.nextLine().split(" "));
            run(command);
        }
        Set<Integer> numbers = new HashSet<>();
        for (int i = 0; i < M; i++) {
            numbers.add(shared_ptr.get(i).getNum());
        }
        numbers.remove(0);
        Integer[] nums = numbers.stream().sorted().toArray(Integer[]::new);
        StringBuilder sb = new StringBuilder();
        sb.append(nums.length + "\n");
        for (int i = 0; i < nums.length; i++) {
            sb.append(nums[i] + "\n");
        }
        System.out.println(sb);
    }

    private static void run(String[] command){
        switch (command[0]){
            case "assign":
                assign(command);
                break;
            case "swap":
                swap(command);
                break;
            case "reset":
                reset(command);
                break;
        }
    }
    private static void assign(String[] command){
        int x = Integer.parseInt(command[1]) - 1;
        int y = Integer.parseInt(command[2]) - 1;
        shared_ptr.get(x).setNum(shared_ptr.get(y).getNum());
    }
    private static void swap(String[] command){
        int x = Integer.parseInt(command[1]) - 1;
        int y = Integer.parseInt(command[2]) - 1;
        int temp_x = shared_ptr.get(x).getNum();
        int temp_y = shared_ptr.get(y).getNum();
        shared_ptr.get(x).setNum(temp_y);
        shared_ptr.get(y).setNum(temp_x);
    }
    private static void reset(String[] command){
        int x = Integer.parseInt(command[1]) - 1;
        shared_ptr.get(x).setNum(0);
    }
}


