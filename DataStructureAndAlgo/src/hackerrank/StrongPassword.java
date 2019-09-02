package hackerrank;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class StrongPassword {
  public static void main(String[] args) {
    /*String s = "!@#$%^&*()-+";
    for (char c:s.toCharArray()){
      System.out.println((int)c);
    }*/
    //System.out.println((int) 'z');
    System.out.println(noOfCharToBeAdded("Ab1"));
    System.out.println(noOfCharToBeAdded("#HackerRank"));
  }

  public static int noOfCharToBeAdded(String password) {
    boolean hasLower = false, hasUpper = false, hasSpecial = false;
    Set<Integer> specialChars =
        new HashSet<>(Arrays.asList(33, 64, 35, 36, 37, 94, 38, 42, 40, 41, 45, 43));
    for (char c : password.toCharArray()) {
      if ((int) c >= 65 && (int) c <= 90) {
        hasUpper = true;
      } else if ((int) c >= 97 && (int) c <= 122) {
        hasLower = true;
      } else if (specialChars.contains((int) c)) {
        hasSpecial = true;
      }
    }
    int charNeeded = 0;
    if (!hasLower) {
      charNeeded++;
    }
    if(!hasLower){
      charNeeded++;
    }
    if(!hasUpper)
      charNeeded++;
    return charNeeded + password.length() >= 6 ?
        charNeeded :
        charNeeded + (6 - (password.length() + charNeeded));

  }
}
