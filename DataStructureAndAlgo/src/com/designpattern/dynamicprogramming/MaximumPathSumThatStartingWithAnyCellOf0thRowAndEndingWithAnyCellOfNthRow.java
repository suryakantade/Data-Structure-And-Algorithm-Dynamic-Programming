package com.designpattern.dynamicprogramming;

public class MaximumPathSumThatStartingWithAnyCellOf0thRowAndEndingWithAnyCellOfNthRow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[][] = { { 4, 2, 3, 50 }, 
						{ 2, 9, 1, 10 }, 
						{ 15, 1, 3, 0 }, 
						{ 16, 92, 41, 44 } };
		int lastBiggest =0;
		for(int i = 0;i<arr[0].length;i++){
			int result = findMaxSum(arr, 0, i, 3);
			if(result>lastBiggest){
				lastBiggest = result;
			}
		}
		System.out.println(lastBiggest);
	}

	public static int findMaxSum(int[][] arr, int row, int column, int nthRow) {
		if (row == nthRow) {
			return arr[row][column];
		} else {
			return arr[row][column] + Math.max(column > 0 ? findMaxSum(arr, row + 1, column - 1, nthRow) : 0,
					Math.max(findMaxSum(arr, row + 1, column, nthRow), column<arr[0].length-1?findMaxSum(arr, row + 1, column + 1, nthRow):0));
		}
	}
}
