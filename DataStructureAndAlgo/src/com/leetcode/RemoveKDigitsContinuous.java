package com.leetcode;


public class RemoveKDigitsContinuous {

    public static void main(String[] args) {
        String smallest = removeKdigits("112", 1);
        System.out.println(smallest);
    }

    public static String removeKdigits(String num, int k) {
        if(num.length() == k ){
            return ""+0;
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0;i<num.length()-k;i++){
            int fromRightCur = num.length()-1;
            int temp = Integer.parseInt((num.substring(0,i)+num.substring(i+k,num.length())));
            int tempFromRight = Integer.parseInt(num.substring(0,fromRightCur-i-k+1)+ num.substring(fromRightCur-i, fromRightCur));
            min = Math.min(min, Math.min(temp, tempFromRight));
        }
        return ""+min;
    }

}


// 143222999 4-1-1

// 1 2 2 2 9

// 1432219 4-1-1

// 1 1 9
