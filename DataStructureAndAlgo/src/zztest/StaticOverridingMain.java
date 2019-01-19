package zztest;

class ParentWithStatic{
	public int method(){
		return 1;
	}
}
class StaticOverriding extends ParentWithStatic{
	
	public int method(int a){
		return 2;
	}
}

public class StaticOverridingMain{
	public static void main(String[] args) {
		ParentWithStatic p = new StaticOverriding();
		System.out.println();
	}
}