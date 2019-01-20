package java_project;

import java.util.*;
import java.util.stream.IntStream;

/**
 * This class defines methods to be performed on a MyDataFrame object that allow for data manipulation and aggregation.
 * 
 * Operations include
 * 1.  Head - get the first N rows of Data
 * 2.  Tail - get the last N rows of data
 * 3.  dType - get the data type of a column specified by either the column index or name
 * 4.  Slicing - Return a column(s) specified by an index (or range of indexes) or column name (or range of column names)
 * 5.  Filtering - Return specific rows of the data that meet a criteria based on an operation (equals, greater or less than, greater than or less than or equal to)
 * 6.  Indexing - returns rows starting from an index, or within a range of two indexes
 * 7.  Sorting - returns data sorted by either a specified column index or name
 * 8.  Aggregation - returns the minimum or maximum of a column specified by its index or column name
 * 
 * @author Tian Fu, Max Holiber
 */

public class MyDataFrame {
	// instance variables
    private ArrayList<String> state;
    private ArrayList<String> gender;
    private ArrayList<Integer> year;
    private ArrayList<String> name;
    private ArrayList<Integer> count;
	
    // constructor of the MyDataFrame class - 5 arraylists, one for each column in the data frame
	public MyDataFrame (ArrayList<String> state,ArrayList<String> gender,ArrayList<Integer> year,
			            ArrayList<String> name,ArrayList<Integer> count) {
		this.state = state;
		this.gender = gender;
		this.year = year;
		this.name = name;
		this.count = count;
	}
	
	// define methods to return a column of the data frame
	public ArrayList<String> getState(){
		return this.state;
	}
	
	public ArrayList<String> getGender(){
		return this.gender;
	}
	
	public ArrayList<Integer> getYear(){
		return this.year;
	}
	
	public ArrayList<String> getName(){
		return this.name;
	}
	
	public ArrayList<Integer> getCount(){
		return this.count;
	}
	
	// define method to get the length, ie number of rows, of the data frame
	public int getLength() {
		if (this.getState()!=null) {
			return this.getState().size();
		}
		else if (this.getGender()!=null) {
			return this.getGender().size();
		}
		else if (this.getYear()!=null) {
			return this.getYear().size();
		}
		else if (this.getName()!=null) {
			return this.getName().size();
		}
		else {
			return this.getCount().size();
		}
	}
	
	// method to print the data frame into a tabular format
	public void printDF() {
		System.out.println("--------------------------------------------------------------");
		// header of the dataframe
		System.out.print("|");
		if (this.getState()!=null) {
			System.out.print(" state |");
		}
		if (this.getGender()!=null) {
			System.out.print(" gender |");
		}
		if (this.getYear()!=null) {
			System.out.print("  year    |");
		}
		if (this.getName()!=null) {
			System.out.print("      name      |");
		}
		if (this.getCount()!=null) {
			System.out.print("      count     |");
		}
		
		//print out the records of the dataframe below the header
		System.out.print("\n");
		System.out.println("--------------------------------------------------------------");
		for (int i=0; i<this.getLength(); i++){
			// print out state, gender, year
			System.out.print("|");
			if (this.getState()!=null) {
				System.out.print("   ");
				System.out.print(this.getState().get(i).toString());
				System.out.print("  |");
			}
			
			if (this.getGender()!=null) {
				System.out.print("   ");
				System.out.print(this.getGender().get(i).toString());
				System.out.print("    |");
			}
			
			if (this.getYear()!=null) {
				System.out.print("  ");
				System.out.print(this.getYear().get(i).toString());
				System.out.print("    |");
			}
			
			if (this.getName()!=null) {
			    // create empty spaces to make sure the output look like a table
			    int empty = 16 - this.getName().get(i).toString().length();
			    if (empty%2 == 1) {
				    System.out.print(" ");
			    }
			    for (int j=0; j<empty/2; j++) {
				    System.out.print(" ");
			    }
			    System.out.print(this.getName().get(i).toString()); // print out name
			    for (int j=0; j<empty/2; j++) {
				    System.out.print(" ");
			    }
			    System.out.print("|");
			}
			
			if (this.getCount()!=null) {
			    // create empty spaces to make sure the output look like a table
			    int empty2 = 16 - this.getCount().get(i).toString().length();
			    if (empty2%2 == 1) {
				    System.out.print(" ");
			    }
			    for (int j=0; j<empty2/2; j++) {
				    System.out.print(" ");
			    }
			    System.out.print(this.getCount().get(i).toString()); // print out count
			    for (int j=0; j<empty2/2; j++) {
				    System.out.print(" ");
			    }
			    System.out.print("|");
			}
			System.out.print("\n");
			System.out.println("--------------------------------------------------------------");
		}	
	}
	
	
	public MyDataFrame head(int n) {
		/*
		 * this method takes an integer n as inputs and returns the first n rows of the data frame
		 */
		
		// when n is greater than the size of the dataframe, return original dataframe
		if(n>this.getLength()) {
			return this;
		}
		// to store columns of dataframe
		ArrayList<String> states = new ArrayList<String>();
		ArrayList<String> genders = new ArrayList<String>();
		ArrayList<Integer> years = new ArrayList<Integer>();
		ArrayList<String> names = new ArrayList<String>();
		ArrayList<Integer> counts = new ArrayList<Integer>();
		// get the top n elements for each list
		for(int i=0; i<n; i++) {
			
			// for each element of the 5 arraylists with index less than n, add the value to its corresponding arraylist based on the column
			if (this.getState()==null) {
				states = null;
			}
			else {
				states.add(this.getState().get(i));
			}
			if (this.getGender()==null) {
				genders = null;
			}
			else {
				genders.add(this.getGender().get(i));
			}
			if (this.getYear()==null) {
				years = null;
			}
			else {
				years.add(this.getYear().get(i));
			}
			if (this.getName()==null) {
				names = null;
			}
			else {
				names.add(this.getName().get(i));
			}
			if (this.getCount()==null) {
				counts = null;
			}
			else {
				counts.add(this.getCount().get(i));
			}
		}
		//return results in a MyDataFrame object
		return new MyDataFrame(states,genders,years,names,counts);
	}
	
