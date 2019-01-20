package java_hw5;

import java.util.*;
import java.text.*;
import java.io.*;

/**
 * This class is for testing the functionalities of appointments.
 * It let users to add new appointments, save appointments information
 * into a txt file, load existing appointment information,
 * and check whether an appointment occurs on a specific date
 * @author tianfu
 */
public class Tester {

	/**
	 * prints a list of choices for user to choose
	 * @return the choice of user input in between 1 and 4
	 */
	private static int getUserChoice() {
		Scanner scan = new Scanner(System.in); // create a new scanner
		
		int choice = 0; // initialize user choice
		while (true) {
			try {
				// print menu choices
				System.out.println("Welcome! Please choose one of the following choice:");
				System.out.println("1    Add a new appointment");
				System.out.println("2    Save all appointments to a text file");
				System.out.println("3    Load all appointments from a text file");
				System.out.println("4    Check whether appointments occur on a specific date");
				System.out.println("5    Quit");
				System.out.print("Your choice:");
				choice = scan.nextInt();
				// only choices between 1 and 4 are valid
				if (choice>=1 && choice<=5) {
					break; // break the loop until the input is a valid integer choice
				}
				else {
		    	    System.out.println("Please enter a choice that is GIVEN ABOVE!!");
		        }
			}
			// if the next token does not match the Integer regular expression
			// an exception will be thrown
			catch (InputMismatchException e) {
				System.out.println("Please enter a VALID choice!!");
				scan.nextLine(); // skip the remaining invalid input
			}
		}
		return choice;
	}
	
	/**
	 * ask the user to enter a choice of appointment type
	 * @return type choice
	 */
	private static int getAppType() {
        Scanner scan = new Scanner(System.in); // create a new scanner
		
		int choice = 0; // initialize user choice
		while(true) {
			try {
		        System.out.println("What type of appointment do you want to add?");
		        System.out.println("Please enter one of following: ");
		        System.out.println("1       Onetime");
		        System.out.println("2       Daily");
		        System.out.println("3       Monthly");
		        choice = scan.nextInt();
			    // only choices between 1 and 4 are valid
			    if (choice>=1 && choice<=3) {
				    break; // break the loop until the input is a valid integer choice
			    }
			    else {
		    	    System.out.println("Please enter a choice that is GIVEN ABOVE!!");
		        }
			}
			// if the next token does not match the Integer regular expression
			// an exception will be thrown
			catch (InputMismatchException e) {
				System.out.println("Please enter a VALID choice!!");
				scan.nextLine(); // skip the remaining invalid input
			}
		}
	    return choice; // user's choice of new appointment type
	}
	
	/**
	 * ask the user to enter a year of appointment
	 * @param s question to ask the user
	 * @return year number selected
	 */
	private static int getYear(String s) {
        Scanner scan = new Scanner(System.in); // create a new scanner
		
		int choice = 0; // initialize user choice
		while(true) {
			try {
		        System.out.println(s);
		        choice = scan.nextInt();
			    // only years between 1900 and 2018 are valid
			    if (choice>=1900 && choice<=2018) {
				    break; // break the loop until the input is a valid integer choice
			    }
			    else {
			    	System.out.println("Please enter a year between 1900 and 2018!!");
			    }
			}
			// if the next token does not match the Integer regular expression
			// an exception will be thrown
			catch (InputMismatchException e) {
				System.out.println("Please enter a VALID year! Try Again!");
				scan.nextLine(); // skip the remaining invalid input
			}
		}
	    return choice; // user's choice of new appointment year		
	}
	
