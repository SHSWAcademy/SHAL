
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_11659_이승환 {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());


		int[] number = new int[n+1];
		int[] prefix = new int[n+1];
		prefix[0] = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 1; i <= n; i++) {
			prefix[i] = prefix[i-1] + number[i]; // 구간합의 합
		}


		int[][] ij = new int[m][2];
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 2; j++) {
				ij[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		solution(n,m,prefix,ij);

	}

	private static void solution(int n, int m, int[] prefix, int[][] ij) {
		int[] answer = new int[m];
		for(int i = 0; i < m; i++) {
			answer[i] = prefix[ij[i][1]] - prefix[ij[i][0]-1];
			System.out.println(answer[i]);
		}

	}
}














//시간 초과
//package baekjoon;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class B_11659_이승환 {
//	public static void main(String[] args) throws NumberFormatException, IOException {
//
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		
////		int n = Integer.parseInt(br.readLine()); 이렇게 입력하면 NumberFormat 에러가 뜬다. 5 3 이렇게 입력이 되어야 되는데 안되는 상황
////		int m = Integer.parseInt(br.readLine());
//		
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		int n = Integer.parseInt(st.nextToken());
//		int m = Integer.parseInt(st.nextToken());
//		
//		
//		int[] number = new int[n];
//		
//		st = new StringTokenizer(br.readLine());
//		for(int i = 0; i < n; i++) {
//			number[i] = Integer.parseInt(st.nextToken());
//		}
//		
//		int[][] ij = new int[m][2];
//		for(int i = 0; i < m; i++) {
//			st = new StringTokenizer(br.readLine());
//			for(int j = 0; j < 2; j++) {
//				ij[i][j] = Integer.parseInt(st.nextToken());
//			}
//		}
//		
//		solution(n,m,number,ij);
//	}
//	private static void solution(int n, int m, int[] number, int[][] ij) {
//		int[] answer = new int[m];
//		int sum = 0;
//		for(int i = 0; i < m; i++) {
////			System.out.println("ij[i][0] : "+ij[i][0] + " ij[i][1] : "+ ij[i][1]);
//					for(int k = ij[i][0]-1; k <= ij[i][1]-1; k++) {//
////						System.out.println("number"+k+" "+ number[k]);
//						  sum += number[k];
//						  
//					}
//					answer[i] = sum;
//					sum = 0; // sum을 다시 reset 해줘야함
//					System.out.println(answer[i]);
//				}
//		}
//	}
