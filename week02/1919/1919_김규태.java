import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String word1 = sc.nextLine(); // 1번째 줄 문자열
        String word2 = sc.nextLine(); // 2번째 줄 문자열
        
        System.out.println(solution(word1, word2)); // solution() 메서드에 인자로 word1, word2를 넣은 결과를 출력
    }
    public static int solution(String word1, String word2){
        int[] alphabet = new int[26]; // 소문자 a-z 범위의 int 배열 선언
        int count = 0; // count를 0으로 초기화
        
        for (char c : word1.toCharArray()){
            alphabet[c - 'a']++; // 문자열을 char배열로 만들어 순회하면서, c - 'a'를 통해 0-25의 정수로 변환하고 alphabet 배열에 인덱스로 받아 해당 인덱스의 값을 1 더함
        }
        for (char c : word2.toCharArray()){
            alphabet[c - 'a']--; // 문자열을 char배열로 만들어 순회하면서, c - 'a'를 통해 0-25의 정수로 변환하고 alphabet 배열에 인덱스로 받아 해당 인덱스의 값을 1 뺌
        }
        
        for (int i : alphabet){ // alphabet 배열을 순회
            count += i > 0 ? i : -i;
          // 만일 첫 번째 문자열과 두 번째 문자열에서 겹치는 문자가 있었다면 더하고 빼서 0이 되었을 것이지만,
          // 그렇지 않다면 양의 정수 또는 음의 정수 값을 가질 것이므로, count에 더해야 함.
          // 삼항연산자를 사용하여 음의 정수일 때 -i를 count에 더하도록 함.
        }
        return count;
    }
}


// 이상원 : count += i > 0 ? i : -i; 부분을 count += Math.abs(i)로 쓰면 조금 더 직관성있을 것 같습니다 ! 
