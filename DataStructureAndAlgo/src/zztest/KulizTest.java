package zztest;

public class KulizTest {

  public static void main(String[] args) {
    System.out.println(findSmallestDivisor("lrbb", "lrbb"));

  }

  public static int findSmallestDivisor(String s, String t) {

    int index = 0;
    for (int i = 1; i <= s.length() / 2; i++) {
      if (s.regionMatches(0, t, i, i)) {
        index = i;
      }
    }
    index = 0;
    for (int idx = 1; idx <=s.length() / 2; idx++) {
      if (s.regionMatches(0, t, idx, idx)) {
        index = idx;
      }
    }
    String small = s.substring(0, index);

    // Check to make certain this isn't just a repeated character.
    small = small.replaceAll("^(.)\\1+$", "$1");
    boolean isDivisible = s.length() % t.length() == 0;
    System.out.printf("%s is " + ((isDivisible) ? "" : "NOT") + " divisible by %s%n", s, t);

    System.out.println("The smallest string is " + small + "\n");
    return 0;
  }

  /*public static List<Integer> findSubsequence(List<Integer> arr) {
    // Write your code here
    Set<Integer> set= new HashSet<>();
    Stack<Integer> stack = new Stack<>();
    for (Integer i : arr){
      if (set.contains(i)){
        if (!stack.isEmpty() && stack.peek()>i){
          return Arrays.asList(-1);
        }else{
          stack.push(i);
        }
      }
      set.add(i);
    }
    return new ArrayList<>(stack);
  }*/
}
