import java.util.*;

public class BOJ_1325 {
    static int N;
    static int M;
    static int count;
    static int max;
    static List<Integer>[] list;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        list = new ArrayList[N + 1];
        max = 0;
        for(int i=0;i<=N;i++){
            list[i] = new ArrayList<>();
        }
        for (int i = 1; i <= M; i++)
        {
            int A = sc.nextInt();
            int B = sc.nextInt();
            list[B].add(A);
        }

        int[] result = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            count = 0;
            bfs(i);
            result[i] = count;
            max = Math.max(count, max);

        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (result[i] == max)
                sb.append(i+" ");
        }
        System.out.println(sb);

    }

    private static void bfs(int node)
    {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = true;
        while (!queue.isEmpty())
        {
            node = queue.remove();
            for (int next : list[node])
            {
                if (!visited[next])
                {
                    count++;
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
    }
}
