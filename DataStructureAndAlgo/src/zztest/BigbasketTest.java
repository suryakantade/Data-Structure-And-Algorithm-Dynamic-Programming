package zztest;

import javax.xml.bind.SchemaOutputResolver;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class BigbasketTest {

  public static void main(String[] args) {
   /* String[] s = {"[{{{{}}}}]"};
    System.out.println(Arrays.toString(braces(s)));*/

//   int[] arr= {5,7,9,13,11,6,6,3,3};
//    System.out.println(countPairs(Arrays.asList(5,7,9,13,11,6,6,3,3),12));

    System.out.println(sortRoman(Arrays.asList("L IX","L V")));

  }

  public static List<String> sortRoman(List<String> names) {
    // Write your code here
    Collections.sort(names, new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        int i =o1.split(" ")[0].compareTo(o2.split(" ")[0]);
        if(i==0){
         return Integer.valueOf(decode(o1.split(" ")[1]))
              .compareTo(Integer.valueOf(decode(o2.split(" ")[1])));
        }
        return i;
      }
    });

    return names;
  }

  private static int decodeSingle(char letter) {
    switch(letter) {
      case 'M': return 1000;
      case 'D': return 500;
      case 'C': return 100;
      case 'L': return 50;
      case 'X': return 10;
      case 'V': return 5;
      case 'I': return 1;
      default: return 0;
    }
  }
  public static int decode(String roman) {
    int result = 0;
    String uRoman = roman.toUpperCase(); //case-insensitive
    for(int i = 0;i < uRoman.length() - 1;i++) {
      if (decodeSingle(uRoman.charAt(i)) < decodeSingle(uRoman.charAt(i+1))) {
        result -= decodeSingle(uRoman.charAt(i));
      } else {
        result += decodeSingle(uRoman.charAt(i));
      }
    }
    //decode the last character, which is always added
    result += decodeSingle(uRoman.charAt(uRoman.length()-1));
    return result;
  }





















  public static int countPairs(List<Integer> arr, long k) {
    // Write your code here
    Map<Integer,Integer> map = new HashMap<>();
     for(int i = 0;i<arr.size()-1;i++){
       for (int j =i+1;j<arr.size();j++){
         if(arr.get(i)+arr.get(j)==k){
           if(map.get(arr.get(i)) == null) {
             map.put(arr.get(i), arr.get(j));
             map.put(arr.get(j), arr.get(i));
           }
         }
       }
     }
     return map.keySet().size()%2==0?map.keySet().size()/2:(map.keySet().size()/2)+1;
  }





















  static String[] braces(String[] values) {
    String[] arr = new String[values.length];
    Map<Character, Character> map = new HashMap<>();
    map.put('}', '{');
    map.put(')', '(');
    map.put(']', '[');
    for (int i = 0; i < values.length; i++) {
      Stack<Character> stack = new Stack<>();
      String s = values[i];
      loop2:
      for (int j = 0; j < s.length(); j++) {
        if (stack.isEmpty()) {
          stack.push(s.charAt(j));
        } else {
          Character c = stack.pop();
          if (null != map.get(s.charAt(j))) {
            if (!c.equals(map.get(s.charAt(j)))) {
              stack.push(c);
              stack.push(s.charAt(j));
            }
          } else {
            stack.push(c);
            stack.push(s.charAt(j));
          }
        }
      }
      if (stack.isEmpty()) {
        arr[i] = "YES";
      } else {
        arr[i] = "NO";
      }
    }
    return arr;

  }
}
