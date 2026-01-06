import java.util.*;
import java.io.*;

class Main {
    static int[] Row = {1, 0, -1, 0};
    static int[] Col = {0, 1, 0, -1};
    static int N;
    static int M;
    static int[][] board;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input, " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        visited = new boolean[N][M];
        // board 입력
        for (int i = 0; i < N; i++) {
            String nums = br.readLine();
            st = new StringTokenizer(nums);
            for (int j = 0; j < M; j++) {
                board[i][j] = nums.charAt(j) - '0';
            }
        }

        Deque<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(0, 0, 1));
        visited[0][0] = true;

        int result = bfs(q);
        System.out.println(result);

    }
    static int bfs(Deque<Pair> q) {
        int result = 0;
        while(true) {
            Pair pollP = q.poll();
            int curRow = pollP.rrow;
            int curCol = pollP.ccol;
            int curCnt = pollP.cnt;

            // base condition
            if (curRow == M - 1 && curCol == N - 1) {
                result = curCnt;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nextRow = curRow + Row[i];
                int nextCol = curCol + Col[i];


                // validate
                if (nextRow < 0 || nextRow >= M || nextCol < 0 || nextCol >= N) continue;
                if (visited[nextCol][nextRow] || board[nextCol][nextRow] == 0) continue;

                Pair newP = new Pair(nextCol, nextRow, curCnt+1);
                q.offer(newP);
                visited[nextCol][nextRow] = true;
            }

        }

        return result;
    }

    static class Pair {
        int rrow;
        int ccol;
        int cnt;
        Pair (int ccol, int rrow, int cnt) {
            this.ccol = ccol;
            this.rrow = rrow;
            this.cnt = cnt;
        }
    }
}
