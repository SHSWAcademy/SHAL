import java.util.*;
import java.io.*;

public class BOJ2178 {
    static int[][] board;
    static boolean[][] visited;
    static int n, m;
    static int[] dr = {-1, 1, 0, 0}; //상 하 좌 우
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);

        board = new int[n][m];;
        visited = new boolean[n][m];

        for (int i=0; i<n; i++) {
            String str = br.readLine();
            for (int j=0; j<m; j++) {
                board[i][j] = str.charAt(j) - '0';
            }
        }

        bfs();
    }

    static void bfs() {
        Deque<Node> q = new ArrayDeque<>();
        Node start = new Node(0, 0); // 시작점 설정
        visited[start.row][start.col] = true;    // 방문배열에 방문처리 (첫번째 노드)
        q.offer(start);    // Q에 삽입

        while (!q.isEmpty()) {
            Node nowNode = q.poll();

            for (int i=0; i<4; i++) {
                Node nextNode = new Node(nowNode.row+dr[i], nowNode.col+dc[i]);

                // 상 하 좌 우 탐색 시 배열 길이 초과 거르기
                if (nextNode.row < 0 || nextNode.row >= n || nextNode.col < 0 || nextNode.col >= m) {
                    continue;
                }

                // 방문한 노드랑 0 빼고
                if (visited[nextNode.row][nextNode.col] || board[nextNode.row][nextNode.col] == 0) {
                    continue;
                }

                visited[nextNode.row][nextNode.col] = true; // 안걸러졌으면 방문 배열에 추가
                board[nextNode.row][nextNode.col] += board[nowNode.row][nowNode.col];   // 배열 경로에 1 누적합
                q.offer(nextNode);
            }
        }
        System.out.println(board[n-1][m-1]);
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