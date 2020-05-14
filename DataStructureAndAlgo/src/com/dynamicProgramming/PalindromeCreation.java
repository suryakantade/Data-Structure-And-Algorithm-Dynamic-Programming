package com.dynamicProgramming;

import com.datastructure.Arraylist.ArrayList;

import java.util.LinkedList;
import java.util.Queue;

public class PalindromeCreation {

  public static void main(String[] args) {
    char x = 'a';
    char y = 'b';
    System.out.println(findPalindrome(x, y, 9));

  }

  /*aa
  * bb
  * aaaa
  * abba
  * baab
  * bbbb
  * aaaaaa
  * aabbaa
  * abaaba
  * abbbba
  * */
  public static String findPalindrome(char x, char y, int nth){

    String firstPart = null;
    if(nth < 1){
      return firstPart;
    }
    if(nth == 1){
      firstPart += x;
    }
    else if(nth == 2){
      firstPart += y;
    }else{
      Queue<String> queue = new LinkedList<>();
      queue.add(""+x);
      queue.add(""+y);
      int count = 2;
      while(count<nth){
        String tmp = queue.remove();
        String stable = tmp;
        if(count%2==0){
          tmp+=x;
        }else{
          tmp+=y;
        }
        queue.add(tmp);
        count++;
        if(count==nth){
          firstPart = tmp;
          break;
        }
        if(count%2==0){
          stable+=x;
        }else{
          stable+=y;
        }
        queue.add(stable);
        count++;
        if(count==nth){
          firstPart = stable;
          break;
        }
      }
    }
    return firstPart+new StringBuilder(firstPart).reverse().toString();
  }
}
