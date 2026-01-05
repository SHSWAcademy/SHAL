import java.util.*;
import java.io.*;

public class Main{
    private static final int[] dirR = {-1, 1, 0, 0}; // 상, 하, 좌, 우
    private static final int[] dirC = {0, 0, -1, 1}; // 상, 하, 좌, 우
    private static boolean[][] visited;
    private static int N;
    private static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        int[][] graph = new int[N][M];
        visited = new boolean[N][M];
        
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(line[j]);
            }
        }
        
        BFS(0, 0, graph);
    }
    public static void BFS(int row, int col, int[][] graph) {
        int[][] dist = new int[N][M];
        dist[row][col] = 1;
        
        ArrayDeque<Node> queue = new ArrayDeque<>();
        Node startNode = new Node(row, col);
        queue.offer(startNode);
        visited[startNode.row][startNode.col] = true;
        
        while (!queue.isEmpty()) {
            Node nowNode = queue.poll();
            // nowNode기준으로 상,하,좌,우 탐색하며 조건이 맞지 않는 좌표는 pass
            for (int i = 0; i < 4; i++) {
                Node nextNode = new Node(nowNode.row + dirR[i], nowNode.col + dirC[i]);
                if (nextNode.row < 0 || nextNode.row >= N || nextNode.col < 0 || nextNode.col >= M) {
                    continue;
                }
                if (visited[nextNode.row][nextNode.col] || graph[nextNode.row][nextNode.col] == 0) {
                    continue;
                }
                queue.offer(nextNode);
                visited[nextNode.row][nextNode.col] = true;
                dist[nextNode.row][nextNode.col] = dist[nowNode.row][nowNode.col] + 1;
            }
            
        }
        
        System.out.println(dist[N-1][M-1]);
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
