package com.pack;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static String getSmallestAndLargest(String s, int k) {
		String[] strArr = splitByIndex(s, k);
		return strArr[0] + "\n" + strArr[strArr.length - 1];
	}

	static String[] splitByIndex(String s, int k) {
		int size = s.length() - (k-1);
		String[] strArr = new String[size];
		for (int i = 0; i < size; i++) {
			strArr[i] = s.substring(i, ((i + k) ));
		}
		Arrays.sort(strArr);
		return strArr;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String s = scan.next();
		int k = scan.nextInt();
		scan.close();

		System.out.println(getSmallestAndLargest(s, k));
	}
}
