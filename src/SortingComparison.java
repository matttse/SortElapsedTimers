
public class SortingComparison {

	public static void main(String[] args) {
		int[] data = new int[10];
		int upper = 1000000;
		int lower = 1;
		for (int i = 0; i < data.length; i++) {
			data[i] = (int) (Math.random() * (upper - lower) + lower);
			System.out.print(data[i]);
			System.out.print("\t");
		}			
		System.out.println("\n");
		
		//selection sort
		int[] selectData = new int[10];
		System.arraycopy(data, 0, selectData, 0, data.length);
		long startTime = System.currentTimeMillis();
		Select.selectionsort(selectData, 0, data.length);
		long endTime = System.currentTimeMillis();
		long elapsedTime = endTime - startTime;
		System.out.print("Selection: ");
		System.out.println(elapsedTime);
		
		//insertion sort
		int[] insertData = new int[10];
		System.arraycopy(data, 0, insertData, 0, data.length);
		startTime = System.currentTimeMillis();
		Insert.insertionsort(insertData, 0, insertData.length);
		endTime = System.currentTimeMillis();
		elapsedTime = endTime - startTime;
		System.out.print("Insertion: ");
		System.out.println(elapsedTime);
		//merge sort
		int[] mergeData = new int[10];
		System.arraycopy(data, 0, mergeData, 0, data.length);
		startTime = System.currentTimeMillis();
		Mergesort.mergesort(mergeData, 0, mergeData.length);
		endTime = System.currentTimeMillis();
		elapsedTime = endTime - startTime;
		System.out.print("Merge: ");
		System.out.println(elapsedTime);

		//quick sort
		int[] quickData = new int[10];
		System.arraycopy(data, 0, quickData, 0, data.length);
		startTime = System.currentTimeMillis();
		Quicksort.quicksort(quickData, 1, quickData.length-2);
		endTime = System.currentTimeMillis();
		elapsedTime = endTime - startTime;
		System.out.print("Quicksort: ");
		System.out.println(elapsedTime);

		//heap sort
		int[ ] heapData = new int[10];
		System.arraycopy(data, 0, heapData, 0, data.length);
		startTime = System.currentTimeMillis();
//		Heapsort.heapsort(heapData, heapData.length);
		endTime = System.currentTimeMillis();
		elapsedTime = endTime - startTime;
		System.out.print("Heapsort: ");
		System.out.print(elapsedTime);

	}

}
