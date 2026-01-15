import java.util.*;
import java.io.*;

class Main {
    static int n;
    static int k;
    static List<Integer> outputs = new ArrayList<>();
    static int[] dx;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        k = Integer.parseInt(input[1]);
        dx = new int[]{-1, 1, n * 2};


        System.out.println(func(););
        for (int o : outputs) {
            System.out.print(o + " ");
        }
    }

    private static int func() {
        int[] parent = new int[100001]; // parent[x] : x를 오기 전에 온 위치
        Arrays.fill(parent, -1);
        boolean[] visited = new boolean[100001];

        Queue<Integer> q = new ArrayDeque<>();
        // 시작 지점 방문 처리
        q.offer(n);
        visited[n] = true;

        // 시작점에서 각 위치까지 dist
        int[] dist = new int[100001];
        dist[n] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();

            // 종료 조건
            if (cur == k) {
                break;
            }

            for (int i = 0; i < 3; i++) {
                if (i == 2) {
                    int nx = cur * 2;
                    if (nx < 0 || nx > 100000) continue;
                    if (!visited[nx]) {
                        visited[nx] = true;
                        parent[nx] = cur; // 부모 기록
                        dist[nx] = dist[cur] + 1; // 거리 기록
                        q.offer(nx);
                    }
                } else {
                    int nx = dx[i] + cur;
                    if (nx < 0 || nx > 100000) continue;
                    if (!visited[nx]) {
                        visited[nx] = true;
                        parent[nx] = cur; // 부모 기록
                        dist[nx] = dist[cur] + 1; // 거리 기록
                        q.offer(nx);
                    }
                }

            }

        }

        // 경로 백트래킹
        List<Integer> path = new ArrayList<>();
        for (int i = k; i != -1; i = parent[i]) {
            path.add(i);
        }
        Collections.reverse(path);
        outputs = path;

        return dist[k]; // 최소 이동 횟수 반환
    }
}