	public MyDataFrame tail(int n) {
		/*
		 * this method takes an integer n as inputs and returns the last n rows of the data frame
		 */
		// when n is greater than the size of the dataframe, return original dataframe
		if(n>this.getLength()) {
			return this;
		}
		// to store columns of dataframe
		ArrayList<String> states = new ArrayList<String>();
		ArrayList<String> genders = new ArrayList<String>();
		ArrayList<Integer> years = new ArrayList<Integer>();
		ArrayList<String> names = new ArrayList<String>();
		ArrayList<Integer> counts = new ArrayList<Integer>();
		// get the end n elements for each list
		for(int i=(this.getLength()-n); i<this.getLength(); i++) {
			//for each element of the 5 arraylists with index less than the size of the data frame and greater than n,
			// add the value to its corresponding arraylist based on the column
			if (this.getState()==null) {
				states = null;
			}
			else {
				states.add(this.getState().get(i));
			}
			if (this.getGender()==null) {
				genders = null;
			}
			else {
				genders.add(this.getGender().get(i));
			}
			if (this.getYear()==null) {
				years = null;
			}
			else {
				years.add(this.getYear().get(i));
			}
			if (this.getName()==null) {
				names = null;
			}
			else {
				names.add(this.getName().get(i));
			}
			if (this.getCount()==null) {
				counts = null;
			}
			else {
				counts.add(this.getCount().get(i));
			}
		}
		//return the results in a new MyDataFrame object 
		return new MyDataFrame(states,genders,years,names,counts);		
	}
	
	public String dType(int index) {
		/*
		 * this method takes an int as the input and returns the data type of the column in the dataframe whose index corresponds to the input
		 */
		
		// when index out of range
		if (index<0 || index>4) {
			return "Invalid Index!";
		}
		
		/* 
		 * for each index value between 1 and 4:
		 *  - return no column when the corresponding arraylist is null
		 *  - perform check on the elements of the arraylist based on data type and return String if data type not uniform
		 *  - return the data type for the column specified by the int index
		 * 
		 */
        if (index==0) {
        	ArrayList<String> states = this.getState();
        	if (states==null) { // when this dataframe has no state column
        		return "No state column";
        	}
        	for (int i = 0; i < states.size(); i++) {
        		boolean check = states.get(i) instanceof String;
        		if (!check) {
        			return "String"; // when data type is not uniform
        		}
        	}
        	return "String"; // data type for state is string
        }
        else if (index==1) {
        	ArrayList<String> genders = this.getGender();
        	if (genders==null) { // when this dataframe has no gender column
        		return "No gender column";
        	}
        	for (int i = 0; i < genders.size(); i++) {
        		boolean check = genders.get(i) instanceof String;
        		if (!check) {
        			return "String"; // when data type is not uniform
        		}
        	}
			return "String"; // data type for gender is string
        }
        else if (index==2) {
        	ArrayList<Integer> years = this.getYear();
        	if (years==null) { // when this dataframe has no year column
        		return "No year column";
        	}
        	for (int i = 0; i < years.size(); i++) {
        		boolean check = years.get(i) instanceof Integer;
        		if (!check) {
        			return "String"; // when data type is not uniform
        		}
        	}
			return "Integer"; // data type for year is Integer
        }
        else if (index==3) {
        	ArrayList<String> names = this.getName();
        	if (names==null) { // when this dataframe has no name column
        		return "No name column";
        	}
        	for (int i = 0; i < names.size(); i++) {
        		boolean check = names.get(i) instanceof String;
        		if (!check) {
        			return "String"; // when data type is not uniform
        		}
        	}
			return "String"; // data type for name is string
        }
        else {
        	ArrayList<Integer> counts = this.getCount();
        	if (counts==null) { // when this dataframe has no count column
        		return "No count column";
        	}
        	for (int i = 0; i < counts.size(); i++) {
        		boolean check = counts.get(i) instanceof Integer;
        		if (!check) {
        			return "String"; // when data type is not uniform
        		}
        	}
			return "Integer"; // data type for count is Integer
        }	
	}
	
