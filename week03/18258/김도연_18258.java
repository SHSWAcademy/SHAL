import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		ArrayDeque<Integer> dq = new ArrayDeque<>();
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			
			if (cmd.charAt(0) == 'p') { // push
				if (cmd.charAt(1) == 'u') { 
					dq.offer(Integer.parseInt(st.nextToken()));
				} else { // pop
					sb.append((dq.isEmpty() ? -1 : dq.poll()) + "\n");
				}
			} else if (cmd.charAt(0) == 'f') { // front
				sb.append((dq.isEmpty() ? -1 : dq.peekFirst()) + "\n");
			} else if (cmd.charAt(0) == 'b') { // back
				sb.append((dq.isEmpty() ? -1 : dq.peekLast()) + "\n");
			} else if (cmd.charAt(0) == 's') { // size
				sb.append(dq.size() + "\n");
			} else { // empty
				sb.append((dq.isEmpty() ? 1 : 0) + "\n");
			}
		}
		System.out.println(sb);
	}
}