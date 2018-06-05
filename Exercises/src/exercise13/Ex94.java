package exercise13;

import java.util.Arrays;

public class Ex94 {
	
	/**
	* Returns the first character of the given String.
	*/
	public static char first(String s) {
		return s.charAt(0);
	}
	/**
	* Returns all but the first letter of the given String.
	*/
	public static String rest(String s) {
		return s.substring(1);
	}

	/**
	* Returns all but the first and last letter of the String.
	*/
	public static String middle(String s) {
		return s.substring(1, s.length() - 1);
	}
	/**
	* Returns the length of the given String.
	*/
	public static int length(String s) {
		return s.length();
	}
	
	public static void printString(String s) {
		String text = middle(s);
		int largo = length(text);
		for(int i = 0 ; i < largo ; i++) {
			System.out.println(first(text));
			text = rest(text);		
		}
	}
	
	public static void printBackward(String s) {
		String text = middle(s);
		int largo = length(text);
		char[] reves = new char[largo];
		for(int i = 0 ; i < largo ; i++) {
			reves[largo - 1 - i] = first(text);
			text = rest(text);		
		}
		
		for(int i = 0 ; i < largo ; i++) {
			System.out.println(reves[i]);
		}
		
	}
	
	public static void reverseString(String s) {
		String text = middle(s);
		int largo = length(text);
		char[] reves = new char[largo];
		for(int i = 0 ; i < largo ; i++) {
			reves[largo - 1 - i] = first(text);
			text = rest(text);		
		}
		
		String revesText = "";
		for(int i = 0 ; i < largo ; i++) {
			revesText = revesText + reves[i];	
		}
		System.out.println(revesText);
		
	}
	
	public static boolean isPalindrome(String s) {
		int largo = length(s);
		if(largo < 2)
			return true;
		else {
			//System.out.println(s.charAt(1));
			//System.out.println(s.charAt(length(s) - 2));
			if(s.charAt(1) == s.charAt(length(s) - 2)){
				boolean recursion = isPalindrome(s.substring(1, s.length() - 1));
				if(recursion == false)
					return false;
				else
					return true;	
			}else
				return false;		
		}
		
	}

	public static void main(String[] args) {
		
		//printString(Arrays.toString(args));
		//printBackward(Arrays.toString(args));
		//reverseString(Arrays.toString(args));
		System.out.println(isPalindrome(Arrays.toString(args)));
		
	}
	
	

}
