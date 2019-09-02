package com.dynamicProgramming;

public class MinimumCostPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int cost[][] = { 
				{ 1, 2, 3 }, 
				{ 4, 8, 2 }, 
				{ 1, 5, 3 } };
		
		System.out.println(findMinimumCostPath(cost, 2, 2, 0, 0));
	}

	public static int findMinimumCostPath(int[][] arr, int row, int column, int finalRow, int finalColumn) {

		if (row == finalRow && column == finalColumn) {
			return arr[row][column];
		} else {
			return arr[row][column] + Math.min(
					(row >0 ? findMinimumCostPath(arr, row - 1, column, finalRow, finalColumn)
							: Integer.MAX_VALUE),
					Math.min(row >0 && column > 0
							? findMinimumCostPath(arr, row - 1, column - 1, finalRow, finalColumn) : Integer.MAX_VALUE,
									column > 0
									? findMinimumCostPath(arr, row, column - 1, finalRow, finalColumn)
											: Integer.MAX_VALUE));
		}

	}
}
