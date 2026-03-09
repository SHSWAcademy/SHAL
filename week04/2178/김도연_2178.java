import java.util.*;
import java.io.*;

public class Main {
    static int n = 0;
    static int m = 0;
    static int[][] map;
    static int[][] visited;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        map = new int[n][m];
        visited = new int[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = Character.getNumericValue(line.charAt(j));
            }
        }
        bfs();
    }

    static void bfs() {
    	ArrayDeque<int[]> dq = new ArrayDeque<>();
    	dq.offer(new int[] {0, 0});
    	visited[0][0]++;
    	
    	int[] dx = {-1, 1, 0, 0};
    	int[] dy = {0, 0, -1, 1};
    	
    	while (!dq.isEmpty()) {
    		int[] cur = dq.poll();
    		int x = cur[0];
    		int y = cur[1];
    		
    		if (x == n - 1 && y == m-1) {
    			System.out.println(visited[x][y]);
    			break;
    		}
    		
    		for (int i = 0; i < 4; i++) {
    			int nx = x + dx[i];
    			int ny = y + dy[i];
    			
    			if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
    				continue;
    			}
    			
    			if (map[nx][ny] == 0 || visited[nx][ny] > 0) {
    				continue;
    			}
    			dq.offer(new int[] {nx, ny});
    			visited[nx][ny] = visited[x][y] + 1;
    		}
    		
    	}
    }
}