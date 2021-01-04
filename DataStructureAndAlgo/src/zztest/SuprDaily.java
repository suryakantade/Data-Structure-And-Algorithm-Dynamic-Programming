package zztest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutput;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;

public class SuprDaily {

  //ObjectOutput

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter wr = new PrintWriter(System.out);
    int N = Integer.parseInt(br.readLine().trim());
    String[] arr_A = br.readLine().split(" ");
    int[] A = new int[3*N];
    for(int i_A=0; i_A<arr_A.length; i_A++)
    {
      A[i_A] = Integer.parseInt(arr_A[i_A]);
    }

    long out_ = maxTripletSum(A);
    System.out.println(out_);

    wr.close();
    br.close();
  }
  static long maxTripletSum(int[] A){
    // Write your code here

    A=Arrays.stream(A).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();

    long sum = 0l;
    for (int i =1;i<(A.length-(A.length/3));i+=2){
      sum+=A[i];
    }
    return sum;
  }
}







 /* static int calculate(char[][] K, String S, int n, int m) {
    //write your code here
    Map<Character, Pair> map = new HashMap<>();
    for (int i = 0;i <K.length;i++){
      for (int j = 0;j<K[i].length;j++){
        map.put(K[i][j],new Pair(i,j));
      }
    }

    int sum = 0;
    int x =0,y=0;
    for (int i = 0; i<S.length();i++){
      if (!map.containsKey(S.charAt(i))){
        return -1;
      }
      Pair pair = map.get(S.charAt(i));
      sum+=Math.abs(pair.getKey()-x)+Math.abs(pair.getValue()-y);
      x = pair.getKey();
      y = pair.getValue();
    }
    return sum;
  }
}*/

/*
class Pair{
  private Integer key;
  private Integer value;

  public Pair(Integer key, Integer value) {
    this.key = key;
    this.value = value;
  }

  public Integer getKey() {
    return key;
  }

  public void setKey(Integer key) {
    this.key = key;
  }

  public Integer getValue() {
    return value;
  }

  public void setValue(Integer value) {
    this.value = value;
  }
}*/
