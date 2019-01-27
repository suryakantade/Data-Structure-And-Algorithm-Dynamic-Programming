package com.surya.Serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class SerializationUtil {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Employee employee = new Employee();
		employee.setAge(23);
		employee.setId(1);com.surya.Serialization.Employee; local class incompatible: 
		stream classdesc serialVersionUID = 1, local class serialVersionUID = 2
		employee.setName("surya");
		serialize(employee);
		deSerialize();*/
		//-------------------------------------------------
		Developer d = new Developer();
		d.hashCode();
		serialize(d);
		deSerialize();
	}

	public static void serialize(Object employee) {
		try {
			FileOutputStream fos = new FileOutputStream("serialize.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(employee);
			System.out.println("object serialized");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public static void deSerialize(){
		try{
		FileInputStream fis = new FileInputStream("serialize.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Employee e = (Employee) ois.readObject();
		System.out.println("Object deserialized " +e);
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}

}
