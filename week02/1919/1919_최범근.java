import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1919 {
    public static void main(String[] args) throws IOException {
        BufferedReader sb = new BufferedReader(new InputStreamReader(System.in));
        String first = sb.readLine();
        String second = sb.readLine();
        char[] secondChr = second.toCharArray();
        int cnt = 0;

        for(int i=0; i<first.length(); i++){
            for(int j=0; j<second.length(); j++){
                if(first.charAt(i) == secondChr[j]){
                    cnt++;
                     /*
                    두 단어의 문자 하나씩 비교 하다가 이미 검증된 문자는 검사하지 말아야하는 로직에서
                    이미 검사된 문자라면 다시 검사하지않도록 대문자로 변경 (상원님이 힌트주심... 사실 정답 알려주심...)
                    */
                    //처음에 문자열 자체를 replace로 대문자변경 하려했으나 문자가 모두 변경되어 char 배열로 선언하며 대문자 변경
                    //second = second.replace(String.valueOf(second.charAt(j)), String.valueOf(second.charAt(j)).toUpperCase());
                    secondChr[j] = Character.toUpperCase(secondChr[j]);
                    break;
                }
            }
        }
        //cnt는 단어중 하나의 단어 매칭값만 ++ 하기때문에 *2 해줌
        System.out.println(first.length() + second.length() - cnt*2);
    }
}

