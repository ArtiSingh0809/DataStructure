package com.simple.problem;

public class Palindrome {

	public boolean isPalindrome(String main) {
		for (int i = 0, j = (main.length() - 1); i < (main.length() / 2); i++, j--) {
				if(main.charAt(i) != main.charAt(j)) 
					return false;
		}
		return true;
	}

}
