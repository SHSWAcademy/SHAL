import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();
        int K = sc.nextInt();

        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        while(!queue.isEmpty()) {
            for (int i = 0; i < K-1; i++) {
                queue.offer(queue.poll());
            }
            list.add(queue.poll());
        }

        sb.append("<");
        for (int i = 0; i < list.size()-1; i++) {
            sb.append(list.get(i) + ", ");
        }
        sb.append(list.get(list.size() - 1) + ">");

        System.out.println(sb.toString());
    }
}
