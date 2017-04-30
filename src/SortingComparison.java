
public class SortingComparison {

	public static void main(String[] args) {
		int numEle = 100000;
		int[] data = new int[numEle];
		int upper = 1000000;
		int lower = 1;
		long startTime;
		long endTime;
		long elapsedTime;
		for (int i = 0; i < data.length; i++) {
			data[i] = (int) (Math.random() * (upper - lower) + lower);
			System.out.print(data[i]);
			System.out.print("\t");	
			if (i%2 == 1){
				System.out.print("\n");	
			}
		}			
		System.out.println("\n");
		int[] selectData = new int[numEle];
		System.arraycopy(data, 0, selectData, 0, data.length);
		int[] insertData = new int[numEle];
		System.arraycopy(data, 0, insertData, 0, data.length);
		int[] mergeData = new int[numEle];
		System.arraycopy(data, 0, mergeData, 0, data.length);
		int[] quickData = new int[numEle];
		System.arraycopy(data, 0, quickData, 0, data.length);
		int[ ] heapData = new int[numEle];
		System.arraycopy(data, 0, heapData, 0, data.length);
		
		//selection sort

		startTime = System.currentTimeMillis();
		Select.selectionsort(selectData, 0, data.length);
		endTime = System.currentTimeMillis();
		elapsedTime = endTime - startTime;
		System.out.print("Selection: ");
		System.out.println(elapsedTime);
		
		//insertion sort

		startTime = System.currentTimeMillis();
		Insert.insertionsort(insertData, 0, insertData.length);
		endTime = System.currentTimeMillis();
		elapsedTime = endTime - startTime;
		System.out.print("Insertion: ");
		System.out.println(elapsedTime);
		
		//merge sort

		startTime = System.currentTimeMillis();
		Mergesort.mergesort(mergeData, 0, mergeData.length);
		endTime = System.currentTimeMillis();
		elapsedTime = endTime - startTime;
		System.out.print("Merge: ");
		System.out.println(elapsedTime);

		//quick sort

		startTime = System.currentTimeMillis();
		Quicksort.quicksort(quickData, 1, quickData.length-2);
		endTime = System.currentTimeMillis();
		elapsedTime = endTime - startTime;
		System.out.print("Quicksort: ");
		System.out.println(elapsedTime);

		//heap sort

		startTime = System.currentTimeMillis();
		Heapsort.heapsort(heapData, heapData.length);
		endTime = System.currentTimeMillis();
		elapsedTime = endTime - startTime;
		System.out.print("Heapsort: ");
		System.out.print(elapsedTime);

	}

}
