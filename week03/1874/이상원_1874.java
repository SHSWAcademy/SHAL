import java.util.*;
import java.io.*;

class Main{
    static int n;
    static Deque<Integer> stack1;
    static List<Integer> input;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());

        input = new ArrayList<>();
        stack1 = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            input.add(Integer.parseInt(br.readLine()));
        }

        for (int i = n; i > 0; i--) {
            stack1.push(i);
        }

        List<Character> outputs = func();

        if (outputs.get(0) == 'N') {
            System.out.println("NO");
            return;
        }

        for (char c : outputs) {
            bw.write(c +"\n");
        }

        bw.flush();
        bw.close();
    }
    static List<Character> func() {
        List<Character> outputs = new ArrayList<>();

        Deque<Integer> stack2 = new ArrayDeque<>();
        for (int i : input) {
            if (stack1.contains(i)) {
                while (true) {
                    if (stack1.peek() == i) {
                        stack2.push(stack1.pop());
                        outputs.add('+');
                        break;
                    }
                    stack2.push(stack1.pop());
                    outputs.add('+');
                }
                stack2.pop();
                outputs.add('-');

            } else if (stack2.contains(i)) {
                stack2.pop();
                outputs.add('-');
            } else {
                outputs.clear();
                outputs.add('N');
                break;
            }

        }
        return outputs;
    }
}
