
import java.io.*;
import java.util.*;

public class B_3273_이승환 {
	public static void main(String[] args) throws IOException {
//		int n = 11;
//		int[] number = new int[] {5,12,7,10,9,1,2,3,11,6,8};
//		int x = 16;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		int[] number = new int[n];
		for (int i = 0; i < n; i++) {
		    number[i] = Integer.parseInt(st.nextToken());
		}

		int x = Integer.parseInt(br.readLine());

		solution(number, x);
	}
	
	private static void solution(int[] number, int x) {
			Set<Integer> set = new HashSet<>();// contains 검색은 HashSet이 빠르다.
			int count = 0;
			for(int i = 0; i<number.length; i++) {
			  set.add(x - number[i]);
			  if(set.contains(number[i]) && x-number[i] != number[i]) {// contains = 포함되어 있으면 true, 중복된 값은 빼고 16-8 != 8
				  count++;
			  }
		}
			System.out.println(count);
//			System.out.println(list);
	}
}
