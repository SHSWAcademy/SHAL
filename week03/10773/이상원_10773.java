import java.util.*;
import java.io.*;

Class Main {
        static int k;
        static Deque<Integer> stack;
        public static void main(String[] args) throws IOException {
                BufferedReader br = new BufferedReader(new InputstreamReader(System.in));
                k = Integer.parseInt(br.readLine());
                stack = new ArrayDeque<>();

                int sum = 0;
                for (int i = 0; i < k; i++) {
                        int data = Integer.parseInt(br.readLine());
                        if (data == 0 && !stack.isEmpty()) {
                                stack.pop();
                        } else {
                                sum += stack.pop();
                        }
                }

                System.out.println(sum);
        }
}
