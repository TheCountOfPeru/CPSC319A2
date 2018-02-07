import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
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
	 * @return Returns true if a and b contain the exact same characters. False otherwise.
	 */
	public static boolean isAnagram(String x, String y) {
		if(x.length() != y.length())
			return false;
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
		Scanner scanner;
		LLVector myArray;
		stringVector input;
		stringVector tempVec;
		String tempstring;
		PrintWriter writer;
		long startTime; 
		long elapsedTime;
		if(args.length != 2) {
			System.out.println("Incorrect number of inputs. Quitting...");
			System.exit(-1);
		}
		if(!getFileExtension(args[0]).equals(".txt") || !getFileExtension(args[1]).equals(".txt")) {
			System.out.println("Unable to use files that are not text files. Check your file names. Quitting...");
			System.exit(-1);
		}
		fileIn = new File(args[0]);
		input = new stringVector();
		
		//This part scans through a given text file and places all the words into a StringVector
		try {
			System.out.println("Scanning text file for words...");
			scanner = new Scanner(fileIn);
			while(scanner.hasNextLine()){ //while there is still words left in the text file add them to a vector of strings
				input.addElement(scanner.nextLine());
			}
		}catch(Exception e){
			System.out.println("Failed to read the text file. Quitting...");
			System.exit(-1);
		}
		
		//This part sorts the anagrams so that matching anagrams are put together with each other in their own linkedlists
		System.out.println("Arranging matching anagrams together in linked lists...");
		myArray = new LLVector();
		int k = 0;		
		do {												//Go through the input vector and place anagrams into a linked list that is in an array
			tempVec = new stringVector();					//While going through it place any non-anagrams words into a new vector
			tempstring = input.get(0);						//assign the new vector back to the input vector at the end.
			myArray.addElement(new myLinkedList());			//Do this until the new vector has a size of 0 which means
			myArray.get(k).addToTail(tempstring);			//there are no more new anagrams to find
			for (int i = 1; i < input.size(); i++) {
				if (isAnagram(tempstring, input.get(i)))
					myArray.get(k).addToTail(input.get(i));
				else
					tempVec.addElement(input.get(i));
			}
			input = tempVec;
			k++;

		} while (input.size() != 0);
		//This part sorts each linkedlist of each index of the linkedlist array, then sorts those linkedlists in the array
		System.out.println("Sorting anagram linkedlists with insertion sort...");
		myArray.insertionSortAllindex();
		
		System.out.println("Sorting the linkedlists with quick sort...");
		myArray.quicksort();
		try {
			System.out.println("Writing results to file: "+args[1]);
			writer = new PrintWriter(args[1]);
			myArray.printLLVector(writer);
			writer.close();
		} catch (FileNotFoundException e) {
			System.out.println("Unable to access file to print sorted array contents.");
			e.printStackTrace();
		}
		System.out.println("Program complete. Quitting...");
	}
}
