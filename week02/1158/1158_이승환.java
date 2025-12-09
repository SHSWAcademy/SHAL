import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class B_1158_이승환 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		solution(n,m);
	}
	
	private static void solution(int n, int m) {
		List<Integer> list = new LinkedList<>();
		for(int i = 1; i <= n; i++) {
			list.add(i);
		}
		
		List<Integer> answer = new ArrayList<>();
		
		int index = 0;
		while(!list.isEmpty()) {
			index = (index+m-1) % list.size();
			int removed = list.remove(index);
			answer.add(removed);
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		for(int i = 0; i < answer.size(); i++) {
		    sb.append(answer.get(i));
		    if(i < answer.size() - 1) {
		        sb.append(", ");
		    }
		}
		sb.append(">");
		System.out.println(sb);
	}
}