	/**
	 * ask the user to enter a month of appointment
	 * @param s question to ask the user
	 * @return month number selected
	 */
	private static int getMonth(String s) {
        Scanner scan = new Scanner(System.in); // create a new scanner
		
		int choice = 0; // initialize user choice
		while(true) {
			try {
		        System.out.println(s);
		        choice = scan.nextInt();
			    // only choices between 1 and 12 are valid
			    if (choice>=1 && choice<=12) {
				    break; // break the loop until the input is a valid integer choice
			    }
			    else {
			    	System.out.println("Please enter a month between 1 and 12!!");
			    }
			}
			// if the next token does not match the Integer regular expression
			// an exception will be thrown
			catch (InputMismatchException e) {
				System.out.println("Please enter a VALID month! Try Again!");
				scan.nextLine(); // skip the remaining invalid input
			}
		}
	    return choice; // user's choice of new appointment month
	}
	
	/**
	 * ask the user to enter a day from a given month
	 * @param s menu question
	 * @param month month of the day
	 * @return day number selected
	 */
	private static int getDay(String s, int month) {
        Scanner scan = new Scanner(System.in); // create a new scanner
		
		int choice = 0; // initialize user choice
		while(true) {
			try {
		        System.out.println(s);
		        choice = scan.nextInt();
		        // months with 31 days
		        if(month==1 || month==3 || month==5 || month==7 || month==8||
		           month==10 || month==12) {
			        // only choices between 1 and 31 are valid
			        if (choice>=1 && choice<=31) {
				        break; // break the loop until the input is a valid integer choice
			        }
			        else {
			    	    System.out.println("Please enter a day between 1 and 31!!");
			        }
		        }
		        // assume feburary has 29 days
		        else if(month==2) {
		        	// only choices between 1 and 29 are valid
			        if (choice>=1 && choice<=29) {
				        break; // break the loop until the input is a valid integer choice
			        }
			        else {
			    	    System.out.println("Please enter a day between 1 and 29!!");
			        }
		        }
		        else {
		        	// only choices between 1 and 30 are valid
			        if (choice>=1 && choice<=30) {
				        break; // break the loop until the input is a valid integer choice
			        }
			        else {
			    	    System.out.println("Please enter a day between 1 and 30!!");
			        }
		        }
			}
			// if the next token does not match the Integer regular expression
			// an exception will be thrown
			catch (InputMismatchException e) {
				System.out.println("Please enter a VALID day! Try Again!");
				scan.nextLine(); // skip the remaining invalid input
			}
		}
	    return choice; // user's choice of new appointment month
	}
	