	//0 - state,1- gender,2 - year,3 - name,4 - count
	public String dType(String name) {
		/*
		 * this method takes an a String as  the input and returns the data type of the column in the dataframe whose name corresponds to the input
		 */
		
		
		// when name is not one of columns, return invalid column name
		if (!name.equalsIgnoreCase("state") && !name.equalsIgnoreCase("gender") &&
			!name.equalsIgnoreCase("year") && !name.equalsIgnoreCase("name") &&
			!name.equalsIgnoreCase("count")) {
			return "Invalid Column Name!";
		}
		
		/* 
		 * for each name as input:
		 *  - return no column when the corresponding arraylist is null
		 *  - perform check on the elements of the arraylist based on data type and return String if data type not uniform
		 *  - return the data type for the column specified by the name that is inputted
		 * 
		 */
		if (name.equalsIgnoreCase("state")) {
			ArrayList<String> states = this.getState();
			if (states==null) { // when this dataframe has no state column
        		return "No state column";
        	}
			for (int i = 0; i < states.size(); i++) {
        		boolean check = states.get(i) instanceof String;
        		if (!check) {
        			return "String"; // when data type is not uniform
        		}
        	}
			return "String"; // data type for state is string
		}
		else if (name.equalsIgnoreCase("gender")) {
			ArrayList<String> genders = this.getGender();
			if (genders==null) { // when this dataframe has no gender column
        		return "No gender column";
        	}
			for (int i = 0; i < genders.size(); i++) {
        		boolean check = genders.get(i) instanceof String;
        		if (!check) {
        			return "String"; // when data type is not uniform
        		}
        	}
			return "String"; // data type for gender is string
		}
		else if (name.equalsIgnoreCase("year")) {
			ArrayList<Integer> years = this.getYear();
			if (years==null) { // when this dataframe has no year column
        		return "No year column";
        	}
			for (int i = 0; i < years.size(); i++) {
        		boolean check = years.get(i) instanceof Integer;
        		if (!check) {
        			return "String"; // when data type is not uniform
        		}
        	}
			return "Integer"; // data type for year is Integer
		}
		else if (name.equalsIgnoreCase("name")) {
			ArrayList<String> names = this.getName();
			if (names==null) { // when this dataframe has no name column
        		return "No name column";
        	}
			for (int i = 0; i < names.size(); i++) {
        		boolean check = names.get(i) instanceof String;
        		if (!check) {
        			return "String"; // when data type is not uniform
        		}
        	}
			return "String"; // data type for name is string
		}
		else {
			ArrayList<Integer> counts = this.getCount();
			if (counts==null) { // when this dataframe has no count column
        		return "No count column";
        	}
			for (int i = 0; i < counts.size(); i++) {
        		boolean check = counts.get(i) instanceof Integer;
        		if (!check) {
        			return "String"; // when data type is not uniform
        		}
        	}
			return "Integer"; // data type for count is Integer
		}
	}
	
	// Returns the column specified by index.
	public MyDataFrame slice(int index) {
		/*
		 * this method takes an int as input and returns the column of the dataframe whose index corresponds to the int
		 */
		// when index out of range return the original dataframe
		if (index<0 || index>4) {
			return this;
		}
		
		/*
		 * for each value of index 1-4, return a MyDataFrame object with only the arraylist populated that corresponds to the index, otherwise NULL
		 */
		if (index==0) {
			ArrayList<String> states = this.getState();
			return new MyDataFrame(states,null,null,null,null);
		}
		else if (index==1) {
			ArrayList<String> genders = this.getGender();
			return new MyDataFrame(null,genders,null,null,null);
		}
		else if (index==2) {
			ArrayList<Integer> years = this.getYear();
			return new MyDataFrame(null,null,years,null,null);
		}
		else if (index==3) {
			ArrayList<String> names = this.getName();
			return new MyDataFrame(null,null,null,names,null);
		}
		else {
			ArrayList<Integer> counts = this.getCount();
			return new MyDataFrame(null,null,null,null,counts);
		}
	}
	//0 - state,1- gender,2 - year,3 - name,4 - count
	
