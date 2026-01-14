import java.util.*;
import java.io.*;

public class Main {
    static int r;
    static int c;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static char[][] board;
    static boolean[][] visited;
    static int[][] fireMinute;

    static class Pair {
        int x;
        int y;
        int minute;

        public Pair(int x, int y, int minute) {
            this.x = x;
            this.y = y;
            this.minute = minute;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        r = Integer.parseInt(input[0]);
        c = Integer.parseInt(input[1]);

        board = new char[r][c];
        visited = new boolean[r][c];
        fireMinute = new int[r][c];


        Queue<Pair> qj = new ArrayDeque<>();
        Queue<Pair> qf = new ArrayDeque<>();

        for (int i = 0; i < r; i++) {
            Arrays.fill(fireMinute[i], -1);
            String line = br.readLine();
            for (int j = 0; j < c; j++) {
                board[i][j] = line.charAt(j);

                if (board[i][j] == 'F') {
                    qf.offer(new Pair(j, i, 0));
                    fireMinute[i][j] = 0; // 불 시작점
                } else if (board[i][j] == 'J') {
                    qj.offer(new Pair(j, i, 0));
                    visited[i][j] = true;
                }
            }
        }

        int result = func(qj, qf);
        if (result == 0) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(result);
        }
    }

    private static int func(Queue<Pair> qj, Queue<Pair> qf) {
        int result = 0;



        // fireMinute 시간 할당
        while (!qf.isEmpty()) {

            Pair pollF = qf.poll();
            int curX = pollF.x;
            int curY = pollF.y;
            int curMin = pollF.minute;

            // 검증
            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if (nx < 0 || nx >= c || ny < 0 || ny >= r) continue;
                if (fireMinute[ny][nx] != -1 || board[ny][nx] == '#') continue;

                Pair newF = new Pair(nx, ny, curMin + 1);
                fireMinute[ny][nx] = curMin + 1;
                qf.offer(newF);
            }


        }

        while (!qj.isEmpty()) {
            Pair pollJ = qj.poll();
            int curX = pollJ.x;
            int curY = pollJ.y;
            int curMin = pollJ.minute;

            // 검증
            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                // 탈출에 성공 시
                if (nx < 0 || nx >= c || ny < 0 || ny >= r) {
                    return curMin + 1;
                }

                // 탈출하지 않았을 경우
                if (visited[ny][nx] || board[ny][nx] == '#') continue;
                if (fireMinute[ny][nx] != -1 && fireMinute[ny][nx] <= curMin + 1) continue;
                
                Pair newJ = new Pair(nx, ny, curMin + 1);
                visited[ny][nx] = true;
                qj.offer(newJ);
            }
        }
        
        return result;
    }
}

