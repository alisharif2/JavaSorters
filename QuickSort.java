import java.util.Arrays;
public class QuickSort {
	public static void main(String args[]) {
		long[] unorderedList = parseArgument(args);
		bubbleSort(unorderedList);
		System.out.println(Arrays.toString(unorderedList));
	}
	
	public static long[] parseArgument(String args[]) {
		if(args.length == 0) {
			System.out.println("Please pass a comma delimited list of numbers with no white spaces\nThis program will sort the list in ascending order");
			System.exit(1);
		}
		String[] stringNumArray = args[0].split(",");
		long[] unorderedList = new long[stringNumArray.length];
		for(int i = 0;i < unorderedList.length;i++) {
			try {
				unorderedList[i] = Long.parseLong(stringNumArray[i]);
			} catch (NumberFormatException e) {
				System.out.println("Please enter actual numbers dumbass");
				System.exit(1);
			}
		}
		return unorderedList;
	}

	public static void bubbleSort(long[] unorderedList) {
		boolean isOrdered = false;
		while(!isOrdered) {
			isOrdered = true;
			for(int i = 0;i < unorderedList.length - 1;i++) {
				if(unorderedList[i] > unorderedList[i + 1]) {
					long temp = unorderedList[i];
					unorderedList[i] = unorderedList[i + 1];
					unorderedList[i + 1] = temp;
					isOrdered = false;
				}
			}
		}
	}
}
