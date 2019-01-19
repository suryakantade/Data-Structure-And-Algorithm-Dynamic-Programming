package zztest;

public  class AbstractClass {
	static{
		System.out.println("in static");
	}
	public static void main(String[] args) {
		method();
	}
	public static void method(){
		System.out.println(Runtime.getRuntime().availableProcessors());
		
		System.out.println("https".compareToIgnoreCase("http"));
	}
	
}
