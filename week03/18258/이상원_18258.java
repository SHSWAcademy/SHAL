import java.util.*;
import java.io.*;

class Main {
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력
        N = Integer.parseInt(br.readLine());
        Queue<String> q = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            q.offer(br.readLine());
        }

        // 출력
        List<Integer> outputs = func(q);
        for (int i : outputs) {
            bw.write(i + "\n");
        }
        bw.close();
    }

    private static List<Integer> func(Queue<String> q) {
        List<Integer> outputs = new ArrayList<>();
        Deque<Integer> nums = new ArrayDeque<>();

        while (!q.isEmpty()) {
            String[] poll = q.poll().split(" ");
            String order = poll[0];

            switch (order) {
                case "push" :
                    int num = Integer.parseInt(poll[1]);
                    nums.offer(num);
                    break;
                case "pop" :
                    if (nums.isEmpty()) {
                        outputs.add(-1);
                    } else {
                        int pollNum = nums.poll();
                        outputs.add(pollNum);
                    }
                    break;
                case "size" :
                    outputs.add(nums.size());
                    break;
                case "empty" :
                    if (nums.isEmpty()) {
                        outputs.add(1);
                    } else {
                        outputs.add(0);
                    }
                    break;
                case "front" :
                    if (nums.isEmpty()) {
                        outputs.add(-1);
                    } else {
                        outputs.add(nums.peek());
                    }
                    break;
                case "back" :
                    if (nums.isEmpty()) {
                        outputs.add(-1);
                    } else {
                        outputs.add(nums.peekLast());
                    }
                    break;
            }

        }

        return outputs;
    }
}