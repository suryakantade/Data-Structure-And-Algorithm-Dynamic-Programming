package com.leetcode;


// https://leetcode.com/problems/median-of-two-sorted-arrays/
public class Median {


    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1, 3}, new int[]{2, 7}));
    }


    // 1 2 3
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int count = nums1.length + nums2.length;

        int firstArrIndex = 0;
        int secondArrIndex = 0;

        if (count % 2 == 1) {
            int median = 0;
            for (int iterator = 1; iterator <= count / 2+1  ; iterator++) {
                if (firstArrIndex<nums1.length && ( secondArrIndex>= nums2.length || nums1[firstArrIndex] < nums2[secondArrIndex])) {
                    median = nums1[firstArrIndex];
                    firstArrIndex++;
                } else {
                    median = nums2[secondArrIndex];
                    secondArrIndex++;
                }
            }
            return median;
        } else {
            // 1 2 3 4 5 6
            double median = 0;
            for (int iterator = 1; iterator <= count/2; iterator++) {
                if (firstArrIndex<nums1.length && ( secondArrIndex>= nums2.length || nums1[firstArrIndex] < nums2[secondArrIndex])) {
                    median = nums1[firstArrIndex];
                    firstArrIndex++;
                } else {
                    median = nums2[secondArrIndex];
                    secondArrIndex++;
                }
            }
            if (firstArrIndex<nums1.length && ( secondArrIndex>= nums2.length || nums1[firstArrIndex] < nums2[secondArrIndex])) {
                median += nums1[firstArrIndex];
            } else {
                median += nums2[secondArrIndex];
            }
            return median/2.0;
        }
    }
}
