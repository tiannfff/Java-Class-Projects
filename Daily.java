package java_hw5;

import java.util.*;
import java.text.*;

/**
 * This class documents daily appointments
 * @author tianfu
 *
 */
public class Daily extends Appointment{
	private Date startDate; // starting date
	private Date endDate; // ending date
	
	// constructor
	public Daily(String desc, int startY, int startM, int startD,
			     int endY, int endM, int endD) throws ParseException{
		this.setDescription(desc);
		// format date as month/day/year
		SimpleDateFormat sdf = new SimpleDateFormat ("MM/dd/yyyy");
		this.startDate = sdf.parse(String.format("%d/%d/%d", startM, startD, startY));
		this.endDate = sdf.parse(String.format("%d/%d/%d", endM, endD, endY));
	}
	
	// override super class occursOn method
	@Override
	public boolean occursOn(int year,int month,int day) {
		SimpleDateFormat sdf = new SimpleDateFormat ("MM/dd/yyyy");
		Date date_check;
		try {
			date_check = sdf.parse(String.format("%d/%d/%d", month, day, year));
			// check if the input date is in between start date and end date
			return (date_check.compareTo(this.startDate)>0 && date_check.compareTo(this.endDate)<0);
		}
		catch(ParseException e) {
			System.out.println("Parse Exception");
			e.printStackTrace();
		}
		return false; // return false if exception occurs
	}

	// override super class toString method
	@Override
	public String toString() {
		SimpleDateFormat outputDateFormat = new SimpleDateFormat("MM/dd/yyyy");  
		// convert date object to a string in form of MM/dd/yyyy
	    String start = outputDateFormat.format(this.startDate);
	    String end = outputDateFormat.format(this.endDate);
	    return String.format("Appointment type is:Daily; Description:%s; Start date is:%s; End date is:%s",
	        		         this.getDescription(),
	        		         start, end);
	}
}
