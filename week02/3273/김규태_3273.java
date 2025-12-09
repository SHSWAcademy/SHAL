import java.util.*;

public class Main{
    private static String[] arr;
    private static int x;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = Integer.parseInt(sc.nextLine());
        
        arr = sc.nextLine().trim().split(" ");
        
        x = Integer.parseInt(sc.nextLine());
        
        solution(arr);
        //solution2(arr);
    }
    
    public static void solution(String[] arr) { // boolean 배열 풀이
        boolean[] numbers = new boolean[2000001];
        int count = 0;
        for (String i : arr){
            int tmp = Integer.parseInt(i);
            if (tmp < x && numbers[x - tmp]){
                count++;
            }
            numbers[tmp] = true;
        }
        System.out.println(count);
    }
    
    public static void solution2(String[] arr) { // 투 포인터 풀이
        int[] arrNum = new int[arr.length];
        for (int i = 0; i < arrNum.length; i++) {
            arrNum[i] = Integer.parseInt(arr[i]);
        }
        int count = 0;        
        Arrays.sort(arrNum);
        
        int start = 0;
        int end = arrNum.length - 1;
        
        while(start < end){
            if (arrNum[start] + arrNum[end] < x) {
                start ++;
            } else if (arrNum[start] + arrNum[end] > x) {
                end --;
            } else {
                count ++;
                start ++;
                end --;
            }
        }
        System.out.println(count);
    }
}


