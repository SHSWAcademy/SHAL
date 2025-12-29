import java.util.*;
import java.io.*;

class Main {
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            q.offer(i);
        }
        
        int answer = 0;
        while (true) {
            if (q.size() == 1) {
                answer = q.poll();
                break;
            }
            int first = q.poll();
            int second = q.poll();
            q.offer(second);
        }
        
        System.out.println(answer);
    }
}
