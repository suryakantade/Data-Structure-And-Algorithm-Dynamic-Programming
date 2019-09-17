package com.dynamicProgramming;

public class PermutationOfString {
  public static void main(String[] args) {
    PermutationOfString ps = new PermutationOfString();
    ps.getAllPermutation("asdf","");
  }
  // a s d f g
  //1 2 3 4 5 -2
  public void getAllPermutation(String s, String tmp){
    System.out.println(tmp);
    if (null == s || s.isEmpty()){
      return;
    }
    for (int i = 0;i<s.length();i++){
      getAllPermutation(s.substring(0,i)+s.substring(i+1),tmp+s.charAt(i));
    }
  }
}