	// Returns the column specified by name.
	public MyDataFrame slice(String name) {
		/*
		 * this method takes a string (column name) as input and returns a MyDataFrame object with only the column that corresponds to the string
		 */
		// when name is not one of columns return the original dataframe
		if (!name.equalsIgnoreCase("state") && !name.equalsIgnoreCase("gender") &&
			!name.equalsIgnoreCase("year") && !name.equalsIgnoreCase("name") &&
			!name.equalsIgnoreCase("count")) {
			return this;
		}
		
		/*
		 * for each value of input string, return a MyDataFrame object with only the arraylist populated that corresponds to the name, otherwise NULL
		 */
		if (name.equalsIgnoreCase("state")) {
			ArrayList<String> states = this.getState();
			return new MyDataFrame(states,null,null,null,null);
		}
		else if (name.equalsIgnoreCase("gender")) {
			ArrayList<String> genders = this.getGender();
			return new MyDataFrame(null,genders,null,null,null);
		}
		else if (name.equalsIgnoreCase("year")) {
			ArrayList<Integer> years = this.getYear();
			return new MyDataFrame(null,null,years,null,null);
		}
		else if (name.equalsIgnoreCase("name")) {
			ArrayList<String> names = this.getName();
			return new MyDataFrame(null,null,null,names,null);
		}
		else {
			ArrayList<Integer> counts = this.getCount();
			return new MyDataFrame(null,null,null,null,counts);
		}
	}
	
	// Returns the columns specified by an index array.
	public MyDataFrame slice(int[] indexArr) {
		/*
		 * this methods takes an integer array as input and returns a MyDataFrame object with only the columns whose index is in the range of the specified array
		 */
	    
		// when one of indices out of range return the original data frame
		for (int index: indexArr){
		    if (index<0 || index>4) {
			    return this;
		    }
		}
		// to store columns of dataframe
		ArrayList<String> states = null;
		ArrayList<String> genders = null;
		ArrayList<Integer> years = null;
		ArrayList<String> names = null;
		ArrayList<Integer> counts = null;
		
		
		for (int index: indexArr) {
			/*
			 * for each index that's contained in the specified index array, return its corresponding column from the dataframe
			 */
			if (index==0) {
				states = this.getState();
			}
			else if (index==1) {
				genders = this.getGender();
			}
			else if (index==2) {
				years = this.getYear();
			}
			else if (index==3) {
				names = this.getName();
			}
			else {
				counts = this.getCount();
			}
		}
		
		// return results in MyDataFrame object
		return new MyDataFrame(states,genders,years,names,counts);
	}
	
	
    // Returns the columns specified by a name array.
	public MyDataFrame slice(String[] nameArr) {
		/*
		 * this method takes a String array as input and returns the columns of the data frame that fall within this array
		 */
		
	    // when one of column names is not one of columns return the original dataframe
		for (String name: nameArr){
		    if (!name.equalsIgnoreCase("state") && !name.equalsIgnoreCase("gender") &&
			    !name.equalsIgnoreCase("year") && !name.equalsIgnoreCase("name") &&
			    !name.equalsIgnoreCase("count")) {
			    return this;
		    }
		}
		// to store columns of dataframe
		ArrayList<String> states = null;
		ArrayList<String> genders = null;
		ArrayList<Integer> years = null;
		ArrayList<String> names = null;
		ArrayList<Integer> counts = null;
		
		for (String name: nameArr) {
			/*
			 * for each column name in the specified array, return the column from the data frame corresponding to the name
			 */
			if (name.equalsIgnoreCase("state")) {
				states = this.getState();
			}
			else if (name.equalsIgnoreCase("gender")) {
				genders = this.getGender();
			}
			else if (name.equalsIgnoreCase("year")) {
				years = this.getYear();
			}
			else if (name.equalsIgnoreCase("name")) {
				names = this.getName();
			}
			else {
				counts = this.getCount();
			}
		}
		// return results in new mydataframe object
		return new MyDataFrame(states,genders,years,names,counts);
	}
	
