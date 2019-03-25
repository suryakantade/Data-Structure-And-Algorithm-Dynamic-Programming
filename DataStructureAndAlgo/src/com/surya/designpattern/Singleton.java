package com.surya.designpattern;

public class Singleton {

	public Singleton() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thisissingletonclass obj1 = Thisissingletonclass.getSingletonObject();
		Thisissingletonclass obj2 = Thisissingletonclass.getSingletonObject();
		System.out.println(obj1==obj2);
	}

}
class Thisissingletonclass{
	private static Thisissingletonclass obj;
	private Thisissingletonclass(){
		
	}
	public static Thisissingletonclass getSingletonObject(){
		
		if(obj==null){
			obj = new Thisissingletonclass();
		}
		return obj;
	}
}
