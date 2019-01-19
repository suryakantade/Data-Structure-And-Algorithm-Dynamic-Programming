package com.BitwiseAlgo;

public class ConvertNoAtoBFlipBit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		convert(10, 20);
	}
	public static void convert(int no1, int convertTO){
		int no = (no1 ^ convertTO);
		int count = 0;
		int i = 1;
		while(no>0){
			if((no & i)==1){
				count++;
			}
			no >>=1;
		}
		System.out.println(count);
	}
}
