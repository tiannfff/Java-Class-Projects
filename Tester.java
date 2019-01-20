package java_project;

import java.io.*;
import java.util.*;

/**
 * This Tester class is used as running test classes for MyDataFrame and MyPandas
 * @author Tian Fu, Max Holiber
 */
public class Tester {
	
	public static void main(String[] args) throws Exception{
		
		// test readCSV and concat
		String path1 = "/Users/tianfu/Desktop/MSiA422Java/project2/namesbystate/ID.TXT";
        String path2 = "/Users/tianfu/Desktop/MSiA422Java/project2/namesbystate/WY.TXT";
        MyDataFrame df1 = MyPandas.readCSV(path1); // dataframe for ID
        MyDataFrame df2 = MyPandas.readCSV(path2); // dataframe for WY
        
        
        // test head
        MyDataFrame df3 = df1.head(300);
        System.out.println("TEST: Head 300 from ID");
        //df3.printDF();
        
        // test tail
        MyDataFrame df4 = df2.tail(300);
        System.out.println("TEST: Tail 300 from WY");
        //df4.printDF();
        
        // test concat and writeCSV
        MyDataFrame df = MyPandas.concat(df3,df4);
        MyPandas.writeCSV(df,"/Users/tianfu/Desktop/MSiA422Java/project2/aggregate.txt");
        
        // test dType
        String type1 = df.dType("State");
        System.out.println("TEST: Dtype (String name)");
        System.out.println(type1);
        
        String type2 = df.dType(3);
        System.out.println("TEST: Dtype (int index)");
        System.out.println(type2);
        
        String type3 = df.dType("territory"); // invalid column name
        System.out.println("TEST: Dtype (String name) - Invalid Column Name");
        System.out.println(type3);
        
        // test slice
        MyDataFrame dfSlice1 = df.slice(2);
        System.out.println("TEST: Slicing (int index)");
        dfSlice1.printDF();
        
        MyDataFrame dfSlice2 = df.slice("Count");
        System.out.println("TEST: Slicing (String name)");
        dfSlice2.printDF();
        
        int[] arr = {0,3,4};
        MyDataFrame dfSlice3 = df.slice(arr);
        System.out.println("TEST: Slicing (int[] indexArr)");
        dfSlice3.head(20).printDF();
        
        String[] arr2 = {"year", "GeNder", "COUNT"};
        MyDataFrame dfSlice4 = df.slice(arr2);
        System.out.println("TEST: Slicing (String[] nameArr)");
        dfSlice4.head(20).printDF();
        
        // test indexing
        MyDataFrame indexDF = df.loc(560);
        System.out.println("TEST: Indexing (int index)");
        indexDF.printDF();
        
        MyDataFrame indexDF2 = df.loc(5,8);
        System.out.println("TEST: Indexing (int from, int to)");
        indexDF2.printDF();
        
        
        // test filter
        MyDataFrame filter1 = df.filter("count", ">=", 50);
        System.out.println("TEST: Filtering (Number)");
        filter1.printDF();
        
        MyDataFrame filter2 = df.filter("name", "=", "Mary");
        System.out.println("TEST: Filtering (String)");
        filter2.printDF();
        
        // test sort
        MyDataFrame sort1 = df.sort(4); // sort by count ascending
        System.out.println("TEST: Sorting (int index)");
        sort1.head(20).printDF();
        
        MyDataFrame sort2 = df.sort("name");
        System.out.println("TEST: Sorting (String name)");
        sort2.head(20).printDF();
        
        // test aggregation
        
        System.out.println("TEST: Aggregation (Max by Index)");
        System.out.println(df.getMax(4));
        
        System.out.println("TEST: Aggregation (Max by Name)");
        System.out.println(df.getMax("COUNT"));
        
        System.out.println("TEST: Aggregation (Min by Index)");
        System.out.println(df.getMin(3));
        
        System.out.println("TEST: Aggregation (Min by Name)");
        System.out.println(df.getMin("name"));
        
	}

}
