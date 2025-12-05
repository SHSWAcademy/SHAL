package main;


// 1. 투포인터 풀이
import java.util.*;
import java.io.*;

class Main{
    static int n;
    static int[] sequence;
    static int x;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력
        n = Integer.parseInt(br.readLine());
        sequence = new int[n];

        String secondLine = br.readLine();
        StringTokenizer st = new StringTokenizer(secondLine);
        for(int i = 0; i < n; i++){
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        x = Integer.parseInt(br.readLine());

        Arrays.sort(sequence);

        int output = solution();

        // 출력
        bw.write(String.valueOf(output));
        bw.flush();
    }

    static int solution(){
        int count = 0;

        int left = 0;
        int right = sequence.length - 1;

        while(left < right){

            if(sequence[left] + sequence[right] == x){
                count++;
                left++;
                right--;
            } else if(sequence[left] + sequence[right] > x){
                right--;
            } else if(sequence[left] + sequence[right] < x){
                left++;
            }

        }

        return count;
    }
}
