
public class SortingComparison {

	public static void main(String[] args) {
		int[ ] data = { 1000, 80, 10, 50, 70, 60, 90, 20, 30, 40, 0, -1000 };	
		
		int[ ] selectData = {0,0,0,0,0,0,0,0,0,0,0,0};
		System.arraycopy(data, 0, selectData, 0, data.length);
		long startTime = System.currentTimeMillis();
		Select.selectionsort(selectData, 1, data.length-2);
		long endTime = System.currentTimeMillis();
		long elapsedTime = endTime - startTime;
		System.out.print("Selection: ");
		System.out.println(elapsedTime);		

		int[ ] insertData = {0,0,0,0,0,0,0,0,0,0,0,0};
		System.arraycopy(data, 0, insertData, 0, data.length);
		startTime = System.currentTimeMillis();
		Insert.insertionsort(insertData, 1, insertData.length-2);
		endTime = System.currentTimeMillis();
		elapsedTime = endTime - startTime;
		System.out.print("Insertion: ");
		System.out.println(elapsedTime);

		int[ ] mergeData = {0,0,0,0,0,0,0,0,0,0,0,0};
		System.arraycopy(data, 0, mergeData, 0, data.length);
		startTime = System.currentTimeMillis();
		Mergesort.mergesort(mergeData, 1, mergeData.length-2);
		endTime = System.currentTimeMillis();
		elapsedTime = endTime - startTime;
		System.out.print("Merge: ");
		System.out.println(elapsedTime);

		int[ ] quickData = {0,0,0,0,0,0,0,0,0,0,0,0};
		System.arraycopy(data, 0, quickData, 0, data.length);
		startTime = System.currentTimeMillis();
		Quicksort.quicksort(quickData, 1, quickData.length-2);
		endTime = System.currentTimeMillis();
		elapsedTime = endTime - startTime;
		System.out.print("Quicksort: ");
		System.out.println(elapsedTime);

		int[ ] heapData = {0,0,0,0,0,0,0,0,0,0,0,0};
		System.arraycopy(data, 0, heapData, 0, data.length);
		startTime = System.currentTimeMillis();
		Heapsort.heapsort(heapData, heapData.length);
		endTime = System.currentTimeMillis();
		elapsedTime = endTime - startTime;
		System.out.print("Heapsort: ");
		System.out.print(elapsedTime);

	}

}
