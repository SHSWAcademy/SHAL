import java.util.*;
import java.io.*;

public class Main {
static StringTokenizer st;
static int x;
static int y;
static int[] dx = {1, 0, -1, 0};
static int[] dy = {0, 1, 0, -1};
static int[][] board;
static boolean[][] visited;
static class Pair {
    int x;
    int y;
    int cnt;

    Pair (int x, int y) {
        this.x = x;
        this.y = y;
    }

    Pair (int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}

public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    st = new StringTokenizer(br.readLine(), " ");
    x = Integer.parseInt(st.nextToken());
    y = Integer.parseInt(st.nextToken());

    board = new int[y][x];
    visited = new boolean[y][x];

    List<Pair> starts = new ArrayList<>();

    for (int i = 0; i < y; i++) {
        st = new StringTokenizer(br.readLine(), " ");
        for (int j = 0; j <x; j++) {
            board[i][j] = Integer.parseInt(st.nextToken());
            if (board[i][j] == 1) {
                starts.add(new Pair(j, i));
            }
        }
    }

    // 예제 입력 5 : 처음부터 모두 익어있다면
    boolean startCheck = true;
    for (int i = 0; i < y; i++) {
        for (int j = 0; j < x; j++) {
            if (board[i][j] == 0) {
                startCheck = false;
            }
        }
    }
    if (startCheck) {
        System.out.println(0);
        return;
    }

    int result = bfs(starts);
    System.out.println(result);
}
static int bfs(List<Pair> starts) {
    int result = -1;

    Queue<Pair> q = new ArrayDeque<>();

    // 시작점들을 모두 큐에 넣고 방문 처리
    for (Pair start : starts) {
        q.offer(new Pair(start.x, start.y, 0));
        visited[start.y][start.x] = true;
    }

    while (!q.isEmpty()) {
        Pair pollQ = q.poll();
        int curX = pollQ.x;
        int curY = pollQ.y;
        int curCnt = pollQ.cnt;

            /* base condition : 방문해야 할 모든 점이 방문했다면 종료
            if (isAllVisited()) {
                result = -1;
                break;
            }
            */

        // 4방향 탐색
        for (int i = 0; i < 4; i++) {
            int nx = curX + dx[i];
            int ny = curY + dy[i];

            if (nx < 0 || ny < 0 || nx >= x || ny >= y) continue;
            if (visited[ny][nx] || board[ny][nx] != 0) continue;

            result = curCnt + 1;
            Pair newP = new Pair(nx, ny, result);
            q.offer(newP);
            visited[ny][nx] = true;

        }
    }

    // 예제 2 : 토마토가 모두 익지 못하는 경우
    for (int i = 0; i < y; i++) {
        for (int j = 0; j < x; j++) {
            if (board[i][j] != -1 && !visited[i][j]) {
                result = -1;
                return result;
            }
        }
    }

    return result;
}

}
