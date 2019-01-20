package java_hw;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This program answers the following questions:
 * How many Employees exist in the file?
 * Who has the highest salary?
 * What is the average salary?
 * How many employees make above the average? 
 * What is the average age of employees?
 * it also write to an output file the employee names sorted according to their 
 * salary in ascending order
 * @author tianfu
 */
public class DataAnalysis {
	
	/**
	 * finds the size of the arraylist
	 * @param lst arraylist of strings of strings of information about employees
	 * @return the size of the arraylist
	 */
	private static int count(ArrayList<String> lst) {
		return lst.size(); // size indicates how many employees are there
	}
	
	/**
	 * finds highest salary from an arraylist of strings of information about employees
	 * @param lst arraylist of strings of information about employees
	 * @return highest salary of employees
	 */
	private static String highestSalary(ArrayList<String> lst) {
		// initialize max salary to be the salary of first employee
		int max = Integer.parseInt(lst.get(0).split(",")[2]);
		String name = lst.get(0).split(",")[0]; // get the name of first employee
		for (int i = 1; i < lst.size(); i++) {
			// get the salary of next person
			int salary = Integer.parseInt(lst.get(i).split(",")[2]);
			if (salary > max){ // when this person earns higher than current max salary
				max = salary; // update max salary
				name = lst.get(i).split(",")[0]; // update name of person have max salary
			}
		}
		return name;
	}
	
	/**
	 * finds average salary from an arraylist of strings of information about employees
	 * @param lst arraylist of strings of information about employees
	 * @return average salary of employees
	 */
	private static float averageSalary(ArrayList<String> lst) {
		int sum = 0; // initialize sum to summarize all salaries
		for (int i = 0; i < lst.size(); i++) {
			// get the salary of next person
			int salary = Integer.parseInt(lst.get(i).split(",")[2]);
			sum += salary; // add salary to the sum
		}
		float avg = (float) sum/lst.size(); // calculate average salary
		return avg;
	}
	
	/**
	 * finds average age from an arraylist of strings of information about employees
	 * @param lst arraylist of strings of information about employees
	 * @return average age of employees
	 */
	private static float averageAge(ArrayList<String> lst) {
		int sum = 0; // initialize sum to summarize all ages
		int currentYr = 2018; // used to calculate age
		for (int i = 0; i < lst.size(); i++) {
			String dob = lst.get(i).split(",")[1]; // get the date of birth of the employee
			int yob = Integer.parseInt(dob.split("/")[2]); // extract birth year
			sum = sum + (currentYr - yob); // currentYr-yob is the age of this employee
		}
		float avg = (float) sum/lst.size(); // calcualte average age
		return avg;
	}

	/**
	 * main program execution
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		ArrayList<String> list = new ArrayList<String>();
		try {
		    // pass the path to the file as a parameter 
	        File file = new File("/Users/tianfu/Desktop/MSiA422Java/HW4/employees.txt"); 
	        Scanner sc = new Scanner(file); 
	        // read each line of the file
	        while (sc.hasNextLine()) {
	            list.add(sc.nextLine());
	        }
		}
	    catch(FileNotFoundException e){
			e.printStackTrace();
		}
		
		// count and print number of employees listed in the file
		int number = count(list);
		System.out.println("**************************************************");
		System.out.println("How many Employees exist in the file?");
		System.out.println("There are a total of "+number+" employees");
		System.out.println("**************************************************");
		System.out.println();
		
		// find and print who has maximum salary among all employees in the file
		String name = highestSalary(list);
		System.out.println("**************************************************");
		System.out.println("Who has the highest salary?");
		System.out.println(name + " has the highest salary");
		System.out.println("**************************************************");
		System.out.println();
		
		// find and print average salary of employees
		float avg = averageSalary(list);
		System.out.println("**************************************************");
		System.out.println("What is the average salary?");
		System.out.println("The average salary is " + avg);
		System.out.println("**************************************************");
		System.out.println();
		
		int count = 0; // used to count number of employees having salary above average
		for (int i = 0; i < list.size(); i++) {
			if(Integer.parseInt(list.get(i).split(",")[2]) > avg) {
				count ++; // one more employee make above the average
			}
		}
		System.out.println("**************************************************");
		System.out.println("How many employees make above the average?");
		System.out.println(count + " employees make above the average");
		System.out.println("**************************************************");
		System.out.println();
		
		// find and print average age of employees
		float avgAge = averageAge(list);
		System.out.println("**************************************************");
		System.out.println("What is the average age of employees?");
		System.out.println("The average age of employees is " + avgAge);
		System.out.println("**************************************************");
		System.out.println();
		
		// sort employee names according to their salary in ascending order
		int pass_num;
		for (pass_num=list.size()-1; pass_num>0; pass_num--) {
			for(int i=0; i<pass_num; i++) {
				// get salary of two consecutive employees listed in the file
				int salary1 = Integer.parseInt(list.get(i).split(",")[2]);
				int salary2 = Integer.parseInt(list.get(i+1).split(",")[2]);
	            if (salary1 > salary2) { // when the first person earns higher
	            	// switch the position of two employees so that the one earns
	            	// a higher salary is listed later in the ArrayList
	            	String tmp = list.get(i);
	            	// a person earning less is listed at front
	                list.set(i, list.get(i+1));
	                // a person earning more is listed at later position
	                list.set(i+1, tmp);
	            }
			}
		}
		
		// write to an output file the employee names sorted according to their
		// salaries in ascending order
		String header = "Employee Name,Date of Birth,Salary"; // header of the file
		// specified path including the text file name to save sorted employees info
		String filepath = "/Users/tianfu/Desktop/MSiA422Java/Java_HW4/src/sorted_employee.csv";
		FileWriter fw = null; // initialize filewriter to null
		BufferedWriter bw = null; // initialize bufferedwriter to null
		try {
			fw = new FileWriter(filepath); // save in the specified name and path
			bw = new BufferedWriter(fw);
			
			bw.write(header+"\n"); // add header to the csv file
			
			for(String s:list) {
			    bw.write(s + "\n"); // save each employee as a separate line
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
	}

}
