import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_1940_이승환 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		int[] number = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			number[i] = Integer.parseInt(st.nextToken());
//			System.out.println("number[i] = "+ number[i]);
		}
		solution(n, m, number);

	}

	private static void solution(int n, int m, int[] number) {
		Arrays.sort(number);// 정렬 필수
		
		int left = 0;
		int right = number.length-1;
		int count = 0;
		
		
		while(left < right) {
			int sum = number[left] + number[right];

			if (sum == m) {
				count++;
				left++;
				right--;
				
			} else if(sum < m) {
				left++;
			} else {
				right--;
			}
		}
		System.out.println(count);
	}
}
