import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class BOJ1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int k = Integer.parseInt(str[1]);
        Queue<Integer> q = new LinkedList<>();
        List<String> list = new ArrayList<>();

        /*
        직접 구현하지못하여 블로그를 참고하고 해당 원리를 이해하는데 집중했습니다.
        - Queue를 이용하여 원형계산처럼 구현
        - k번째 이전까지 맨앞 인덱스 요소를 맨뒤로 보내기 > k번째 인덱스 제거 > 제거된 인덱스 저장

        round 1
        loop 1 : {1, 2, 3, 4, 5, 6, 7}  → {2, 3, 4, 5, 6, 7, 1}
        loop 2 : {2, 3, 4, 5, 6, 7, 1}  → {3, 4, 5, 6, 7, 1, 2}
        loop 3 : {3, 4, 5, 6, 7, 1, 2}  → 3 출력
        round 2
        loop 1 : {4, 5, 6, 7, 1, 2}  → {5, 6, 7, 1, 2, 4}ㄷ
        loop 2 : {5, 6, 7, 1, 2, 4}  → {6, 7, 1, 2, 4, 5}
        loop 3 : {6, 7, 1, 2, 4, 5}  → 6 출력
         ..
         ..
         ..
        */
        for (int i = 1; i <= n; i++ ) {
            q.add(i);
        }
        while (!q.isEmpty()) {
            for (int i = 0; i < k-1; i++ ) {    // k-1 만큼 반복 ex)3이면 1,2,3번째 원소를 삭제해야함
                q.offer(q.poll());              // k이전 원소까지 뒤로 이동
            }
            list.add(String.valueOf(q.poll())); // k번째 원소 삭제 및 저장
        }
        // 리스트 괄호 커스터 마이징 (Gemini)
        /*
        Stream으로 리스트를 순차 접근
        map으로 Integer를 String으로 변환
        joining으로 원하는 방식으로 붙임
        */
        String result = list.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "<", ">"));

        System.out.println(result);
    }


}
