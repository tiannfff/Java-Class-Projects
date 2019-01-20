package java_hw5;

import java.util.*;
import java.text.*;

/**
 * This class documents onetime appointments
 * @author tianfu
 */
public class Onetime extends Appointment{
	private Date date;
	
	// constructor
	public Onetime(String desc, int year, int month, int day) throws ParseException{
		this.setDescription(desc);
		// format date as month/day/year
		SimpleDateFormat sdf = new SimpleDateFormat ("MM/dd/yyyy");
		this.date = sdf.parse(String.format("%d/%d/%d", month, day, year));
	}
	
	// override super class occursOn method
	@Override
	public boolean occursOn(int year,int month,int day) {
		// format date as month/day/year
		SimpleDateFormat sdf = new SimpleDateFormat ("MM/dd/yyyy");
		Date date_check;
		try {
			date_check = sdf.parse(String.format("%d/%d/%d", month, day, year));
			// check if two dates are the same
			boolean match = date_check.equals(this.date);
			return match;
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
	    String date_str = outputDateFormat.format(this.date);
	    return String.format("Appointment type is:Onetime; Description:%s; Date is:%s",
	        		         this.getDescription(),
	        		         date_str);
	}
}
