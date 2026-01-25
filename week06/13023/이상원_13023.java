import java.util.*;
import java.io.*;

class Main {
    static int n, m;
    static List<Integer>[] graph;
    static boolean found = false;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");
        n = Integer.parseInt(firstLine[0]);
        m = Integer.parseInt(firstLine[1]);

        // 그래프 초기화
        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();

        // 간선 입력 (양방향)
        for (int i = 0; i < m; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            graph[a].add(b);
            graph[b].add(a);
        }

        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            visited[i] = true;
            dfs(i, 1, visited); // 현재 노드, 깊이 1
            visited[i] = false;
            if (found) break;
        }

        System.out.println(found ? 1 : 0);
    }

    // 재귀 DFS
    static void dfs(int node, int depth, boolean[] visited) {
        if (depth == 5) { // 길이 4 경로 발견
            found = true;
            return;
        }

        for (int next : graph[node]) {
            if (!visited[next]) {
                visited[next] = true;
                dfs(next, depth + 1, visited);
                visited[next] = false; // 백트래킹
            }
        }
    }
}
