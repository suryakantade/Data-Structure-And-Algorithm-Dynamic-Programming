package com.designpattern.designpattern;

public class FactoryDesignpattern {

	public FactoryDesignpattern() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Factory factory = new Factory();
		computer c = factory.getComputer("laptop", "8", "2.6", "1tb");
		System.out.println(c.toString());
	}

}
class Factory{
	public static computer getComputer(String type,String ram,String cpu,String hdd){
		if(type.equalsIgnoreCase("pc")){
			return new pc(ram, cpu, hdd);
		}else if (type.equals("laptop")) {
			return new Laptop(ram, cpu, hdd);
		}
		return null;
	}
}

abstract class computer{
	public abstract String getRAM();
	public abstract String getCPU();
	public abstract String getHDD();
	
}
class pc extends computer{
	public String RAM;
	public String CPU;
	public String HDD;
	public pc(String rAM, String cPU, String hDD) {
		super();
		RAM = rAM;
		CPU = cPU;
		HDD = hDD;
	}
	public String getRAM() {
		return RAM;
	}
	public void setRAM(String rAM) {
		RAM = rAM;
	}
	public String getCPU() {
		return CPU;
	}
	public void setCPU(String cPU) {
		CPU = cPU;
	}
	public String getHDD() {
		return HDD;
	}
	public void setHDD(String hDD) {
		HDD = hDD;
	}
}
class Laptop extends computer{
	public String RAM;
	public String CPU;
	public String HDD;
	public Laptop(String rAM, String cPU, String hDD) {
		super();
		RAM = rAM;
		CPU = cPU;
		HDD = hDD;
	}
	public String getRAM() {
		return RAM;
	}
	public void setRAM(String rAM) {
		RAM = rAM;
	}
	public String getCPU() {
		return CPU;
	}
	public void setCPU(String cPU) {
		CPU = cPU;
	}
	public String getHDD() {
		return HDD;
	}
	public void setHDD(String hDD) {
		HDD = hDD;
	}
}