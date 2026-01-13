import java.util.*;

public class BOJ1697{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] board = new int[100001];

        // 첫 시작점 0, 두번째1, 세번째2..... k번째에 출력
        board[n] = 0;
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(n);

        while (!q.isEmpty()) {
            int nowNode = q.poll();
            // 문제 요구사항, +1, -1, *2로 이동 가능
            int[] next = {nowNode+1, nowNode-1, nowNode*2};
            int nextNode;

            if (nowNode == k) { // 현재 노드가 타겟과 같다면 걸린 초 출력
                System.out.print(board[nowNode]);
                break;
            }
            for (int i=0; i<3; i++) {
                nextNode = next[i];

                if (nextNode < 0 || nextNode >= board.length) continue;
                if (nextNode != n && board[nextNode] != 0) continue;

                q.offer(nextNode);
                board[nextNode] = board[nowNode] + 1;
            }
        }

    }
}