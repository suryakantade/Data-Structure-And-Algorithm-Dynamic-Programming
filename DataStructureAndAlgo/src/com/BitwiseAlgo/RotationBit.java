package com.BitwiseAlgo;

public class RotationBit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(229<<3);
		System.out.println(rotateLeft(229, 3));
	}
	public static int rotateLeft(int n, int d){
		int Int_bit =32;
		return ((n << d)|(n >> (Int_bit-d)));
	}
}
