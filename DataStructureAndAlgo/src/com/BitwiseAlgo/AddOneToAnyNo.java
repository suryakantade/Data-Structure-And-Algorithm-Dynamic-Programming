package com.BitwiseAlgo;

public class AddOneToAnyNo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		addOne(7);
	}
	// 111
	//1000
	//1100
	public static void addOne(int no){
		 int m = 1; 
         int n = ~m;
         System.out.println(n);
	        // Flip all the set bits  
	        // until we find a 0 
		 int xx = no & m;
	        while(  xx== 1) 
	        { 
	            no = no ^ m; 
	            m <<= 1; 
	        } 
	      
	        // flip the rightmost 0 bit  
	        no = no ^ m; 
		System.out.println(no);
	}
}
