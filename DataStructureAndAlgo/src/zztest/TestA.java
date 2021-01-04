package zztest;

public class TestA {

  public static void main(String[] args) {
    System.out.println(find(new int[]{1,2,2,3,3}, 0, 4));
  }

  public static int find(int[] arr, int start, int end){
    int mid = (start+end)/2;

    if(arr[mid] != arr[mid+1] && arr[mid]!= arr[mid-1]){
      return arr[mid];
    }

    if(arr[mid]==arr[mid+1] && (mid-start)%2==1){
      return find(arr, mid, end);
    } else if(arr[mid]==arr[mid-1] && (end-mid)%2==1){
      return find(arr, start, mid);
    } else{
      return -1;
    }
  }
}
