import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class B_1919_이승환 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String word1 = sc.nextLine();
		String word2 = sc.nextLine();
		
//		String word1 = "dared";
//     	String word2 = "bread";
		solution(word1, word2);
		
	}
	private static void solution(String word1, String word2) {
		char[] word1Array = word1.toCharArray();
		char[] word2Array = word2.toCharArray();
		
		Map<Character, Integer> word1Hash = new HashMap<>();
		Map<Character, Integer> word2Hash = new HashMap<>();
		
		for(char c1 : word1Array) {
			word1Hash.put(c1, word1Hash.getOrDefault(c1, 0)+1);
		}
//		System.out.print(word1Hash);
		
		for(char c2 : word2Array) {
			word2Hash.put(c2, word2Hash.getOrDefault(c2, 0)+1);
		}
//		System.out.print(word2Hash);
		
					 
		// 소문자로 이루어진 단어
		// 두 단어의 단어별 갯수를 세서 빼서 0이 되면 중복되는 값 
		// 중복되지 않은 값만 count
		char[] alpha = new char[26];
		int index = 0;
		for(int i = 97 ; i <= 122; i++) {
			alpha[index++] = (char)i;
		}
//		System.out.println(alpha);
		for(char c3 : alpha) {
			//wordHash에 word1Hash랑 word2Hash 넣어서 차이 구해서 더하기
			word1Hash.put(c3, word1Hash.getOrDefault(c3,0));
			word2Hash.put(c3, word2Hash.getOrDefault(c3,0));
		}
		
		int count = 0;
		for(char key : word1Hash.keySet()) {
			int value1 = word1Hash.get(key);
			int value2 = word2Hash.get(key);
			int value3 = Math.abs(value1 - value2);// - 값이 나오면 안되기 때문에 절댓값으로 양수로 바꿔줌
			
			count += value3;
//			System.out.print(key1+" : "+value1);
//			System.out.println();
//			System.out.print(key1+" : "+value2);
		}
		System.out.println(count);
//		for(char key2 : word2Hash.keySet()) {
//		}
	
		
//		System.out.println(wordHash);
		
		
		
	}
}


/*

for(char c3 : alpha) {
			//wordHash에 word1Hash랑 word2Hash 넣어서 차이 구해서 더하기
			word1Hash.put(c3, word1Hash.getOrDefault(c3,0));
			word2Hash.put(c3, word2Hash.getOrDefault(c3,0));
		}
		이 코드 줄은 없어도 되지 않나요 ?! 코드가 잘 이해안되어서 남겨봅니다 ...

*/
