import java.util.*;
import java.io.*;

public class BOJ4179 {
    static char[][] board;
    static int n, m;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] fire;
    static int[][] ji;
    static int fr, fc, jr, jc;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");

        n = Integer.parseInt(temp[0]);
        m = Integer.parseInt(temp[1]);

        fire = new int[n][m];
        ji = new int[n][m];
        board = new char[n][m];

        // 맵 그리기
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = str.charAt(j);
                ji[i][j] = -1;
                fire[i][j] = -1;
            }
        }

        // 시작점 찾기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'J') {
                    // 지훈이 시작
                    jr = i;
                    jc = j;
                }

                if (board[i][j] == 'F') {
                    // 불 시작
                    fr = i;
                    fc = j;
                }
            }
        }
        // 불먼저
        bfsF(fr, fc);

        // 지훈이
        bfsJ(jr, jc);
    }

    static void bfsF(int r, int c) {
        Deque<Node> q = new ArrayDeque<>();
        Node nowNode = new Node(r, c);
        q.offer(nowNode);
        fire[r][c] = 0;

        while (!q.isEmpty()) {
            nowNode = q.poll();

            for (int i = 0; i < 4; i++) {
                Node nextNode = new Node(nowNode.row + dr[i], nowNode.col + dc[i]);

                if (nextNode.row < 0 || nextNode.row >= n || nextNode.col < 0 || nextNode.col >= m) {
                    continue;
                }

                if (board[nextNode.row][nextNode.col] == '#' || fire[nextNode.row][nextNode.col] >= 0) {
                    continue;
                }

                q.offer(nextNode);
                fire[nextNode.row][nextNode.col] = fire[nowNode.row][nowNode.col] + 1;
            }
        }
    }

    static void bfsJ(int r, int c) {
        Deque<Node> q = new ArrayDeque<>();
        Node nowNode = new Node(r, c);
        q.offer(nowNode);
        ji[r][c] = 0;

        while (!q.isEmpty()) {
            nowNode = q.poll();

            for (int i = 0; i < 4; i++) {
                Node nextNode = new Node(nowNode.row + dr[i], nowNode.col + dc[i]);

                if (nextNode.row < 0 || nextNode.row >= n || nextNode.col < 0 || nextNode.col >= m) {
                    System.out.println(ji[nowNode.row][nowNode.col]+1);
                    return;
                }
                if (board[nextNode.row][nextNode.col] == '#') {
                    continue;
                }
                if (ji[nextNode.row][nextNode.col] != -1 && fire[nextNode.row][nextNode.col] <= ji[nowNode.row][nowNode.col]) {
                    continue;
                }
                q.offer(nextNode);
                ji[nextNode.row][nextNode.col] = ji[nowNode.row][nowNode.col] + 1;
            }
        }
        System.out.println("IMPOSSIBLE");
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
