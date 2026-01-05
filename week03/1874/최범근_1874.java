import java.util.*;
import java.io.*;

public class BOJ1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> stack = new ArrayDeque<>();
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int top = 0;

        loop:
        for (int i=1; i<=n; i++) {
            int m = Integer.parseInt(br.readLine());

            if (top < m) {
                for (int j = top+1; j<=m; j++) {
                    stack.push(j);
                    sb.append("+\n");
                }
                top = stack.pop();
                sb.append("-\n");
            } else if (top > m) {
                if (m == stack.peek()) {
                    stack.pop();
                    sb.append("-\n");
                } else {
                    sb = new StringBuilder();
                    sb.append("NO");
                    break loop;
                }
            }
        }
        System.out.println(sb.toString());
    }
}
