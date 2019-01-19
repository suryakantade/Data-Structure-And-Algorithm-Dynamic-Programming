package zztest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RaedFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File file = new File("D:\\test workspace _ eclipse_Meijer\\zztest\\src\\query.txt");
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(file));
			List<String> tables = new ArrayList<>();
			String st;
			while ((st = br.readLine()) != null) {
				if(st.startsWith("ALTER TABLE")){
					//System.out.println(st.split(" ")[2]);
					tables.add(st.split(" ")[2]);
				}
			}
			Collections.sort(tables);
			for(String s : tables){
				System.out.println(s);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


