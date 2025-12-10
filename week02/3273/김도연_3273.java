package BOJ3273;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(br.readLine());
		
		int k = 0;
		while(st.hasMoreTokens()) {
			arr[k] = Integer.parseInt(st.nextToken());
			k++;
		}
		Arrays.sort(arr);

		int l = 0;
		int r = n-1;
		int cnt = 0;
		
		// 반복문 조건은 l이 r보다 왼쪽에 위치할 때 동작
		while (l < r) {
			int sum = arr[l] + arr[r];
			// 합이 x와 같으면 l과 r을 움직이기
			if (sum == x) {
				cnt++;
				l++;
				r--;
			} else if (sum < x) {
				l++;
			} else {
				r--;
			}
		}
		
		System.out.println(cnt);
		
	}
}
