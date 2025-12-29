import java.util.*;
import java.io.*;

class Main {
    static int N;
    static List<int[]> list;
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        list = new ArrayList<>();

        N = Integer.parseInt(br.readLine());

        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input, " ");

        for (int i = 1; i <= N; i++) {
            int[] data = new int[2];
            int num = Integer.parseInt(st.nextToken());
            data[0] = num;
            data[1] = i;
            list.add(data);
        }

        List<Integer> output = func();
        for (int i = 0; i < N; i++) {
            bw.write(output.get(i) + " ");
        }
        bw.flush();
    }
    static List<Integer> func() {
        List<Integer> output = new ArrayList<>();

        Deque<int[]> stack = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            int[] data = list.get(i);
            int height = data[0];
            int idx = data[1];


            while (true) {

                // 스택이 비어있을 경우
                if (stack.isEmpty()) {
                    output.add(0);
                    stack.push(data);
                    break;
                }

                // 스택에 값이 있을 경우
                int[] peek = stack.peek();
                int peekHeight = peek[0];
                int peekIdx = peek[1];

                if (height < peekHeight) {
                    output.add(peekIdx);
                    stack.push(data);
                    break;
                } else {
                    stack.pop();
                }

            }


        }

        return output;
    }
}