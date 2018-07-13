package com.pack;

import java.util.Scanner;

public class Solution1 {
	static long count = 0;
	static Solution1 solution = new Solution1();

	/*
	 * long getWays(long n, long[] arr){ Arrays.sort(arr); //
	 * System.out.println(arr); for(Long l : arr) { System.out.print(l+" "); }
	 * System.out.println(); solution.findCount(arr , n ,0); return count; }
	 */

	long findCount(long[] arr, long sum, int i) {
		if (sum < 0)
			return count;
		if (sum == 0) {
			++count;
			return count;
		}

		while (i < arr.length && (sum - arr[i]) >= 0) {
			if (sum - arr[i] % arr[i] == 0) {
				++count;
			} else {
				solution.findCount(arr, sum - arr[i], i);
			}
			i++;

		}

		return count;
	}

	long getWays(int amount, int[] coins) {
		long[] combinations = new long[amount + 1];

		combinations[0] = 1;

		for (int coin : coins) {
			for (int i = 1; i < combinations.length; i++) {
				if (i >= coin) {
					
					combinations[i] += combinations[i - coin];
					System.out.println(
							"i ::" + i + " coin ::" + coin + " combinations[i - coin] :: " 
					+ combinations[i - coin]+" combinations[i] ::  "+combinations[i]);
				}
			}
		}
		return combinations[amount];
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int[] c = new int[m];
		for (int c_i = 0; c_i < m; c_i++) {
			c[c_i] = in.nextInt();
		}
		System.out.println(solution.getWays(n, c));
	}
}