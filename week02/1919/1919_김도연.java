package BOJ1919;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
//		aabbcc
		String input1 = br.readLine();
//		xxyybb
		String input2 = br.readLine();
		
		ArrayList<String> arr1 = new ArrayList<>();
		ArrayList<String> arr2 = new ArrayList<>();
		
		for (int i = 0; i < input1.length(); i++) {
			arr1.add(String.valueOf(input1.charAt(i)));
		}
		for (int i = 0; i < input2.length(); i++) {
			arr2.add(String.valueOf(input2.charAt(i)));			
		}

		int cnt = 0;
		for (int i = 0; i < arr1.size(); i++) {
			if(arr2.contains(arr1.get(i))) {
				arr2.remove(arr1.get(i));
				cnt++;
			}
		}
		System.out.println(arr1.size() - cnt + arr2.size());
		
	}

}
