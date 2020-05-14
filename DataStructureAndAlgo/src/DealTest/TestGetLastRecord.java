package DealTest;


public class TestGetLastRecord {
  LinkedNode<Integer> root = null;
  int totalOrdersSupported = 0;
  int currentSize = 0;

  public TestGetLastRecord(int totalOrdersSupported) {
    this.totalOrdersSupported = totalOrdersSupported;
  }

  public static void main(String[] args) {
    TestGetLastRecord testGetLastRecord = new TestGetLastRecord(10);
    for(int i = 0;i<=100;i++){
      testGetLastRecord.recordOrder(i);
    }
    System.out.println(testGetLastRecord.findIthLast(7));

  }
  //record
  public void recordOrder(int orderId){
    currentSize++;
    if(this.root == null){
      this.root = new LinkedNode<>(orderId);
    }else {
      LinkedNode<Integer> tmpNode = new LinkedNode<>(orderId);
      tmpNode.next = root;
      root = tmpNode;
    }
    if(totalOrdersSupported <currentSize){
      this.deleteLast();
    }
  }
  //find ith last element
  public int findIthLast(int i){
    LinkedNode<Integer> tmp =  this.root;
    int count = 1;
    if(i<1 || i>this.totalOrdersSupported){
      return -1;
    }
    while(count != i){
      tmp=tmp.next;
      count++;
    }
    return tmp.val;
  }

  public void deleteLast(){
    LinkedNode<Integer> tmp = root;
    while(null != tmp.next && null != tmp.next.next){
      tmp = tmp.next;
    }
    tmp.next = null;
    this.currentSize--;
  }

}


class LinkedNode<T>{
  public T val;
  public LinkedNode<T> next;

  public LinkedNode(T val) {
    this.val = val;
  }

  public T getVal() {
    return val;
  }

  public void setVal(T val) {
    this.val = val;
  }
}