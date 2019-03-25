package com.surya.designpattern;

public class AbstractFactoryPattern {

	public AbstractFactoryPattern() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		computer c =ComputerFactory.getComputer(new PCFactory("4gb", "2.6ghz", "1tb"));
		System.out.println(c);
	}

}
abstract class ComputerAbstractFactory{
	public abstract computer createComputer();
	public String RAM;
	public String CPU;
	public String HDD;
	public ComputerAbstractFactory(String rAM, String cPU, String hDD) {
		super();
		RAM = rAM;
		CPU = cPU;
		HDD = hDD;
	}
}

class PCFactory extends ComputerAbstractFactory{
	public PCFactory(String rAM, String cPU, String hDD) {
		super(rAM, cPU, hDD);
		// TODO Auto-generated constructor stub
	}

	public computer createComputer(){
		return new pc(RAM, CPU, HDD);
	}
}
class LaptopFactory extends ComputerAbstractFactory{
	public LaptopFactory(String rAM, String cPU, String hDD) {
		super(rAM, cPU, hDD);
		// TODO Auto-generated constructor stub
	}

	public computer createComputer(){
		return new Laptop(RAM, CPU, HDD);
	}
}
class ComputerFactory{
	public static computer getComputer(ComputerAbstractFactory computerAbstractFactory){
		return computerAbstractFactory.createComputer();
	}
}