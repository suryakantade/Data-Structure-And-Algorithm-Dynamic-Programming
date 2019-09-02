package hackerrank;

//https://www.hackerrank.com/challenges/camelcase/problem
public class CamelCasing {
  public static void main(String[] args) {
    System.out.println((int) 'Z');
    System.out.println(findNoOfWords("aBigThree"));


  }

  public static int findNoOfWords(String input) {
    int count = 0;
    if (null != input && !input.isEmpty()) {
      count = 1;
      for (Character c : input.toCharArray()) {
        if ((int) c >= 65 && (int) c <= 90) {
          count += 1;
        }
      }
    }
    return count;
  }
}

