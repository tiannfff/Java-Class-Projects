package java_hw5;

import java.util.*;
import java.text.*;

/**
 * This class documents monthly appointment
 * @author tianfu
 */
public class Monthly extends Appointment{
	private int day; // day of the appointment each month
	private Date start; // starting date
	private Date end; // ending date
	
	// constructor
	public Monthly(String desc, int startY, int startM, int day,
				 int endY, int endM) throws ParseException{
		this.setDescription(desc);
		this.day = day; // day of the appointment each month
		// format date as month/day/year
		SimpleDateFormat sdf = new SimpleDateFormat ("MM/yyyy");
		this.start = sdf.parse(String.format("%d/%d", startM, startY));
		this.end = sdf.parse(String.format("%d/%d", endM, endY));
	}
	
	// override super class occursOn method
	@Override
	public boolean occursOn(int year,int month,int day) {
		// first check if the day input is the day of appointment
		if(this.day != month) {
			return false;
		}
		else {
			// format date as month/day/year
			SimpleDateFormat sdf = new SimpleDateFormat ("MM/yyyy");
			Date date_check;
			try {
				date_check = sdf.parse(String.format("%d/%d", month, year));
				// check if year and month is in between starting and ending year and month
				return (date_check.compareTo(this.start)>0 && date_check.compareTo(this.end)<0);
			}
			catch(ParseException e) {
				System.out.println("Parse Exception");
				e.printStackTrace();
			}
			return false; // return false if exception occurs
		}
	}

	// override super class toString method
	@Override
	public String toString() {
		SimpleDateFormat outputDateFormat = new SimpleDateFormat("MM/yyyy");  
		// convert date object to a string in form of MM/yyyy
	    String start = outputDateFormat.format(this.start);
	    String end = outputDateFormat.format(this.end);
	    return String.format("Appointment type is:Monthly; Description:%s; Every month on:%d; from:%s; to:%s",
	        		         this.getDescription(),
	        		         this.day, start, end);	
	}
}