	// get the column specified by input string
	public ArrayList<String> filterStringHelper(String col){
		
		/*
		 * this is a helper function to be used in the Filtering method that will return the column of the dataframe specified by the input string
		 * for string type columns
		 */
		if (col.equalsIgnoreCase("state")) {
			return this.getState();
		}
		else if (col.equalsIgnoreCase("gender")) {
			return this.getGender();
		}
		
		else{
			return this.getName();
		}
	}
	// get the column specified by input string
	public ArrayList<Integer> filterIntegerHelper(String col){
		/*
		 * this is a helper function to be used in the Filtering method that will return the column of the dataframe specified by the input string
		 * for integer type columns
		 */
		if (col.equalsIgnoreCase("year")) {
			return this.getYear();
		}
		else {
			return this.getCount();
		}
	}

	
	// returns filtered data, object can be String or Integer
	public MyDataFrame filter(String col, String op, Object o) {
		/*
		 * this method takes a column name, operator (==, >, <, >=, <=), and a mydataframe as input and filters rows of the object based on the criteria
		 * specified by the operatior on the inputted column name
		 */
		// to store columns of dataframe
		ArrayList<String> states = new ArrayList<String>();
		ArrayList<String> genders = new ArrayList<String>();
		ArrayList<Integer> years = new ArrayList<Integer>();
		ArrayList<String> names = new ArrayList<String>();
		ArrayList<Integer> counts = new ArrayList<Integer>();
		
		int length = this.getLength(); // get length of this dataframe
		
		// filter records to the equals operator
		if(op.equals("=")) {
			// integer comparison
			if (col.equalsIgnoreCase("year") || col.equalsIgnoreCase("count")) {
				for(int i=0; i<length; i++) {
					// loop through specified column and compare to the object
					// if equals, then add all values from the 5 array lists that match the matching index
					if(this.filterIntegerHelper(col).get(i).equals(o)) {
						states.add(this.getState().get(i));
						genders.add(this.getGender().get(i));
						years.add(this.getYear().get(i));
						names.add(this.getName().get(i));
						counts.add(this.getCount().get(i));
					}
				}
			}
			// string comparison
			else {
				for(int i=0; i<length; i++) {
					// loop through specified column and compare to the object
					// if equals, then add all values from the 5 array lists that match the matching index
					if(this.filterStringHelper(col).get(i).equals(o)) {
						states.add(this.getState().get(i));
						genders.add(this.getGender().get(i));
						years.add(this.getYear().get(i));
						names.add(this.getName().get(i));
						counts.add(this.getCount().get(i));
					}
				}
			}
		}
		else if(op.equals(">")) {
			// integer comparison
			if (col.equalsIgnoreCase("year") || col.equalsIgnoreCase("count")) {
				for(int i=0; i<length; i++) {
					// loop through specified column and compare to the object
					// if greater than, then add all values from the 5 array lists that match the matching index
					// int value has to be greater than input int
					if(this.filterIntegerHelper(col).get(i)> (int)o) {
						states.add(this.getState().get(i));
						genders.add(this.getGender().get(i));
						years.add(this.getYear().get(i));
						names.add(this.getName().get(i));
						counts.add(this.getCount().get(i));
					}
				}
			}
			// string comparison
			else {
				for(int i=0; i<length; i++) {
					// loop through specified column and compare to the object
					// if greater than, then add all values from the 5 array lists that match the matching index
					// string ascii value has to be greater than input string
					if(this.filterStringHelper(col).get(i).compareTo(o.toString())>0) {
						states.add(this.getState().get(i));
						genders.add(this.getGender().get(i));
						years.add(this.getYear().get(i));
						names.add(this.getName().get(i));
						counts.add(this.getCount().get(i));
					}
				}
			}			
		}
        else if(op.equals(">=")) {
        	// integer comparison
        	if (col.equalsIgnoreCase("year") || col.equalsIgnoreCase("count")) {
        		for(int i=0; i<length; i++) {
        			// loop through specified column and compare to the object
					// if greater than or equal to, then add all values from the 5 array lists that match the matching index
        		    // int value has to be greater than or equal to input int
        			if(this.filterIntegerHelper(col).get(i)>= (int)o) {
        				states.add(this.getState().get(i));
        				genders.add(this.getGender().get(i));
        				years.add(this.getYear().get(i));
        				names.add(this.getName().get(i));
        				counts.add(this.getCount().get(i));
        			}
        		}
        	}
        	// string comparison
        	else {
        		for(int i=0; i<length; i++) {
        			// loop through specified column and compare to the object
					// if greater than or equal to, then add all values from the 5 array lists that match the matching index
        			// string ascii value has to be greater than or equal to input string
        			if(this.filterStringHelper(col).get(i).compareTo(o.toString())>=0) {
        				states.add(this.getState().get(i));
        				genders.add(this.getGender().get(i));
        				years.add(this.getYear().get(i));
        				names.add(this.getName().get(i));
        				counts.add(this.getCount().get(i));
        			}
        		}
        	}
		}
        else if(op.equals("<")) {
        	// integer comparison
        	if (col.equalsIgnoreCase("year") || col.equalsIgnoreCase("count")) {
        		for(int i=0; i<length; i++) {
        			// loop through specified column and compare to the object
					// if less than, then add all values from the 5 array lists that match the matching index
        			// int value has to be smaller than input int
        			if(this.filterIntegerHelper(col).get(i) < (int)o) {
        				states.add(this.getState().get(i));
        				genders.add(this.getGender().get(i));
        				years.add(this.getYear().get(i));
        				names.add(this.getName().get(i));
        				counts.add(this.getCount().get(i));
        			}
        		}
        	}
        	// string comparison
        	else {
        		for(int i=0; i<length; i++) {
        			// loop through specified column and compare to the object
					// if less than, then add all values from the 5 array lists that match the matching index
        			// string ascii value has to be smaller than input string
        			if(this.filterStringHelper(col).get(i).compareTo(o.toString())<0) {
        				states.add(this.getState().get(i));
        				genders.add(this.getGender().get(i));
        				years.add(this.getYear().get(i));
        				names.add(this.getName().get(i));
        				counts.add(this.getCount().get(i));
        			}
        		}
        	}
		}
        else if(op.equals("<=")) {
        	// integer comparison
        	if (col.equalsIgnoreCase("year") || col.equalsIgnoreCase("count")) {
        		for(int i=0; i<length; i++) {
        			// loop through specified column and compare to the object
					// if less than or equal to, then add all values from the 5 array lists that match the matching index
        			// int value has to be smaller than or equal to input int
        			if(this.filterIntegerHelper(col).get(i) <= (int)o) {
        				states.add(this.getState().get(i));
        				genders.add(this.getGender().get(i));
        				years.add(this.getYear().get(i));
        				names.add(this.getName().get(i));
        				counts.add(this.getCount().get(i));
        			}
        		}
        	}
        	// string comparison
        	else {
        		for(int i=0; i<length; i++) {
        			// string ascii value has to be smaller than or equal to input string
        			// loop through specified column and compare to the object
					// if less than or equal to, then add all values from the 5 array lists that match the matching index
        			if(this.filterStringHelper(col).get(i).compareTo(o.toString()) <= 0) {
        				states.add(this.getState().get(i));
        				genders.add(this.getGender().get(i));
        				years.add(this.getYear().get(i));
        				names.add(this.getName().get(i));
        				counts.add(this.getCount().get(i));
        			}
        		}
        	}
		}
		return new MyDataFrame(states,genders,years,names,counts);
	}
	
