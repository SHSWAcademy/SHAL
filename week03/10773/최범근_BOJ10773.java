import java.io.*;
import java.util.*;

public class BOJ10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        int sum = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < k; i++) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0 && !stack.isEmpty()) {   // 0이고 스택이 비어있지 않다면 직전 값 지우기
                stack.pop();
            } else {    // 0이 아닐경우 push
                stack.push(n);
            }
        }

        while (!stack.isEmpty()) {  // 최종 스택값 +
            sum += stack.pop();
        }

        System.out.println(sum);
    }
}
