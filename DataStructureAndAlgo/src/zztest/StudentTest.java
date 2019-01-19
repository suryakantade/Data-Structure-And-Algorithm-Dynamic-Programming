package zztest;

import java.util.Arrays;

class Student {

	String name;
	String roll;
	public String getRoll() {
		return roll;
	}

	public void setRoll(String roll) {
		this.roll = roll;
	}

	public Student(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", roll=" + roll + "]";
	}
	
}
public class StudentTest{
	public static void main(String[] args) {
		Student[] studentarray= new Student[5];
		for(int i= 0 ;i<studentarray.length;i++){
			Student s = new Student("surya"+i);
			studentarray[i]= s;
		}
		for(int i = 0;i<studentarray.length;i++){
			Student s= studentarray[i];
			s.setRoll(""+i);
		}
		Arrays.asList(null);
		System.out.println(Arrays.toString(studentarray));
	}
}