package com.BitwiseAlgo;

public class ChangeRightMostSetBit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(changeRightMostBit(8));
	}
	public static int changeRightMostBit(int no){
		return no & (no-1);
	}
}
