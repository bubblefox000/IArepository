package bubble.toolkit.com;

import java.text.SimpleDateFormat;
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
		
		
		
	}	


}
