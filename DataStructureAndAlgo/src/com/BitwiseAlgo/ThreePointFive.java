package com.BitwiseAlgo;

public class ThreePointFive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		calculate(7);
		
	}
	public static void calculate(int no){
		no = (no<<1)+no+(no>>1);
		System.out.println(no);
	}
	
}
