package com.leetcode;


import java.util.Arrays;

//https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
public class TwoSumSortedArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{0,0,3,4}, 0)));
    }


    //Input: numbers = [2,7,11,15], target = 22
    public static int[] twoSum(int[] numbers, int target) {

        int i = 0;
        int j = numbers.length - 1;

        int sum = numbers[i] + numbers[j];
        while (sum != target && i < j) {
            sum = numbers[i] + numbers[j];
            if (sum == target) {
                return new int[]{i + 1, j + 1};
            }
            if (sum > target) {
                j -= 1;
            } else {
                i += 1;
            }
        }
        return new int[]{i + 1, j + 1};
    }
}
