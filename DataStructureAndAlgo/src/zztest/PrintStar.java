package zztest;

public class PrintStar {


  public static void main(String[] args) {


    /*for (int i = 0;i<10000000;i++){
      int c = i;
      while (c>=0) {
        System.out.print("* ");
        c--;
      }
      System.out.println();
    }*/


    for (int i =0; i<100;i++ ){
      System.out.println("Ayanna is a good girl");
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }


}
