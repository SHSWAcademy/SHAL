import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N+1]; // 1부터 N까지 저장하기 위해 크기를 N+1만큼
        st = new StringTokenizer(br.readLine()," ");

        for (int i = 1; i < N + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken()) + arr[i-1];
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            sb.append(arr[e] - arr[s-1] + "\n");
        }
        System.out.println(sb.toString());
    }
}
