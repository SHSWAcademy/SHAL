/*
push X: 정수 X를 큐에 넣는 연산이다.
pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
size: 큐에 들어있는 정수의 개수를 출력한다.
empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
*/
import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        
        int n = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String cmd = st.nextToken();
            
            if ("push".equals(cmd)) {
                queue.offer(Integer.parseInt(st.nextToken()));
            } else if ("pop".equals(cmd)) {
                sb.append(!queue.isEmpty() ? queue.pop() + "\n" : -1 + "\n");
            } else if ("size".equals(cmd)) {
                sb.append(queue.size() + "\n");
            } else if ("empty".equals(cmd)) {
                sb.append(!queue.isEmpty() ? 0 + "\n" : 1 + "\n");
            } else if ("front".equals(cmd)) {
                sb.append(!queue.isEmpty() ? queue.peek() + "\n" : -1 + "\n");
            } else if ("back".equals(cmd)) {
                sb.append(!queue.isEmpty() ? queue.peekLast() + "\n" : -1 + "\n");
            }
           
        }
        
        System.out.print(sb.toString());
    }
}
