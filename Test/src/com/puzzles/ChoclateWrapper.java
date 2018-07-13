package com.puzzles;

import java.util.Scanner;

public class ChoclateWrapper {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the amount");
		int amount = sc.nextInt();
		System.out.println("Enter the price of Choclate");
		int price = sc.nextInt();
		System.out.println("Enter the number of Wrapper");
		int wrapper = sc.nextInt();
		int total = choclateWrapperProblem(amount, price,wrapper);
		System.out.println("Total :: "+total);
	}

	private static int choclateWrapperProblem(int amount, int price, int wrapper) {
		if(amount < price)
			return 0;
		int count = amount/price;
		count  = count +((count-1)/(wrapper-1));
		return count;
	}

}
