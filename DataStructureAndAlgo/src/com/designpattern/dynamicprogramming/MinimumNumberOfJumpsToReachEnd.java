package com.designpattern.dynamicprogramming;

public class MinimumNumberOfJumpsToReachEnd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int arr[] = {1, 1, 1, 1, 1, 1, 1, 2, 6, 8, 9};  
	        makeJump(arr, arr[0], 0); 
		
		
	}
	/*Input: arr[] = {1, 3, 5, 1, 1, 1, 4, 1, 6, 8, 9}
	Output: 3 (1-> 3 -> 8 ->9)*/
	public static void makeJump(int[] arr, int jump,int index){
		int biggestJump = 0;
		int stepsCameFromBiggestJump = 0;
		int indexFromBigJump =0;
		System.out.println(jump);
		if(jump == 0 ){
			System.out.println("Man you need to stop here!!");
			return ;
		}
		if(index+jump >= arr.length-1){
			return ;
		}
		indexFromBigJump = index;
		for(int i = index+1;i<=index+jump;i++){
			if(arr[i]>=biggestJump){
				indexFromBigJump = i;
				biggestJump = arr[i];
				stepsCameFromBiggestJump = 0;
			}
			if(stepsCameFromBiggestJump+arr[i]> biggestJump){
				indexFromBigJump = i;
				biggestJump = arr[i];
				stepsCameFromBiggestJump = 0;
			}
		}
		makeJump(arr, biggestJump, indexFromBigJump);
	}
}
