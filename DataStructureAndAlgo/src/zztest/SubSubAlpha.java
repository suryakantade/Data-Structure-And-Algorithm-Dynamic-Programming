package zztest;

class Alpha 
{
     String s = " ";
    private Alpha() 
    {
        s += "alpha ";
    }
}
private class SubAlpha extends Alpha 
{
	
}
 
public class SubSubAlpha extends Alpha 
{
    
    public static void main(String[] args) 
    {
    	
    	SubSubAlpha a= new SubSubAlpha();
        System.out.println(a.s);
        System.out.println("a"=="a");
    }
}