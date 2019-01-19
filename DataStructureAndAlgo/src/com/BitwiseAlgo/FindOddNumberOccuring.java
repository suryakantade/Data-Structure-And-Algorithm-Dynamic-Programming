package com.BitwiseAlgo;

public class FindOddNumberOccuring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {1,2,7,3,2,3,1,3,1,1,7};
		System.out.println(oddNumberOccuring(arr));
	}
	public static int oddNumberOccuring(int[] arr){
		int base = 0;
		for(int i = 0 ;i<arr.length;i++){
			base = base^arr[i];
		}
		return base;
	}
}
