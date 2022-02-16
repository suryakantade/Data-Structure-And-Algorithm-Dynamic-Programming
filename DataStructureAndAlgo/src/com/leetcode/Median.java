package com.leetcode;



// https://leetcode.com/problems/median-of-two-sorted-arrays/
public class Median {


    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1,3}, new int[] {2,7}));
    }


    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int min = Math.min(nums1.length==0?nums2[0]:nums1[0], nums2.length==0?nums1[0]:nums2[0]);
        int max = Math.max(nums1.length==0?nums2[nums2.length-1]:nums1[nums1.length-1], nums2.length==0?nums1[nums1.length-1]:nums2[nums2.length-1]);
        double result =  min+max;
        return result/2;
    }
}
