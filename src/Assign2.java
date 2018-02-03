import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * @author Jonathan Yee
 *
 */
public class Assign2 {
	/**
	 * Adapted from https://stackoverflow.com/a/21974043
	 * @param aString
	 * @return
	 */
	public static String getFileExtension(String aString) {
	    try {
	        return aString.substring(aString.lastIndexOf("."));
	    } catch (Exception e) {
	        return "";
	    }
	}
	/*
	 * Adapted from Data Structures and Algorithms 2nd Edition, Drozdek p.474
	 */
	public static void swap(int[] a, int e1, int e2) {
		int tmp = a[e1]; 
		a[e1] = a[e2]; 
		a[e2] = tmp;
		}
	/*
	 * Adapted from Data Structures and Algorithms 2nd Edition, Drozdek p.471
	 */
	public static void insertionsortChars(char[] data) {
		int i = 1, j;
		while(i < data.length) {
			j = i;
			char tmp = data[i];
			while(j > 0 && tmp < data[j-1]) {
				data[j] = data[j-1];
			j--;
			}//end of inner loop
			data[j] = tmp;
			i++;
		}//end of outer loop
	}/*
	 * Adapted from Data Structures and Algorithms 2nd Edition, Drozdek p.489
	 */
	public static void quicksort(int[] data, int first, int last) {
		int lower = first + 1, upper = last;
		swap(data,first,(first+last)/2);
		int bound = data[first];
		while (lower <= upper) {
			while (bound > data[lower]) {
				lower++;
		}
		while (bound < data[upper]) 
			upper--;
		if (lower < upper)
			swap(data,lower++,upper--);
		else lower++;
		}
		swap(data,upper,first);
		if (first < upper-1)
		quicksort(data,first,upper-1);
		if (upper+1 < last)
		quicksort(data,upper+1,last);
		}
	/*
	 * Adapted from Data Structures and Algorithms 2nd Edition, Drozdek p.489
	 */
	public static void quicksort(int[] data) {
		if (data.length < 2)
			return;
		int max = 0;
		// find the largest element and put it at the end of data;
		for (int i = 1; i < data.length; i++) {
			if (data[max] < data[i]){
				max = i;
			}
		}
		swap(data,data.length-1,max); 		// largest el is now in its
		quicksort(data,0,data.length-2); 	// final position;
		}
	/**
	 * Compares two strings to see if they are anagrams of each other.
	 * @param x The first string
	 * @param y The second string
	 * @return Returns true if a and b are anagrams of each other. False otherwise.
	 */
	public static boolean isAnagram(String x, String y) {
		if(x.length() != y.length())
			return false;
		System.out.println("Comparing "+x +" with "+y+".");
		char[] a = x.toCharArray();
		char[] b = y.toCharArray();
		insertionsortChars(a);
		insertionsortChars(b);
		if(Arrays.equals(a, b))
			return true;
		else 
			return false;
	}
	public static void main(String[] args) {
		File fileIn;
		Scanner input;
		LinkedList[] myArray;
		stringVector rawInput;
		Integer total = 1;
		String temp;
		if(args.length != 2) {
			System.out.println("Incorrect number of inputs. Quitting...");
			System.exit(-1);
		}
		if(!getFileExtension(args[0]).equals(".txt") || !getFileExtension(args[1]).equals(".txt") ) {
			System.out.println("Unable to use files that are not text files. Check your file names. Quitting...");
			System.exit(-1);
		}
		fileIn = new File(args[0]);
		rawInput = new stringVector();
		
		try {
			input = new Scanner(fileIn);
			while(input.hasNextLine()){ //while there is still words left in the text file add them to a linkedlist
				rawInput.addElement(input.nextLine());
			}
		}catch(Exception e){
			System.out.println("Failed to read the text file. Quitting...");
			System.exit(-1);
		}
		for(int i =0;i<rawInput.size();i++) {
			System.out.println(rawInput.get(i));
		}


	}
}
