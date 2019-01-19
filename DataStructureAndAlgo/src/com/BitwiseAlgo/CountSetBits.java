package com.BitwiseAlgo;

public class CountSetBits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(countSetBits(3));
	}
	// 11101
	public static int countSetBits(int no){
		int i =1;
		int count= 0;
		while(no>0){
			if((no & i) == 1){
				count++;
			}
			no = no>>1;
		
		}
		return count;
	}
}
