public class CustomIntList {
	public int[] storageArray = null;

	public CustomIntList(int arrayLength) {
		storageArray = new int[arrayLength];
	}

	public CustomIntList(int[] arrayContents) {
		storageArray = new int[arrayContents.length];
		System.arraycopy(arrayContents, 0, storageArray, 0, arrayContents.length);
	}

	public int pop() {
		int returnValue = storageArray[0];
		int[] newArray = new int[storageArray.length - 1];
		System.arraycopy(storageArray, 1, newArray, 0, newArray.length);
		storageArray = newArray;
		return returnValue;
	}

	public void push(int value) {
		int[] newArray = new int[storageArray.length + 1];
		System.arraycopy(storageArray, 0, newArray, 0, storageArray.length);
		newArray[newArray.length - 1] = value;
		storageArray = newArray;
	}

	public void pushAll(int[] values) {
		int[] newArray = new int[storageArray.length + values.length];
		System.arraycopy(storageArray, 0, newArray, 0, storageArray.length);
		System.arraycopy(values, 0, newArray, storageArray.length, values.length);
		storageArray = newArray;
	}
}
