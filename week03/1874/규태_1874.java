import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        /*
        push하는 경우: 출력한 숫자 중 가장 큰 숫자보다 더 큰 수가 입력되는 경우.
            출력한 숫자 중 가장 큰 숫자와 입력한 숫자의 차이만큼 +를 출력
            
        pop하는 경우: 각 줄의 숫자 입력에 대해 해당 수를 pop해야 함.
            if 현재까지 push한 숫자 set에서 입력받은 수보다 큰 수가 있다면 -1를 출력하고 종료
        
        */
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        int top = 0;
        for(int i = 0; i<n; i++){
            int num = Integer.parseInt(br.readLine());
            // 입력받은 수가 top보다 클 경우
            if(top<num){
                for(int j = 1; j<=num-top; j++){
                    sb.append("+\n");
                    stack.push(j+top);
                }
                top=num;
                sb.append("-\n");
                if(stack.peek()==num) stack.pop();
            }else{
                if(stack.peek()>num){
                    sb.setLength(0);
                    sb.append("NO\n");
                    break;
                }
                while(!stack.isEmpty()){
                    if(stack.peek()==num){
                        sb.append("-\n");
                        stack.pop();
                        break;
                    }
                    sb.append("-\n");
                    stack.pop();
                }
            }


        }
        if(!stack.isEmpty()){
            sb.setLength(0);
            sb.append("NO\n");
        }
        String result = sb.toString();
        bw.write(result);
        bw.flush();
        bw.close();
        br.close();
    }
}
