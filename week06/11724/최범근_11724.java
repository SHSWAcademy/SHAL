import java.util.*;
import java.io.*;

public class BOJ11724 {
    static Deque<Integer> stack;
    static boolean[] visited;
    static int n, m;
    static ArrayList<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int count = 0 ;
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);

        // arrylist들의 배열
        list = new ArrayList[n+1];
        stack = new ArrayDeque<>();
        visited = new boolean[n+1];

        // 초기화
        for (int i=0; i<n+1; i++) {
            list[i] = new ArrayList<>();
        }

        // 입력
        for (int i=0; i<m; i++) {
            String[] temp = br.readLine().split(" ");
            int u = Integer.parseInt(temp[0]);
            int v = Integer.parseInt(temp[1]);

            list[u].add(v);
            list[v].add(u);
        }

        // visited배열이 true가 될떄까지 dfs호출 횟수 카운트
        for (int i=1; i<visited.length; i++) {
            if (!visited[i]) {
                stack.push(i);
                visited[i] = true;
                dfs();
                count++;
            }
        }

        System.out.println(count);
    }

    static void dfs () {
        while (!stack.isEmpty()) {
            int now = stack.pop();

            for (int next : list[now]) {
                if (visited[next]) continue;

                visited[next] = true;
                stack.push(next);
            }
        }
    }
}
