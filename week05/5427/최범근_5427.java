import java.util.*;
import java.io.*;

public class BOJ5427 {
    static int h, n, m ;
    static char[][] board;
    static int[][] fire;
    static int[][] sang;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    // 불 큐
    static Deque<Node> fireQ = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        h = Integer.parseInt(br.readLine());

        for (int i=0; i<h; i++) {
            fireQ = new ArrayDeque<>();
            String[] str = br.readLine().split(" ");
            n = Integer.parseInt(str[1]);
            m = Integer.parseInt(str[0]);
            board = new char[n][m];
            fire = new int[n][m];
            sang = new int[n][m];

            // 판 그리기
            for (int f=0; f<n; f++) {
                String strTemp = br.readLine();
                for (int s=0; s<m; s++) {
                    board[f][s] = strTemp.charAt(s);
                    fire[f][s] = -1;
                    sang[f][s] = -1;
                }
            }

            // 불 먼저 시작점 찾고 돌리기
            for (int y=0; y<n; y++) {
                for (int u=0; u<m; u++) {
                    if (board[y][u] == '*') {
                        Node node = new Node(y, u);
                        fireQ.offer(node);
                        fire[y][u] = 0;
                    }
                }
            }
            bfsF();

            // 그다음 상근이
            for (int w=0; w<n; w++) {
                for (int e=0; e<m; e++) {
                    if (board[w][e] == '@') {
                        bfsS(w, e);
                    }
                }
            }
        }
    }

    static void bfsS(int r, int c) {
        Deque<Node> q = new ArrayDeque<>();
        Node nowNode = new Node(r, c);
        q.offer(nowNode);
        sang[r][c] = 0;

        while (!q.isEmpty()) {
            nowNode = q.poll();

            for (int i=0; i<4; i++) {
                Node nextNode = new Node(nowNode.row+dr[i], nowNode.col+dc[i]);
                int row = nextNode.row;
                int col = nextNode.col;

                if (row < 0 || row >= n || col < 0 || col >= m) {
                    System.out.println(sang[nowNode.row][nowNode.col]+1);
                    return;
                }
                if (board[row][col] == '#' || sang[row][col] != -1) continue;
                if (fire[row][col] != -1 && fire[row][col] <= sang[nowNode.row][nowNode.col] + 1) continue;

                q.offer(nextNode);
                sang[row][col] = sang[nowNode.row][nowNode.col] + 1;
            }
        }
        System.out.println("IMPOSSIBLE");
    }

    // 불 bfs
    static void bfsF() {
        while (!fireQ.isEmpty()) {
            Node nowNode = fireQ.poll();

            for (int i=0; i<4; i++) {
                Node nextNode = new Node(nowNode.row+dr[i], nowNode.col+dc[i]);
                int row = nextNode.row;
                int col = nextNode.col;

                if (row < 0 || row >= n || col < 0 || col >= m) continue;
                if (board[row][col] == '#' || fire[row][col] != -1) continue;

                fireQ.offer(nextNode);
                fire[row][col] = fire[nowNode.row][nowNode.col] + 1;
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