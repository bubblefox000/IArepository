package exceptions;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class TimeFormatException {
	
	private static String dateFormat = "k, MMM d, Y";

	public TimeFormatException(String dateFormat) {
		
		TimeFormatException.dateFormat = dateFormat;
	}

	public static boolean isValid(String dateStr) {
		DateFormat sdf = new SimpleDateFormat(dateFormat);
		sdf.setLenient(true);
		try {
			sdf.parse(dateStr);
		} catch (ParseException e) {
			return false;
		}
		return true;
		
	}
	
	
	
			
			
	

}
