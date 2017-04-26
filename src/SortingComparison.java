
public class SortingComparison {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		Select selection = new Select();
		selection.main(args);
		long endTime = System.currentTimeMillis();
		long elapsedTime = endTime - startTime;
		System.out.print("Selection: ");
		System.out.println(elapsedTime);		
		
		startTime = System.currentTimeMillis();
		Insert insert = new Insert();
		insert.main(args);
		endTime = System.currentTimeMillis();
		elapsedTime = endTime - startTime;
		System.out.print("Insertion: ");
		System.out.println(elapsedTime);
		
		startTime = System.currentTimeMillis();
		Mergesort mergeSort = new Mergesort();
		mergeSort.main(args);
		endTime = System.currentTimeMillis();
		elapsedTime = endTime - startTime;
		System.out.print("Merge: ");
		System.out.println(elapsedTime);
		
		startTime = System.currentTimeMillis();
		Quicksort quickSort = new Quicksort();
		quickSort.main(args);
		endTime = System.currentTimeMillis();
		elapsedTime = endTime - startTime;
		System.out.print("Quicksort: ");
		System.out.println(elapsedTime);
		
		startTime = System.currentTimeMillis();
		Heapsort heapSort = new Heapsort();
		heapSort.main(args);
		endTime = System.currentTimeMillis();
		elapsedTime = endTime - startTime;
		System.out.print("Heapsort: ");
		System.out.print(elapsedTime);

	}

}
