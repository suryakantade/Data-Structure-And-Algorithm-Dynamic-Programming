package date.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calendar now = Calendar.getInstance();
		now.add(Calendar.DATE, Integer.parseInt("12"));
		Date date = now.getTime();             
		SimpleDateFormat format1 = new SimpleDateFormat("MM/dd/YYYY");
		String date1 = format1.format(date);
		System.out.println(date1);
	}

}
