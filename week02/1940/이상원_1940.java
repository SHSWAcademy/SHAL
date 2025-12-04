package main;

import java.util.*;
import java.io.*;

class Main{
    static int N;
    static int M;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        String[] inputArr = br.readLine().split(" ");
        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(inputArr[i]);
        }

        int output = solution(arr);
        System.out.println(output);
    }
    static int solution(int[] arr){
        int answer = 0;

        Arrays.sort(arr);

        int left = 0;
        int right = arr.length - 1;

        while(left<right){

            int sum = arr[left] + arr[right];

            //base condition
            if(sum == M) {
                answer++;
                left++;
                right--;
            } else if (sum > M) {
                right--;
            } else {
                left++;
            }
        }

        return answer;
    }
}