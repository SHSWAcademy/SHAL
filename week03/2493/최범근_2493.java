import java.io.*;
import java.util.*;

public class BOJ2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> stack = new ArrayDeque<>();

        int n = Integer.parseInt(br.readLine());
        List<String> list = Arrays.asList(br.readLine().split(" "));
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<n; i++) {
            int height = Integer.parseInt(list.get(i));

            while (!stack.isEmpty()) {
                if (stack.peek() < height) { // 스택의 상단 값보다 높이값이 클 경우 remove
                    stack.pop();
                } else {    // 아닌경우 break (현재 탑보다 높으면 멈추기)
                    break;
                }
            }
            if (stack.isEmpty()) {  // 첫번째 인덱스 처리
                sb.append("0 ");
            } else if (stack.peek() > height) { // 현재 탑의 위치보다 크다면 해당 탑의 인덱스
                sb.append(list.indexOf(String.valueOf(stack.peek()))+1).append(" "); // 리스트에 저장된 탑의 높이의 인덱스 번호 +1 추출
            }
            stack.push(height);
        }
        System.out.println(sb.toString());
    }
}
