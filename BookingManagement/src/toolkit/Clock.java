package toolkit;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.Calendar;

public class Clock{
	
	/*public static void main(String args[]) {
		
		
		Clock clock = new Clock();            
		System.out.println(time);
		
	}
	*/

	public static String time;
	
	public  Clock() {
		
		String time;
		Calendar calendar;
		SimpleDateFormat timeFormat;                               //this code gets the current time in the h.m.s timezone format
		
		timeFormat = new SimpleDateFormat("HH:mm:ss z");
		
		time = timeFormat.format(Calendar.getInstance().getTime());
		
		Clock.time = time;
		
		DateTimeFormatter strictTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss z")
		            .withResolverStyle(ResolverStyle.STRICT);                                 //stricly validates that the time is in the correct format
		
	}	


}