	/**
	 * Get the description of an appointment
	 * @return user-entered description of appointment
	 */
	private static String getDescription() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter a description for this appointment");
		return scan.nextLine();
	}
	
	/**
	 * This function will load information about a specific appointment and use that
	 * information to create an appointment object
	 * 
	 * ASSUMPTION: appointment information stored in the arraylist of string is
	 * well formated (follows format of originally designed type, description, date)
	 * 
	 * @param list a string arraylist of appointments' information
	 * @param index location of the appointment in the list
	 * @return a newly created Appointment object
	 * @throws Exception
	 */
	private static Appointment loadApp(ArrayList<String> list, int index) throws Exception{
		// initialize integer to store dates information
		int year = -1;
		int month = -1;
		int day = -1;
		int startYr = -1;
		int startMon = -1;
		int startDay = -1;
		int endYr = -1;
		int endMon = -1;
		int endDay = -1;
		// a string array of appointment information
		String[] appointment = list.get(index).split(";");
		String full_type = appointment[0];
		String type = full_type.split(":")[1]; // get the type of appointment
		String full_desc = appointment[1];
		String description = full_desc.split(":")[1]; // get description of appointment
		if (type.equals("Onetime")) {
			String full_date = appointment[2].split(":")[1];
			String mm = full_date.split("/")[0]; // month as a string
			String dd = full_date.split("/")[1]; // day as a string
			String yyyy = full_date.split("/")[2]; // year as a string
			try {
				// change all year,month,day into integers
				year = Integer.parseInt(yyyy);
				month = Integer.parseInt(mm);
				day = Integer.parseInt(dd);
			}
			catch (InputMismatchException e) { // notify exception
				System.out.println("EXCEPTION! WRONG DATE FORMAT");
				e.printStackTrace();
			}
		    Appointment a1 = new Onetime(description, year, month, day);
		    return a1;
		}
		else if (type.equals("Daily")) {
			String full_start = appointment[2].split(":")[1];
			String full_end = appointment[3].split(":")[1];
			String startmm = full_start.split("/")[0]; // start month as a string
			String startdd = full_start.split("/")[1]; // start day as a string
			String startyyyy = full_start.split("/")[2]; // start year as a string
			String endmm = full_end.split("/")[0]; // end month as a string
			String enddd = full_end.split("/")[1]; // end day as a string
			String endyyyy = full_end.split("/")[2]; // end year as a string
			try {
				// change all year,month,day into integers
				startYr = Integer.parseInt(startyyyy);
				startMon = Integer.parseInt(startmm);
				startDay = Integer.parseInt(startdd);
				endYr = Integer.parseInt(endyyyy);
				endMon = Integer.parseInt(endmm);
				endDay = Integer.parseInt(enddd);
			}
			catch (InputMismatchException e) { // notify exception
				System.out.println("EXCEPTION! WRONG DATE FORMAT");
				e.printStackTrace();
			}
		    Appointment a2 = new Daily(description, startYr, startMon, startDay,
		    		                   endYr, endMon, endDay);
		    return a2;
		}
		else {
			String start = appointment[3].split(":")[1];
			String end = appointment[4].split(":")[1];
			String app_day = appointment[2].split(":")[1]; // day of appointment as a string
			String startm = start.split("/")[0]; // start month as a string
			String startyy = start.split("/")[1]; // start year as a string
			String endm = end.split("/")[0]; // end month as a string
			String endyy = end.split("/")[1]; // end year as a string
			try {
				// change all year,month,day into integers
				startYr = Integer.parseInt(startyy);
				startMon = Integer.parseInt(startm);
				day = Integer.parseInt(app_day);
				endYr = Integer.parseInt(endyy);
				endMon = Integer.parseInt(endm);
			}
			catch (InputMismatchException e) { // notify exception
				System.out.println("EXCEPTION! WRONG DATE FORMAT");
				e.printStackTrace();
			}
		    Appointment a3 = new Monthly(description, startYr, startMon, day,
		    		                   endYr, endMon);
		    return a3;
		}
	}
	
	/**
	 * main program execution
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// a list of appointments
		ArrayList<Appointment> app_list = new ArrayList<Appointment>();
		
		// initialize integers and string to store information later on
		int type;
		int year;
		int month;
		int day;
		int startYr;
		int startDay;
		int startMon;
		int endYr;
		int endMon;
		int endDay;
		String description;
		
		// following are strings as questions to ask user later on in the program
		String s1 = "Please enter year of appointment as a number (between 1900 and 2018)";
		String s2 = "Please enter month of appointment as a number (between 1 and 12)";
		String s3 = "Please enter day of appointment as a number (e.g. 29)";
		String s4 = "Please enter start year of appointment as a number (between 1900 and 2018)";
		String s5 = "Please enter end year of appointment as a number (between 1900 and 2018)";
		String s6 = "Please enter start month of appointment as a number (between 1 and 12)";
		String s7 = "Please enter end month of appointment as a number (between 1 and 12)";
		String s8 = "Please enter start day of appointment as a number (e.g. 29)";
		String s9 = "Please enter end day of appointment as a number (e.g. 29)";
		
		int user_option = getUserChoice(); // get the user choice
		
		while(user_option!=5) {
			if(user_option==1) {
				type = getAppType();
				Appointment app_to_enter;
				if(type==1) { // onetime appointment
					description = getDescription();
					year = getYear(s1);
					month = getMonth(s2);
				    day = getDay(s3, month);
				    // create a new one-time appointment and add it to the appointment list
				    app_to_enter = new Onetime(description, year, month, day);
				    app_list.add(app_to_enter);
				}
				else if(type==2) { // daily appointment
					description = getDescription();
					startYr = getYear(s4);
					startMon = getMonth(s6);
					startDay = getDay(s8, startMon);
					endYr = getYear(s5);
					endMon = getMonth(s7);
					endDay = getDay(s9, endMon);
					// create a new daily appointment and add it to the appointment list
					app_to_enter = new Daily(description, startYr, startMon, startDay,
				                             endYr, endMon, endDay);
					app_list.add(app_to_enter);
				}
				else { // monthly appointment
					description = getDescription();
					startYr = getYear(s4);
					startMon = getMonth(s6);
					endYr = getYear(s5);
					endMon = getMonth(s7);
					day = getDay(s3, startMon);
					// create a new monthly appointment and add it to the appointment list
					app_to_enter = new Monthly(description, startYr, startMon, day,
				                               endYr, endMon);
					app_list.add(app_to_enter);
				}
				System.out.println("Appointment successfully added-------------------------------");
				System.out.println(app_to_enter.toString());
				user_option = getUserChoice();
			}
			else if(user_option==2) { // write appointment info to an output text file
				// where to save the file
				String filepath = "/Users/tianfu/Desktop/MSiA422Java/Java_HW5/src/appointment_saved.txt";
				FileWriter fw = null; // initialize filewriter to null
				BufferedWriter bw = null; // initialize bufferedwriter to null
				try {
					fw = new FileWriter(filepath); // save in the specified name and path
					bw = new BufferedWriter(fw);
					
					for(Appointment app: app_list) {
					    bw.write(app.toString() + "\n"); // save each appointment info as a separate line
					}
				} 
				catch (IOException e) { // catches exception and prints the trace
					e.printStackTrace();
				}
				finally {
					try {
						if (bw != null)
							bw.close(); // close bufferedwriter

						if (fw != null)
							fw.close(); // close filewriter
					} 
					catch (IOException ex) {
						ex.printStackTrace(); // print exception trace
					}
				}
				System.out.println("FINISHED! appointment_saved.txt SAVED to the desired location!");
				user_option = getUserChoice();
			}
			else if(user_option==3) { // load appointments from txt file
				String pathname = "/Users/tianfu/Desktop/MSiA422Java/Java_HW5/src/appointments.txt";
				File file = new File(pathname);
				ArrayList<String> list = new ArrayList<String>();
				
				try (Scanner scanner = new Scanner(file)) {
					while (scanner.hasNextLine()) {
						String line = scanner.nextLine(); // read each line in the txt file					
						list.add(line); // add to the list of appointments info as string
					}
				}
				catch(IOException e) {
					e.printStackTrace();
				}
				
				// to store every appointment in the file into existing appointments list
				for(int i=0; i<list.size(); i++) {
					Appointment appToAdd = loadApp(list, i);
					System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"+
					                   "+++++++++++++++++++++++++++++++");
					// let the user know one appointment has successfully been loaded
					System.out.println("One Appointment loaded:");
					System.out.println(appToAdd.toString()); // print out new appointment info
					System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"+
	                                   "+++++++++++++++++++++++++++++++");
					app_list.add(appToAdd); // add this new appointment into list
				}
				user_option = getUserChoice();
			}
			else {
				startYr = getYear(s1); // get the year to check
				startMon = getMonth(s2); // get the month to check
				startDay = getDay(s3, startMon); // get the day to check
				int counter = 0; // to count number of appointments occurs on the specific date
				for(Appointment app: app_list) { // check for every appointment
					// if the appointment occurs on that date, prints its info
					if(app.occursOn(startYr, startMon, startDay)) {
						counter ++;
						System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"+
								           "+++++++++++++++++++++++++++++++");
						System.out.println(app.toString());
						System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"+
						                   "+++++++++++++++++++++++++++++++");
					}
				}
				if(counter==0) {
					System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			        System.out.println("NO APPOINTMENT FIND FOR THE DATE SPECIFICED. Sorry~");
			        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
				}
				user_option = getUserChoice();
			}
		}
		
		// when the user chooses to quit
		if(user_option==5) {
			System.out.println("Byebye!!!!!!!");
		}
	}

}
