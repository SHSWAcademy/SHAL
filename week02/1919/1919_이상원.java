package ShinHan;

/* 1. 스택을 이용한 풀이
import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] first = br.readLine().toCharArray();
        char[] second = br.readLine().toCharArray();

        int answer = anagram(first, second);

        System.out.println(answer);
    }

    private static int anagram(char[] first, char[] second){

        int cnt = 0;

        Arrays.sort(first);
        Arrays.sort(second);

        Deque<Character> stack1 = new ArrayDeque<>();
        Deque<Character> stack2 = new ArrayDeque<>();

        for(char c : first) {
            stack1.push(c);
        }
        for(char c : second){
            stack2.push(c);
        }

        while(!(stack1.isEmpty() || stack2.isEmpty())){

            char peek1 = stack1.peek();
            char peek2 = stack2.peek();

            if(peek1>peek2){
                stack1.pop();
                cnt++;
            } else if(peek1<peek2){
                stack2.pop();
                cnt++;
            } else if(peek1 == peek2){
                stack1.pop();
                stack2.pop();
            }
        }

        cnt += stack1.size() + stack2.size();

        return cnt;
    }
}
*/

// 2. 배열 풀이
import java.util.*;
import java.io.*;

class Main{

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] first = br.readLine().toCharArray();
        char[] second = br.readLine().toCharArray();

        int output = anagram(first, second);
        System.out.println(output);
    }

    static int anagram(char[] first, char[] second){
        int answer = 0;

        //전체 글자 수에서 중복된 알파벳 수만 빼기
        answer = first.length + second.length;

        for(int i = 0; i < first.length; i++){
            for(int j = 0; j < second.length; j++){
                if(first[i] == second[j]){
                    answer -= 2; // 각 배열에서 빼기
                    first[i] = '0';
                    second[j] = '1';
                    break;
                }
            }
        }

        return answer;
    }
}
