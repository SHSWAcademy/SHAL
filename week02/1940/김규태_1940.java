import java.util.*;

public class Main{
    private static int N;
    private static int M;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringTokenizer st;

        N = Integer.parseInt(sc.nextLine());
        M = Integer.parseInt(sc.nextLine());
        int[] resources = new int[N];

        st = new StringTokenizer(sc.nextLine(), " ");
        for (int i = 0; i < resources.length; i++) {
            resources[i] = Integer.parseInt(st.nextToken());
        }

        solution(resources);
    }
    public static void solution(int[] resources) {
        Arrays.sort(resources);

        int s = 0;
        int e = resources.length - 1;
        int count = 0;

        while(s < e) {
            if ((resources[s] + resources[e]) < M) {
                s ++;
            } else if ((resources[s] + resources[e]) > M) {
                e --;
            } else {
                count ++;
                s ++;
                e --;
            }
        }
        System.out.println(count);
    }
}