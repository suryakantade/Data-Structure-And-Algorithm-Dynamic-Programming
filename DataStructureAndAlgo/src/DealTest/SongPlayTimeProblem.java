package DealTest;

import java.util.ArrayList;
import java.util.List;

public class SongPlayTimeProblem {
  public static boolean isFound = false;
  public static void main(String[] args) {
    SongPlayTimeProblem songPlayTimeProblem = new SongPlayTimeProblem();
    int[] tc1 = {4, 1, 10, 12, 5, 2};
    System.out.println(songPlayTimeProblem.isPlayListPossible(tc1, tc1.length, 0));


  }

  public boolean isPlayListPossible(int[] songsTime, int N, int travelTime){
    List<Integer> list = new ArrayList<>();
    for(int i =0;i<songsTime.length;i++){
      list.add(songsTime[i]);
    }
    getAllPermutation(list, new ArrayList<>(), travelTime);

    return SongPlayTimeProblem.isFound;

  }

  public void getAllPermutation(List<Integer> s, List<Integer> tmp, int travelTime){
    //System.out.println(tmp);

    if(this.getSum(tmp) == travelTime || isFound){
      SongPlayTimeProblem.isFound = true;
      return;
    }
    if (null == s || s.isEmpty() ){
      return;
    }
    for (int i = 0;i<s.size();i++){
      List<Integer> tmpUpdated = new ArrayList<>(tmp);
      tmpUpdated.add((Integer) s.get(i));
      List<Integer> sUpdated = new ArrayList<>(s.subList(0, i));
      sUpdated.addAll(s.subList(i + 1, s.size()));
      getAllPermutation(sUpdated,
          tmpUpdated, travelTime);
    }
  }

  public Integer getSum(List<Integer> list){
    int tmp = 0;
    for(Integer i : list){
      tmp+=i;
    }
    return tmp;
  }

}
