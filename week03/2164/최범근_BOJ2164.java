import java.util.*;

public class BOJ2164 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Deque<Integer> q = new ArrayDeque<>();

        // 큐에 1 ~ n까지 삽입
        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }

        while (q.size() > 1) {
            q.poll();   // 첫번째 값 버리기
            q.offerLast(q.poll()); // 그다음 값 맨마지막으로 이동
        }
        System.out.println(q.poll());
    }
}
