import java.io.*;
import java.util.*;

public class Main{
    private static int[][] graph;
    private static Deque<Node> queue = new ArrayDeque<>();
    private static int N;
    private static int M;
    private static int dr[] = {-1, 1, 0, 0};
    private static int dc[] = {0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        
        graph = new int[N][M];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (graph[i][j] == 1) {
                    queue.offer(new Node(i, j));
                }
            }
        }
        bfs();
        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                if (graph[i][j] > max) max = graph[i][j];
            }
        }
        System.out.println(max - 1);
    }
    private static void bfs() {
        while (!queue.isEmpty()) {
            Node nowNode = queue.poll();
            
            for (int i = 0; i < 4; i++) {
                Node nextNode = new Node(nowNode.row + dr[i], nowNode.col + dc[i]);
                
                if (nextNode.row < 0 || nextNode.row >= N || nextNode.col < 0 || nextNode.col >= M) continue;
                if (graph[nextNode.row][nextNode.col] != 0) continue;
                
                queue.offer(nextNode);
                graph[nextNode.row][nextNode.col] = graph[nowNode.row][nowNode.col] + 1;
            }
        }
    }
}
class Node {
    int row;
    int col;
    
    public Node(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
