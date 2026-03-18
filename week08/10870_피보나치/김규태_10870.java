import java.util.*;

public class Main {
    private static int n;
    private static int[] arr;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = Integer.parseInt(sc.nextLine());
        
        arr = new int[n + 1];
        
        System.out.println(dfs(n));
        
    }
    private static int dfs(int depth) {
        if (depth == 0) {
            return 0;
        } else if (depth == 1) {
            return 1;
        }
        if (arr[depth] != 0) {
            return arr[depth];
        }
            arr[depth] = dfs(depth - 1) + dfs(depth - 2);
            return arr[depth];
    }
}
