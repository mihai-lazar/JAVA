package exercise13;

import java.util.Arrays;

public class Ex93 {
	
	public static void main(String[] args) {
		
		String test = Arrays.toString(args);
		char sum = test.charAt(test.length() - 3);
		//System.out.println(sum);
		char res = test.charAt(test.length() - 2);
		//System.out.println(res);
		//char sum = test.substring(3, 5);
		//char rest = test.substring(0, 3);
		
		int count = 0;
		for (int i = 0; i < test.length() - 3; i++) {
			char c = test.charAt(i);
			if (c == sum) {
				count++;
			} else if (c == res) {
				count--;
			}
		}
		
	System.out.println(count);

	}
}
