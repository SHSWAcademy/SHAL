import java.util.*;
import java.io.*;

public class BOJ7576 {
    static int[][] board;
    static int[][] newBoard;
    static int n, m;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static Deque<Node> q = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        List<Integer> list = new ArrayList<>();
        boolean check = false;
        int count = 0;

        n = Integer.parseInt(nm[1]);
        m = Integer.parseInt(nm[0]);

        board = new int[n][m];
        newBoard = new int[n][m];
        // 입력값
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                newBoard[i][j] = board[i][j];
                // 시작점 발견 시 q에 offer 
                if (board[i][j] == 1) {
                    q.offer(new Node(i, j));
                }

                // 0입 없는경우 판별을 위함
                if (board[i][j] == 0) {
                    count++;
                }
            }
        }

        bfs();

        // 최종 배열로 체크 
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                list.add(board[i][j]);
                if (board[i][j] == 0) {
                    check = true;
                }
            }
        }

        // 0이 남아있으면 true
        if (check) {
            System.out.println(-1);
        } else if (count == 0) {    // 0이 없는경우 0출ㄹ력
            System.out.println(0);
        } else {    // 아니라면 맥스값 출력
            System.out.println(Collections.max(list)-1);
        }
    }

    static void bfs() {
        while (!q.isEmpty()) {
            Node nowNode = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = nowNode.row + dr[i];
                int nc = nowNode.col + dc[i];

                if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
                    continue;
                }

                // 체크용 배열에 1이거나 -1이면 탐색 불가
                if (newBoard[nr][nc] == 1 || board[nr][nc] == -1) {
                    continue;
                }

                newBoard[nr][nc] = 1;     // 체크용 배열에 1
                q.offer(new Node(nr, nc));
                board[nr][nc] = board[nowNode.row][nowNode.col] + 1;    //누적합 
            }
        }
    }

    static class Node {
        int row;
        int col;

        Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
