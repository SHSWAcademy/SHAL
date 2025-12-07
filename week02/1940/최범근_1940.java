import java.io.*;
import java.util.*;

public class BOJ1940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String[] num = br.readLine().split(" ");
        int cnt = 0;

        //조합 가능한 쌍을 전부 탐색함
        /*
        2 : 7 4 1 5 3 > 2, 7  ( i:0 j: 1~4 )
        7 : 4 1 5 3 > X       ( i:1 j: 2~4 )    
        4 : 1 5 3 > 4, 5      ( i:2 j: 3~4 )
        5 : 3 > X             ( i:3 j: 4~4 )
         */
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                int index_1 = Integer.parseInt(num[i]);
                int index_2 = Integer.parseInt(num[j]);
                if ( index_1 + index_2 == m) {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}

/*
6
9
2 7 4 1 5 3
*/

// 이상원 : 지금 시간 복잡도는 O(n^2)인데 투포인터 알고리즘을 공부하고 풀면 O(n)으로 줄어들 수 있을 것 같네요 !
