package main;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input, " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Integer> outputs = solution(n, k);


        // 출력
        System.out.print("<");
        for(int i = 0; i < outputs.size() - 1; i++) {
            System.out.print(outputs.get(i) + ", ");
        }

        System.out.print(outputs.get(outputs.size() - 1) + ">");
    }

    private static List<Integer> solution(int n, int k) {
        List<Integer> outputs = new ArrayList<>();

        // 실전에서는 ArrayList로 선언하고 시간초과가 난다면 LinkedList로 변경해보자
        List<Integer> circle = new LinkedList<>();

        // 초기화
        for(int i = 1; i <= n; i++) {
            circle.add(i);
        }
        int curIdx = k - 1;

        while(!circle.isEmpty()) {

            int removeValue = 0; // 선언


            if(circle.size() -1 >= curIdx) {
                removeValue = circle.remove(curIdx);
                outputs.add(removeValue);
                curIdx += k - 1;
            }
            else {
                curIdx = curIdx % circle.size();
                removeValue = circle.remove(curIdx);
                outputs.add(removeValue);
                curIdx += k - 1;
            }



        }


        return outputs;
    }
}