	public MyDataFrame loc(int index) {
		/*
		 * this method takes an int as input and returns all records of the data frame starting at that index
		 */
		// to store columns of dataframe
		ArrayList<String> states = new ArrayList<String>();
		ArrayList<String> genders = new ArrayList<String>();
		ArrayList<Integer> years = new ArrayList<Integer>();
		ArrayList<String> names = new ArrayList<String>();
		ArrayList<Integer> counts = new ArrayList<Integer>();
		int length = this.getLength(); // get length of the dataframe
		
		// if the index is out of range, return the original dataframe
		if (index<0 || index>=length) {
        	return this;
        }
		
		//loop through each column beginning at the specified index until the size of the data frame, and append the value to the corresponding array list
		for (int i = index; i < length; i++) {
			if (this.getState()==null) {
				states = null;
			}
			else {
				states.add(this.getState().get(i));
			}
			if (this.getGender()==null) {
				genders = null;
			}
			else {
				genders.add(this.getGender().get(i));
			}
			if (this.getYear()==null) {
				years = null;
			}
			else {
				years.add(this.getYear().get(i));
			}
			if (this.getName()==null) {
				names = null;
			}
			else {
				names.add(this.getName().get(i));
			}
			if (this.getCount()==null) {
				counts = null;
			}
			else {
				counts.add(this.getCount().get(i));
			}
		}
		// return results into new MyDataFrame object
		return new MyDataFrame(states,genders,years,names,counts);
	}
	
	//Returns the rows between from and to (including from and to).
	public MyDataFrame loc(int from, int to) {
		/*
		 * this method takes a starting and ending value corresponding the rows for which the mydataframe object will be returns
		 */
		// to store columns of dataframe
		ArrayList<String> states = new ArrayList<String>();
		ArrayList<String> genders = new ArrayList<String>();
		ArrayList<Integer> years = new ArrayList<Integer>();
		ArrayList<String> names = new ArrayList<String>();
		ArrayList<Integer> counts = new ArrayList<Integer>();
		
        int length = this.getLength(); // get length of the dataframe
        
        // if the index is out of range, return the original dataframe
        if (from<0 || to>=length) {
        	return this;
        }
		
        // loop through each column for indexes between the from and to input and apend the records to the corresponding arraylist
		for (int i = from; i < (to+1); i++) {
			if (this.getState()==null) {
				states = null;
			}
			else {
				states.add(this.getState().get(i));
			}
			if (this.getGender()==null) {
				genders = null;
			}
			else {
				genders.add(this.getGender().get(i));
			}
			if (this.getYear()==null) {
				years = null;
			}
			else {
				years.add(this.getYear().get(i));
			}
			if (this.getName()==null) {
				names = null;
			}
			else {
				names.add(this.getName().get(i));
			}
			if (this.getCount()==null) {
				counts = null;
			}
			else {
				counts.add(this.getCount().get(i));
			}
		}
		//return results into new MyDataFrame object
		return new MyDataFrame(states,genders,years,names,counts);
	}
	
	
	public static int[] sortStringHelper(ArrayList<String> original, ArrayList<String> sorted) {
		/*
		 * this method takes two arraylists as input: one in its original form and one that is sorted
		 * it is later uses in the sort function to return a MyDataFrame object that returns the data frame sorted by a specified column of type string
		 * it populates an array with indices that have been matched between the sorted and not sorted lists
		 * and then takes the matching index and adds it the final list "index" that represents the index after sorting of the element 
		 * in the original list at its original index
		 */
		int length = original.size(); // get length of dataframe
		int[] index = new int[length];
		ArrayList<Integer> check = new ArrayList<Integer>(); // to store a list of retrieved indices
		for (int i=0; i<length; i++) {
			for (int j=0; j<length; j++) {
				if (!check.contains(j) && sorted.get(i).equals(original.get(j))) {
					check.add(j);
					index[i] = j; // record the location of the value of sorted in original list
					break;
				}
			}
		}
		return index; // rearranged list of index based on sorted values
	}
	
