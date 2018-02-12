import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
/**
 * This program takes a text file with a list of words and assembles matching anagrams that it finds into linkedlists. Then those linkedlists are connected
 * to a Vector that contains references to all the lists. It then prints it out.
 * @author Jonathan Yee
 * @since Feb 12, 2018
 */
public class Assign2 {
	/**
	 * Adapted from https://stackoverflow.com/a/21974043
	 * @param aString - The name of a text file.
	 * @return The file extension if it exists, blank otherwise
	 */
	public static String getFileExtension(String aString) {
	    try {
	        return aString.substring(aString.lastIndexOf("."));
	    } catch (Exception e) {
	        return "";
	    }
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
		String tempstring;
		String t;
		myLinkedList inputll;
		myLinkedList templl;
		PrintWriter writer;
		long startTime; 
		long elapsedTime;
		
		//Command line argument block
		if(args.length != 2) {
			System.out.println("Incorrect number of inputs. Quitting...");
			System.exit(-1);
		}
		if(!getFileExtension(args[0]).equals(".txt") || !getFileExtension(args[1]).equals(".txt")) {
			System.out.println("Unable to use files that are not text files. Check your file names. Quitting...");
			System.exit(-1);
		}
		fileIn = new File(args[0]);
		inputll = new myLinkedList();
		startTime = System.nanoTime();
		//This part scans through a given text file and places all the words into a myLinkedList
		try {
			System.out.println("Scanning text file for words...");
			scanner = new Scanner(fileIn);
			while(scanner.hasNextLine()){ 
				inputll.addToTail(scanner.nextLine());
			}
		}catch(Exception e){
			System.out.println("Failed to read the text file. Quitting...");
			System.exit(-1);
		}

		
		/**
		 * This part sorts the anagrams so that matching anagrams are put together with each other in their own mylinkedlists.
		 * It does this by parsing the inputll mylinkedlist from above. It takes the first head node as the word it looks for matching anagrams.
		 * When it finds a match it creates a new node that is for the mylinkedlists in the Vector of mylinkedlists references.
		 * If the word does not match it is the node data is put in a temporary linked that replaces inputll at the end of the search for anagrams
		 */
		
		System.out.println("Arranging matching anagrams together in linked lists...");
		myArray = new LLVector();
		
		int k= 0;
		do {
			templl = new myLinkedList();
			tempstring = inputll.deleteFromHead();
			myArray.addElement(new myLinkedList());
			myArray.get(k).addToTail(tempstring);
			while(!inputll.isEmpty()) {
				t = inputll.deleteFromHead();
				if(isAnagram(tempstring, t))
					myArray.get(k).addToTail(t);
				else
					templl.addToTail(t);
			}
			inputll = templl;
			k++;
		}while(!inputll.isEmpty());
	
		/*
		 * This part goes through the vector's mylinkedlists and sorts them.
		 */
		System.out.println("Sorting anagram linkedlists with insertion sort...");
		myArray.insertionSortAllindex();
		/*
		 * This part then sorts the vector itself
		 */
		System.out.println("Sorting the linkedlists with quick sort...");
		myArray.quicksort();
		try {
			System.out.println("Writing results to file: "+args[1]);
			writer = new PrintWriter(args[1]);
			myArray.printLLVectorFile(writer);
			writer.close();
		} catch (FileNotFoundException e) {
			System.out.println("Unable to access file to print sorted array contents.");
			e.printStackTrace();
		}
		elapsedTime = System.nanoTime() - startTime;
		System.out.println("Program complete. Running time: " +elapsedTime/1000000000.0+" seconds.");
		System.out.println("Quitting...");
		
	}
}
