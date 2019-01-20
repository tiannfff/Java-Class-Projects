package java_project;

import java.io.*;
import java.util.*;

/**
 * The MyPandas class is meant to replicate aspects of the Pandas library in Python
 * the class works in conjunction with the MyDataFrame class, which contains methods to manipulate and aggregate data
 * This class has 3 methods:
 * 1.  readCSV - read in an input file and store its values in a MyDataFrame object that allows for data manipulation and aggregation on the object
 * 2.  writeCSV - writes a MyDataFrame object to a csv file
 * 3.  concat - combines two MyDataFrame objects into one
 * 
 * @author Tian Fu, Max Holiber
 */

public class MyPandas {

	public static MyDataFrame readCSV (String path) throws Exception{
		/*
		 * This method takes a file path as an input and parses the data to return a MyDataFrame Object
		 */
		
		// to store columns of dataframe: states, genders, years, names, counts
		ArrayList<String> states = new ArrayList<String>();
		ArrayList<String> genders = new ArrayList<String>();
		ArrayList<Integer> years = new ArrayList<Integer>();
		ArrayList<String> names = new ArrayList<String>();
		ArrayList<Integer> counts = new ArrayList<Integer>();
		
		File file = new File(path);
		try(Scanner scanner = new Scanner(file)){
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine(); // read each line in the txt file
				// add the parsed data to its respective arraylist defined above
				states.add(line.split(",")[0]);
				genders.add(line.split(",")[1]);
				years.add(Integer.parseInt(line.split(",")[2]));
				names.add(line.split(",")[3]);
				counts.add(Integer.parseInt(line.split(",")[4]));
			}
		}
		// error handling in file input
		catch(IOException ex){
			ex.printStackTrace();
		}
		catch (InputMismatchException e) { // notify exception
			System.out.println("EXCEPTION! WRONG FORMAT");
			e.printStackTrace();
		}
		// return data frame object consisting of 5 arraylists, one for each column defined above
		MyDataFrame df = new MyDataFrame(states,genders,years,names,counts);
		return df;
	}
	
	public static void writeCSV(MyDataFrame data, String path) throws IOException {
		/*
		 * This method takes two inputs: a MyDataFrame object and a file path
		 * the method takes the object consisting of 5 arraylists and converts it into a file format to be written to the specified path
		 */
		FileWriter fw = null; // initialize filewriter to null
		BufferedWriter bw = null; // initialize bufferedwriter to null
		try {
			fw = new FileWriter(path); // save in the specified name and path
			bw = new BufferedWriter(fw);
			// get columns of data
			ArrayList<String> states = data.getState();
			ArrayList<String> genders = data.getGender();
			ArrayList<Integer> years = data.getYear();
			ArrayList<String> names = data.getName();
			ArrayList<Integer> counts = data.getCount();
			// skip header of the txt file
			//bw.write("state," + "gender," + "year," + "name," + "count" + "\n");
			
			for(int i=0; i<data.getLength(); i++) {
				// for each elements in the MyDataFrame object, combine into a comma separated file format and print a new line to signify
				// a new line of the file
			    bw.write(states.get(i).toString() + "," + genders.get(i).toString() + "," +
			    		 years.get(i).toString() + "," + names.get(i).toString() + "," +
			    		 counts.get(i).toString() + "\n"); // get information for one name
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
	
	public static MyDataFrame concat(MyDataFrame df1, MyDataFrame df2) {
		/*
		 * This method take two MyDataFrame objects as input and combined the, into one
		 */
		ArrayList<String> states = new ArrayList<String>();
		ArrayList<String> genders = new ArrayList<String>();
		ArrayList<Integer> years = new ArrayList<Integer>();
		ArrayList<String> names = new ArrayList<String>();
		ArrayList<Integer> counts = new ArrayList<Integer>();
		
		// add states info from two dataframes into one
		states.addAll(df1.getState());
		states.addAll(df2.getState());
		// add genders info from two dataframes into one
		genders.addAll(df1.getGender());
		genders.addAll(df2.getGender());
		// add years info from two dataframes into one
		years.addAll(df1.getYear());
		years.addAll(df2.getYear());
		// add names info from two dataframes into one
		names.addAll(df1.getName());
		names.addAll(df2.getName());
		// add counts info from two dataframes into one
		counts.addAll(df1.getCount());
		counts.addAll(df2.getCount());
		
		// return a new dataframe
		return new MyDataFrame(states, genders, years, names, counts);
	}
	 
}
