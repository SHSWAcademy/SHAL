import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        ArrayDeque<Tower> stack = new ArrayDeque<>();
        
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        loop:
        for (int i = 1; i <= n; i++) {
            int height = Integer.parseInt(st.nextToken());
            int order = i;
            Tower tower = new Tower(order, height);
            
            if (stack.isEmpty()) {
                sb.append(0 + " ");
                stack.push(tower);

            } else if (stack.peekFirst().height < tower.height) {
                while (stack.peekFirst().height < tower.height) {
                    stack.pop();
                    if (stack.isEmpty()) {
                        sb.append(0 + " ");
                        stack.push(tower);
                        continue loop;
                    }
                }
                sb.append(stack.peekFirst().order + " ");
                stack.push(tower);
            } else if (stack.peekFirst().height >= tower.height) {
                sb.append(stack.peekFirst().order + " ");
                stack.push(tower);
            }
        }
        System.out.print(sb.toString());
    }
    static class Tower {
        private int order;
        private int height;

        public Tower(int order, int height) {
            this.order = order;
            this.height = height;
        }
    }
}
