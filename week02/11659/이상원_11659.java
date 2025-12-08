package main;

import java.util.*;
import java.io.*;

class Main {
    static int[] arr;
    static int[] sumArr;
    static int N;
    static int M;

    public static void main(String[] args) throws Exception {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] first = br.readLine().split(" ");
        N = Integer.parseInt(first[0]);
        M = Integer.parseInt(first[1]);
        String second = br.readLine();
        StringTokenizer st = new StringTokenizer(second, " ");

        arr = new int[N];
        sumArr = new int[N];

        int idx = 0;
        while(st.hasMoreTokens()) {
            arr[idx++] = Integer.parseInt(st.nextToken());
        }

        List<Integer> outputs = new ArrayList<>();

        setSumArr();

        for(int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            int idx1 = Integer.parseInt(input[0]) - 1; // 인덱스는 입력값 - 1
            int idx2 = Integer.parseInt(input[1]) - 1;
            // 비즈니스 로직
            int output = solution(idx1, idx2);
            outputs.add(output);
        }

        // 출력
        for (int o : outputs) {
            bw.write(o + "\n");
        }

        bw.close(); //flush

    }
    private static int solution(int idx1, int idx2) {
        if(idx1 == 0) {
            return sumArr[idx2];
        } else {
            return sumArr[idx2] - sumArr[idx1-1];
        }
    }

    private static void setSumArr() {
        sumArr[0] = arr[0];
        for(int i = 1; i < N; i++) {
            sumArr[i] = sumArr[i-1] + arr[i];
        }
    }
}