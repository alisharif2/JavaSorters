/*
 * Implementation of Merge Sort Algorithm by Ali Murtaza Sharif
 * The algorithm is divided into two parts
 * 	1 - Subdividing the list into sublists
 * 	2 - Assuming the the sublists are sorted, combine the sorted lists to make a new sorted list
 *
 * How this is done is explained below
 * mergesort:
 * 	1 - Take input list and split it into two lists, left and right
 * 	2 - Call mergeHelper to combine left and right into a new sorted list
 * 	3 - However, left and right are not sorted, so sort them using mergesort before passing them to mergeHelper
 *
 * mergeHelper:
 * 	1 - While each list has at least one element, compare the first element of both lists
 * 	2 - Remove the smaller element from its list and place it into a new resultant list
 * 	3 - Repeat until one list is exhausted of elements
 * 	4 - Append the contents of the remaining list onto the resultant list
 *
 * This algorithm works recursively. By repeatedly calling the mergesort method from within mergesort the list can be broken down into single element lists.
 * Single element lists are sorted by definition, hence they can be passed into the mergeHelper method. mergeHelper needs two sorted lists.
 *
 * Example:
 * 	We want to sort [4, 3, 2, 1]
 * 	mergesort([4, 3, 2, 1]) -> mergeHelper(mergesort([4, 3]), mergesort([2, 1]))
 * 	mergesort([4, 3]) -> mergeHelper([4], [3])
 * 	mergesort([2, 1]) -> mergeHelper([2], [1])
 * 	mergeHelper([4], [3]) -> [3, 4]
 *	mergeHelper([2], [1]) -> [1, 2]
 *	mergesort([4, 3]) -> [3, 4]
 * 	mergesort([2, 1]) -> [1, 2]
 * 	mergesort([4, 3, 2, 1]) -> mergeHelper(mergesort([4, 3]), mergesort([2, 1])) -> mergeHelper([1, 2], [3, 4]) -> [1, 2, 3, 4]
 */

import java.util.Arrays;
public class MergeSort {
	public static void main(String args[]) {
		System.out.println(Arrays.toString(mergesort(parseArgument(args))));
	}

	public static int[] mergesort(int[] unsortedList) {
		if(unsortedList.length < 2) return unsortedList;
		// Split array in half
		int midpoint = unsortedList.length/2;
		int[] left = new int[midpoint];
		int[] right = new int[unsortedList.length - midpoint];
		System.arraycopy(unsortedList, 0, left, 0, midpoint);
		System.arraycopy(unsortedList, midpoint, right, 0, unsortedList.length - midpoint);
		return mergeHelper(mergesort(left), mergesort(right));
	}

	public static int[] mergeHelper(int[] sortedArray1, int[] sortedArray2) {
		CustomIntList sortedList1 = new CustomIntList(sortedArray1);
		CustomIntList sortedList2 = new CustomIntList(sortedArray2);
		CustomIntList resultantList = new CustomIntList(0);
		while(sortedList1.storageArray.length > 0 && sortedList2.storageArray.length > 0) {
			if(sortedList1.storageArray[0] <= sortedList2.storageArray[0]) resultantList.push(sortedList1.pop());
			else resultantList.push(sortedList2.pop());
		}
		if(sortedList2.storageArray.length == 0) resultantList.pushAll(sortedList1.storageArray);
		if(sortedList1.storageArray.length == 0) resultantList.pushAll(sortedList2.storageArray);
		return resultantList.storageArray;
	}

	public static int[] parseArgument(String args[]) {
		if(args.length == 0) {
			System.out.println("Pass a comma delimited list of numbers with no white spaces\nThis program will sort the list in ascending order");
			System.exit(1);
		}
		String[] stringNumArray = args[0].split(",");
		int[] unorderedList = new int[stringNumArray.length];
		for(int i = 0;i < unorderedList.length;i++) {
			try {
				unorderedList[i] = Int.parseInt(stringNumArray[i]);
			} catch (NumberFormatException e) {
				System.out.println("Please enter valid numbers");
				System.exit(1);
			}
		}
		return unorderedList;
	}

	public static int[] combineIntArrays(int[] array1, int[] array2) {
		int[] resultantArray = new int[array1.length + array2.length];
		for(int i = 0;i < array1.length;i++) {
			resultantArray[i] = array1[i];
		}
		for(int i = 0;i < array2.length;i++) {
			resultantArray[i + array1.length] = array2[i];
		}
		return resultantArray;
	}
}
