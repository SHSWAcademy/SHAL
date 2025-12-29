import java.io.*;
import java.util.*;

public class BOJ18258 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> q = new ArrayDeque<>();
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String[] order = br.readLine().split(" ");
            if (order[0].equals("push")) {
                q.offer(Integer.parseInt(order[1]));
            } else if (order[0].equals("front")) {
                if (q.isEmpty()) sb.append(-1+"\n");
                else sb.append(q.peek()+"\n");
            } else if (order[0].equals("pop")) {
                if (q.isEmpty()) sb.append(-1+"\n");
                else sb.append(q.poll()+"\n");
            } else if (order[0].equals("size")) {
                sb.append(q.size()+"\n");
            } else if (order[0].equals("empty")) {
                if (q.isEmpty()) sb.append("1"+"\n");
                else sb.append("0"+"\n");
            } else if (order[0].equals("back")) {
                if (q.isEmpty()) sb.append("-1"+"\n");
                else sb.append(q.peekLast()+"\n");
            }
        }
        System.out.println(sb);
    }
}
