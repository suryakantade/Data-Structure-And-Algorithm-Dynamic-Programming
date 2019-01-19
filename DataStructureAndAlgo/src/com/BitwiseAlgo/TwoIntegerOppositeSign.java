package com.BitwiseAlgo;

public class TwoIntegerOppositeSign {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		isOppositeSign(-100, -200);	
		
		
	}

	public static void isOppositeSign(int no1, int no2) {
		if ((no1 ^ no2) < 0) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
	}
}
