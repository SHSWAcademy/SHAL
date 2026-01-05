import java.util.*;
import java.io.*;

public class Main {
		
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 숫자 배열로 한번에 받는데, N이 최대 50만이므로 st
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int cnt = 1;
		int curHeight = 0;
		StringBuilder sb = new StringBuilder();
		Stack<int[]> stack = new Stack<>();
		
		while(st.hasMoreTokens()) {
			curHeight = Integer.parseInt(st.nextToken());
			
			// 현재 탑보다 낮은 탑이 스택에 있으면 제거
			while (!stack.isEmpty() && stack.peek()[0] < curHeight) {
				stack.pop();
			}
			
			// 수신 탑인지 판단 
			if (stack.isEmpty()) { // 왼쪽에 더 높은 탑이 없을 때는 수신탑 없으므로 0 
				sb.append(0).append(" ");
			} else { // 맨 위가 가장 높은 탑일 때 
				sb.append(stack.peek()[1]).append(" ");
			}
			// 현재 탑 push 
			stack.push(new int[] {curHeight, cnt}); // [높이, 인덱스(탑번호?)]
			cnt++;
		}
		
		System.out.println(sb.toString());
	}

}
