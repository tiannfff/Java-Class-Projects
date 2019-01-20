package java_hw5;

import java.util.Date;

/**
 * This is a super class of onetime, daily and monthly appointments
 * @author tianfu
 */
public abstract class Appointment {
	private String description; // description of appointment
	private Date date; // appointment date
	
	/**
	 * This function gets the description of an appointment
	 * @return String description of the appointment
	 */
	public String getDescription() {
		return this.description;
	}
	
	/**
	 * This function sets the description of an appointment
	 * @param desc new description
	 */
	public void setDescription(String desc) {
		this.description = desc;
	}
	
	/**
	 * This function checks if an appointment happened on a specific year-month-day
	 * @param year year of appointment
	 * @param month month of appointment
	 * @param day day of appointment
	 * @return whether an appointment happened on a specific year-month-day
	 */
	public abstract boolean occursOn(int year,int month,int day);
	
	/**
	 * This function converts an appointment to a string with appointment date
	 * and description
	 */
	public abstract String toString();

}