	public static int[] sortIntegerHelper(ArrayList<Integer> original, ArrayList<Integer> sorted) {
		/*
		 * this method takes two arraylists as input: one in its original form and one that is sorted
		 * it is later uses in the sort function to return a MyDataFrame object that returns the data frame sorted by a specified column of type Integer
		 * it populates an array with indices that have been matched between the sorted and not sorted lists
		 * and then takes the matching index and adds it the final list "index" that represents the index after sorting of the element 
		 * in the original list at its original index
		 */
		int length = original.size(); // get length of dataframe
		int[] index = new int[length];
		ArrayList<Integer> check = new ArrayList<Integer>(); // to store a list of retrieved indices
		for (int i=0; i<length; i++) {
			for (int j=0; j<length; j++) {
				if (!check.contains(j) && sorted.get(i).equals(original.get(j))) {
					check.add(j);
					index[i] = j; // record the location of the value of sorted in original list
					break;
				}
			}
		}
		return index; // rearranged list of index based on sorted values
	}
	
	
	// Returns the data sorted ascending by the column specified by index.
	public MyDataFrame sort(int index) {
		/*
		 * this method takes an integer as input and returns a MyDataFrame object that is sorted according to the column whose index matches the input integer
		 */
		int length = this.getLength(); // get length of the dataframe
		// if the index is out of range, return the original dataframe
        if (index<0 || index>=length) {
        	return this;
        }
        
        int[] array; // array to store sorted column based on indices
        /*
         * for each input index possible value, call the helper function to return an array containing the sorted indices of the specified column
         */
        if (index==0) {
        	ArrayList<String> states = this.getState();
			ArrayList<String> sortedstates = this.getState();
			Collections.sort(sortedstates);
			array = sortStringHelper(states, sortedstates);
		}
		else if (index==1) {
			ArrayList<String> genders = this.getGender();
			ArrayList<String> sortedgenders = this.getGender();
			Collections.sort(sortedgenders);
			array = sortStringHelper(genders, sortedgenders);
		}
		else if (index==2) {
			ArrayList<Integer> years = this.getYear();
			ArrayList<Integer> sortedyears = this.getYear();
			Collections.sort(sortedyears);
			array = sortIntegerHelper(years, sortedyears);
		}
		else if (index==3) {
			ArrayList<String> names = this.getName();
			ArrayList<String> sortednames = this.getName();
			Collections.sort(sortednames);
			array = sortStringHelper(names, sortednames);
		}
		else {
			ArrayList<Integer> counts = this.getCount();
			ArrayList<Integer> sortedcounts = this.getCount();
			Collections.sort(sortedcounts);
			array = sortIntegerHelper(counts, sortedcounts);
		}
        // to store columns of dataframe
     	ArrayList<String> states = new ArrayList<String>();
     	ArrayList<String> genders = new ArrayList<String>();
     	ArrayList<Integer> years = new ArrayList<Integer>();
     	ArrayList<String> names = new ArrayList<String>();
     	ArrayList<Integer> counts = new ArrayList<Integer>();
     	
     	// for each index in the array of sorted indices, append the value from each column to the 5 arraylists at that corresponding index
     	for(int ind: array) {
     		states.add(this.getState().get(ind));
     		genders.add(this.getGender().get(ind));
     		years.add(this.getYear().get(ind));
     		names.add(this.getName().get(ind));
     		counts.add(this.getCount().get(ind));
     	}
     	// final sorted MyDataFrame object
     	return new MyDataFrame(states,genders,years,names,counts);
	}
	
