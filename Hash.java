package java_hw6;

import java.util.*;
import java.io.*;
import java.lang.Math;

/**
 * This class outputs three txt files based on different hashing methodologies that
 * rearrange names in a file using hashing
 * Hash functions used: ascii, hashCode, prime numbers
 * @author tianfu
 */
public class Hash {
	
	/**
	 * This function creates a list of hash values for a list of strings based on
	 * sum of ascii values of character in each string
	 * @param list an arraylist of strings
	 * @param size length of the string list
	 * @return an arraylist of hash int values
	 */
	public static ArrayList<Integer> hash_ascii(ArrayList<String> list, int size) {
		// create a new arraylist of integers to store hash keys
		ArrayList<Integer> hashed = new ArrayList<Integer>();
		for(String s: list) {
			char[] ch = s.toCharArray(); // get a list of characters for this string
			int sum = 0; // initialize to store sum of ascii values
			for(char c: ch) {
				sum = sum + (int) c; // sum up ascii values of each character in the string
			}
			hashed.add(sum%size); // add to the list of hash keys
		}
		return hashed;
	}

	/**
	 * This function creates a list of hash values for a list of strings based on
	 * result of hashCode from JVM
	 * @param list an arraylist of strings
	 * @param size length of the string list
	 * @return an arraylist of hash int values
	 */
	public static ArrayList<Integer> hash_fun(ArrayList<String> list, int size) {
		// create a new arraylist of integers to store hash keys
		ArrayList<Integer> hashed = new ArrayList<Integer>();	
		for(String s: list) {
			// hash keys based on hashCode function and add to the list of hash keys
			hashed.add(Math.abs(s.hashCode()%size));
		}
		return hashed;
	}
	
	// generate a list of prime numbers among n numbers
	public static List<Integer> primeNumbers(int n) {
	    List<Integer> primes = new LinkedList<>(); // to store prime numbers
	   
	    if (n >= 2) { // 2 is the only even prime number
	        primes.add(2);
	    }
	    // check all odd numbers within n
	    for (int i = 3; i <= n; i += 2) {
	        if (isPrime(i)) {
	            primes.add(i);
	        }
	    }
	    return primes;
	}
	
	// generate a list of nonprime numbers among n numbers
	public static List<Integer> nonprimeNumbers(int n) {
		List<Integer> nonprimes = new LinkedList<>(); // to store nonprime numbers
		if (n >= 1) { // 1 is not prime number
	        nonprimes.add(1);
	    }
		if (n >= 2) {
		    // check all odd numbers within n
	        for (int i = 4; i <= n; i += 2) {
	            nonprimes.add(i);
	        }
		}
	    // check all odd numbers within n
	    for (int i = 3; i <= n; i += 2) {
	        if (!isPrime(i)) {
	            nonprimes.add(i);
	        }
	    }
		return nonprimes;
	}
	
	// checks if a number is a prime number
	private static boolean isPrime(int number) {
	    for (int i = 2; i*i < number; i++) {
	        if (number % i == 0) {
	            return false;
	        }
	    }
	    return true;
	}
	
	/**
	 * use prime numbers as hash keys
	 * @param list list an arraylist of strings
	 * @param size length of the string list
	 * @return an arraylist of hash int values
	 */
	public static ArrayList<Integer> hash_new(ArrayList<String> list, int size) {
		// create a new arraylist of integers to store hashed values
		ArrayList<Integer> hashed = new ArrayList<Integer>();
		List<Integer> primes = primeNumbers(list.size()); // list of primes within size
		List<Integer> nonprimes = nonprimeNumbers(list.size()); // list of nonprimes within size

		for (int i = 0; i<primes.size(); i++) {
			hashed.add(primes.get(i)%size); // hash keys based on prime numbers
		}
		for (int i = 0; i<nonprimes.size(); i++) {
			hashed.add(nonprimes.get(i)%size); // hash keys based on prime numbers
		}
		return hashed; // return hashed keys
	}
	
	/**
	 * ask the user to choose size of arrays, either 100 or 200
	 * @return the choice of user input, either 100 or 200
	 */
	public static int chooseSize() {
		Scanner scan = new Scanner(System.in); // create a new scanner
		
		int choice = 0; // initialize user choice
		while (true) {
			try {
				// print menu choices
				System.out.println("Welcome! Please choose size of the array--- 100 or 200:");
				System.out.print("Your choice:");
				choice = scan.nextInt();
				// only size of 100 or 200 are valid
				if (choice==100 || choice==200) {
					break; // break the loop until the input is a valid integer choice
				}
				else {
		    	    System.out.println("Please enter a size that is 100 OR 200!!");
		        }
			}
			// if the next token does not match the Integer regular expression
			// an exception will be thrown
			catch (InputMismatchException e) {
				System.out.println("Please enter a VALID size!!");
				scan.nextLine(); // skip the remaining invalid input
			}
		}
		return choice;
	}
	
