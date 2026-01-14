import java.uti.*;
import java.io.*;

class Main {
    static int n;
    static int m;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] board;
    static boolean[][] visited;
    StringTokenizer st;

    static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // BFS 세팅
        board = new int[n][m];
        visited = new boolean[n][m];

        Queue<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(0, 0,));
        visited[0][0] = true;

        int result = BFS(q);
        // 출력
        System.out.println(result);
    }

    private static int BFS(Queue<Pair> q) {
        int result = 0;




        return result;
    }


}