	// Returns the data sorted by the column specified by name.
	public MyDataFrame sort(String name) {
		/*
		 * this method takes a String as input and returns a MyDataFrame object that is sorted according to the column whose name matches the input String
		 */
		
		// when one of column names is not one of columns return the original dataframe
		if (!name.equalsIgnoreCase("state") && !name.equalsIgnoreCase("gender") &&
			!name.equalsIgnoreCase("year") && !name.equalsIgnoreCase("name") &&
			!name.equalsIgnoreCase("count")) {
			return this;
		}
		
		int[] array; // array to store sorted column based on indices
		/*
         * for each input String possible value, call the helper function to return an array containing the sorted indices of the specified column
         */
        if (name.equalsIgnoreCase("state")) {
        	ArrayList<String> states = this.getState();
			ArrayList<String> sortedstates = this.getState();
			Collections.sort(sortedstates);
			array = sortStringHelper(states, sortedstates);
		}
		else if (name.equalsIgnoreCase("gender")) {
			ArrayList<String> genders = this.getGender();
			ArrayList<String> sortedgenders = this.getGender();
			Collections.sort(sortedgenders);
			array = sortStringHelper(genders, sortedgenders);
		}
		else if (name.equalsIgnoreCase("year")) {
			ArrayList<Integer> years = this.getYear();
			ArrayList<Integer> sortedyears = this.getYear();
			Collections.sort(sortedyears);
			array = sortIntegerHelper(years, sortedyears);
		}
		else if (name.equalsIgnoreCase("name")) {
			ArrayList<String> names = this.getName();
			ArrayList<String> sortednames = this.getName();
			Collections.sort(sortednames);
			array = sortStringHelper(names, sortednames);
		}
		else {
			ArrayList<Integer> counts = this.getCount();
			ArrayList<Integer> sortedcounts = this.getCount();
			Collections.sort(sortedcounts);
			array = sortIntegerHelper(counts, sortedcounts);
		}
        // to store columns of dataframe
     	ArrayList<String> states = new ArrayList<String>();
     	ArrayList<String> genders = new ArrayList<String>();
     	ArrayList<Integer> years = new ArrayList<Integer>();
     	ArrayList<String> names = new ArrayList<String>();
     	ArrayList<Integer> counts = new ArrayList<Integer>();
     	
     	// for each index in the array of sorted indices, append the value from each column to the 5 arraylists at that corresponding index
     	for(int ind: array) {
     		states.add(this.getState().get(ind));
     		genders.add(this.getGender().get(ind));
     		years.add(this.getYear().get(ind));
     		names.add(this.getName().get(ind));
     		counts.add(this.getCount().get(ind));
     	}
     	//return final sorted MyDataFrame object according to the input column name
     	return new MyDataFrame(states,genders,years,names,counts);
	}
	
	
	// Returns the minimum element of the column specified by index.
	public Object getMin(int index) {
		/*
		 * this method takes an int as input and returns the minimum value of the column whose index corresponds to the int
		 */
		int length = this.getLength(); // get length of the dataframe
		// if the index is out of range, return the original dataframe
        if (index<0 || index>=length) {
        	return this;
        }
		
        // checks if input is one of values from 1 to 4, and called the Collections.min method from java on the corresponding column
		if (index==0) {
			return Collections.min(this.getState());
		}
	    else if (index==1) {
			return Collections.min(this.getGender());
		}
		else if (index==2) {
			return Collections.min(this.getYear());
		}
		else if (index==3) {
			return Collections.min(this.getName());
		}
		else {
			return Collections.min(this.getCount());
		}
	}
	
	// Returns the minimum element of the column specified by label.
	public Object getMin(String label) {
		/*
		 * this method takes a string as input and returns the minimum value of the column whose name matches the input string
		 */
		// when one of column names is not one of columns return the original dataframe
		if (!label.equalsIgnoreCase("state") && !label.equalsIgnoreCase("gender") &&
			!label.equalsIgnoreCase("year") && !label.equalsIgnoreCase("name") &&
			!label.equalsIgnoreCase("count")) {
			return "WRONG LABEL";
		}
				
        // checks the input string, and calls the Collections.min method from java on the corresponding column
		if (label.equalsIgnoreCase("state")) {
			return Collections.min(this.getState());
		}
	    else if (label.equalsIgnoreCase("gender")) {
	    	return Collections.min(this.getGender());
		}
		else if (label.equalsIgnoreCase("year")) {
			return Collections.min(this.getYear());
		}
		else if (label.equalsIgnoreCase("name")) {
			return Collections.min(this.getName());
		}
		else {
			return Collections.min(this.getCount());
		}		
	}
	
	// Returns the maximum element of the column specified by index.
	public Object getMax(int index) {
		/*
		 * this method takes an int as input and returns the maximum value of the columns whose index corresponds to the input
		 */
		int length = this.getLength(); // get length of the dataframe
		// if the index is out of range, return the original dataframe
        if (index<0 || index>=length) {
        	return this;
        }
		
        // checks if input is one of values from 1 to 4, and called the Collections.max method from java on the corresponding column
		if (index==0) {
			return Collections.max(this.getState());
		}
	    else if (index==1) {
			return Collections.max(this.getGender());
		}
		else if (index==2) {
			return Collections.max(this.getYear());
		}
		else if (index==3) {
			return Collections.max(this.getName());
		}
		else {
			return Collections.max(this.getCount());
		}
	}
	
	// Returns the maximum element of the column specified by label.
	public Object getMax(String label) {
		/*
		 * this method takes a string as input and returns the column of the data frame whose column name matches the input string
		 */
		// when one of column names is not one of columns return the original dataframe
		if (!label.equalsIgnoreCase("state") && !label.equalsIgnoreCase("gender") &&
			!label.equalsIgnoreCase("year") && !label.equalsIgnoreCase("name") &&
			!label.equalsIgnoreCase("count")) {
			return "WRONG LABEL";
		}
        
		// checks input string,  and calls the Collections.max method from java on the corresponding column		
		if (label.equalsIgnoreCase("state")) {
			return Collections.max(this.getState());
		}
	    else if (label.equalsIgnoreCase("gender")) {
			return Collections.max(this.getGender());
		}
		else if (label.equalsIgnoreCase("year")) {
			return Collections.max(this.getYear());
		}
		else if (label.equalsIgnoreCase("name")) {
			return Collections.max(this.getName());
		}
		else {
			return Collections.max(this.getCount());
		}
	}
    
}