	/**
	 * create a hashmap based on keys and values corresponding to the keys and
	 * output a string of values arranged based on hash key
	 * @param list values corresponding to the keys
	 * @param hashed keys for each value
	 * @param size size of the output list
	 * @return a string of values arranged based on hash key
	 */
	public static String[] hash_map(ArrayList<String> list, ArrayList<Integer> hashed, int size) {
		HashMap<Integer, ArrayList<String>> hashmap = new HashMap<Integer, ArrayList<String>>();
		
		String[] values = new String[size];
		Arrays.fill(values, ""); // make values to be an array of empty strings
		
		for (int i=0; i<list.size(); i++) {
			// if the key hasn't been used yet,
		    // create a new ArrayList<String> object
			if(!hashmap.containsKey(hashed.get(i))) {
				ArrayList<String> strList = new ArrayList<String>();
				strList.add(list.get(i)); //add the value for the key
				hashmap.put(hashed.get(i), strList);
			}
			else{
				// if the key has already been used,
			    // take the array list and append the value to it
				ArrayList<String> origList = hashmap.get(hashed.get(i));
			    origList.add(list.get(i));
			}
		}
		
		for(int keys: hashmap.keySet()) {
			// list of corresponding values for this key
			ArrayList<String> corr_values = hashmap.get(keys);
			String str = "";
			for (int i=0; i<corr_values.size(); i++) {
				str = str + corr_values.get(i);
				str = str + ", "; // let each value separated by comma
			}
			values[keys] = str; // add the comma separated string to the output
		}
		return values;
	}
	
	/**
	 * writes keys and corresponding values to a txt file
	 * @param value output array with values arranged based on hash keys
	 * @param size size of output array
	 * @param filepath path to save file
	 * @throws IOException
	 */
	public static void export(String[] value, int size, String filepath) throws IOException{
		int empty = 0; // count number of keys with no value
		int firsthalf = 0; // count number of values assigned to first half of keys
		int secondhalf = 0; // count number of values assigned to second half of keys
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter(filepath); // save in the specified name and path
			bw = new BufferedWriter(fw);
		    for (int i = 0; i < value.length; i++) {
			    if (value[i].length()==0) { // no value placed for a particular key
				    bw.write(i + " EMPTY LINE...");
				    bw.write("\n"); // start a new line
				    bw.write("\n"); // additional blank line to separate
				    empty += 1;
			    }
			    else {
				    bw.write(i + " " + value[i]);
				    bw.write("\n"); // start a new line
				    bw.write("\n"); // additional blank line to separate
				    String[] count= value[i].split(","); // to count how many values are placed for this key
				    if (i<size/2) {
					    firsthalf += count.length; // count number of values assigned to this key
				    }
				    else {
					    secondhalf += count.length; // count number of values assigned to this key
				    }
			    }		  
		    }
		    // use this number to access how the hashmap is fully filled
		    float percentEmpty = (float) empty/size;
		    bw.write("percent of empty keys: " + percentEmpty + "\n");
		    bw.write("number of values filled in first half is " + firsthalf + ", ");
		    bw.write("number of values filled in second half is " + secondhalf + "\n");
		    // use this number to access how the hashmap is balanced
		    bw.write("difference in number of values between two halves is " + Math.abs(firsthalf-secondhalf));
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
	
	/**
	 * program execution
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		
		int size = chooseSize(); // let the user choose a size
		// txt file with rows of names
		String path = "/Users/tianfu/Desktop/MSiA422Java/Java_HW6/input.txt";
		File file = new File(path);
		ArrayList<String> names = new ArrayList<String>();
		
		try (Scanner scanner = new Scanner(file)) {
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine(); // read each line in the txt file					
				names.add(line); // add to the list of names info as string
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}

		// paths to save hashing outputs
		String path1 = "/Users/tianfu/Desktop/MSiA422Java/Java_HW6/output1.txt";
		String path2 = "/Users/tianfu/Desktop/MSiA422Java/Java_HW6/output2.txt";
		String path3 = "/Users/tianfu/Desktop/MSiA422Java/Java_HW6/output3.txt";

		// hashing outputs
		String[] output1 = hash_map(names, hash_ascii(names, size), size);
		String[] output2 = hash_map(names, hash_fun(names, size), size);
		String[] output3 = hash_map(names, hash_new(names, size), size);
	
		// export three txt files
		export(output1, size, path1); // keys and values when using ascii hashing
		export(output2, size, path2); // keys and values when using hashCode hashing
		export(output3, size, path3); // keys and values when using new hash function
		
	}

}
