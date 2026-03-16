import java.util.*;
import java.io.*;

class Main {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        System.out.println(function(n));
    }

    private static int function(int n) {
        // base condition (종료 조건)
        if (n == 0 || n == 1) return n;
        // 종료 조건에 만족하지 않을 경우 (재귀) 
        else {
            return function(n - 1) + function (n - 2);
        }
    }
}
