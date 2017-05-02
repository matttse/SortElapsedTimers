import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.font.FontRenderContext;
import java.awt.font.LineMetrics;
import java.awt.geom.Line2D;
import java.util.LinkedList;

import javax.swing.*;

public class SortingComparison extends JComponent {
	
	//selection sort
	public static long selectionSorting(int[] selectData) {
		long startTime = System.currentTimeMillis();
		Select.selectionsort(selectData, 0, selectData.length);
		long endTime = System.currentTimeMillis();
		long elapsedTime = endTime - startTime;

		System.out.print("Selection: ");
		System.out.println(elapsedTime);
		return elapsedTime;
	}
	
	//insertion sort
	public static long insertionSorting(int[] insertData) {
		long startTime = System.currentTimeMillis();
		Insert.insertionsort(insertData, 0, insertData.length);
		long endTime = System.currentTimeMillis();
		long elapsedTime = endTime - startTime;
		return elapsedTime;
	}
	
	//merge sort
	public static long mergeSorting(int[] mergeData) {
		long startTime = System.currentTimeMillis();
		Mergesort.mergesort(mergeData, 0, mergeData.length);
		long endTime = System.currentTimeMillis();
		long elapsedTime = endTime - startTime;
		return elapsedTime;
	}
	
	//quick sort
	public static long quickSorting(int[] quickData) {
		long startTime = System.currentTimeMillis();
		Quicksort.quicksort(quickData, 1, quickData.length-2);
		long endTime = System.currentTimeMillis();
		long elapsedTime = endTime - startTime;	
		return elapsedTime;
	}
	
	//heap sort
	public static long heapSorting(int[] heapData) {
		long startTime = System.currentTimeMillis();
		Heapsort.heapsort(heapData, heapData.length);
		long endTime = System.currentTimeMillis();
		long elapsedTime = endTime - startTime;
		return elapsedTime;
	}
	
	public static int[] generateData(int min, int max, int elements) {
		int[] data = new int[elements];
		for (int i = 0; i < elements; i++) {
			data[i] = (int) (Math.random() * (max - min) + min);
		}
		return data;
	}

	public static void main(String[] args) {
		int upper = 1000000;
		int lower = 1;
		int[] data1, data2, data3, data4, data5, data6, data7, data8, data9, data10;
		Object sTime1, sTime2, sTime3, sTime4, sTime5, sTime6, sTime7, sTime8, sTime9, sTime10;
		Object iTime1, iTime2, iTime3, iTime4, iTime5, iTime6, iTime7, iTime8, iTime9, iTime10;
		Object mTime1, mTime2, mTime3, mTime4, mTime5, mTime6, mTime7, mTime8, mTime9, mTime10;
		Object qTime1, qTime2, qTime3, qTime4, qTime5, qTime6, qTime7, qTime8, qTime9, qTime10;
		Object hTime1, hTime2, hTime3, hTime4, hTime5, hTime6, hTime7, hTime8, hTime9, hTime10;
		long[] selectionETime = new long[10];
		long[] insertionETime = new long[10];
		long[] mergeETime = new long[10];
		long[] quickETime = new long[10];
		long[] heapETime = new long[10];
		
		//10000
		int numEle = 10000;
		data1 = generateData(lower, upper, numEle);
		int[] selectData = new int[numEle];
		System.arraycopy(data1, 0, selectData, 0, numEle);
		int[] insertData = new int[numEle];
		System.arraycopy(data1, 0, insertData, 0, numEle);
		int[] mergeData = new int[numEle];
		System.arraycopy(data1, 0, mergeData, 0, numEle);
		int[] quickData = new int[numEle];
		System.arraycopy(data1, 0, quickData, 0, numEle);
		int[] heapData = new int[numEle];
		System.arraycopy(data1, 0, heapData, 0, numEle);		
		
		sTime1 = Long.toString(selectionSorting(selectData));
		iTime1 = Long.toString(insertionSorting(insertData));
		mTime1 = Long.toString(mergeSorting(mergeData));
		qTime1 = Long.toString(quickSorting(quickData));
		hTime1 = Long.toString(heapSorting(heapData));

		//20000
		numEle = 20000;
		data2 = generateData(lower, upper, numEle);
		selectData = new int[numEle];
		System.arraycopy(data2, 0, selectData, 0, numEle);
		insertData = new int[numEle];
		System.arraycopy(data2, 0, insertData, 0, numEle);
		mergeData = new int[numEle];
		System.arraycopy(data2, 0, mergeData, 0, numEle);
		quickData = new int[numEle];
		System.arraycopy(data2, 0, quickData, 0, numEle);
		heapData = new int[numEle];
		System.arraycopy(data2, 0, heapData, 0, numEle);		
		
		sTime2 = Long.toString(selectionSorting(selectData));
		iTime2 = Long.toString(insertionSorting(insertData));
		mTime2 = Long.toString(mergeSorting(mergeData));
		qTime2 = Long.toString(quickSorting(quickData));
		hTime2 = Long.toString(heapSorting(heapData));
		
		//30000
		numEle = 30000;
		data3 = generateData(lower, upper, numEle);
		selectData = new int[numEle];
		System.arraycopy(data3, 0, selectData, 0, numEle);
		insertData = new int[numEle];
		System.arraycopy(data3, 0, insertData, 0, numEle);
		mergeData = new int[numEle];
		System.arraycopy(data3, 0, mergeData, 0, numEle);
		quickData = new int[numEle];
		System.arraycopy(data3, 0, quickData, 0, numEle);
		heapData = new int[numEle];
		System.arraycopy(data3, 0, heapData, 0, numEle);		
		
		sTime3 = Long.toString(selectionSorting(selectData));
		iTime3 = Long.toString(insertionSorting(insertData));
		mTime3 = Long.toString(mergeSorting(mergeData));
		qTime3 = Long.toString(quickSorting(quickData));
		hTime3 = Long.toString(heapSorting(heapData));
		
		//40000
		numEle = 40000;
		data4 = generateData(lower, upper, numEle);
		selectData = new int[numEle];
		System.arraycopy(data4, 0, selectData, 0, numEle);
		insertData = new int[numEle];
		System.arraycopy(data4, 0, insertData, 0, numEle);
		mergeData = new int[numEle];
		System.arraycopy(data4, 0, mergeData, 0, numEle);
		quickData = new int[numEle];
		System.arraycopy(data4, 0, quickData, 0, numEle);
		heapData = new int[numEle];
		System.arraycopy(data4, 0, heapData, 0, numEle);		
		
		sTime4 = Long.toString(selectionSorting(selectData));
		iTime4 = Long.toString(insertionSorting(insertData));
		mTime4 = Long.toString(mergeSorting(mergeData));
		qTime4 = Long.toString(quickSorting(quickData));
		hTime4 = Long.toString(heapSorting(heapData));
		
		//50000
		numEle = 50000;
		data5 = generateData(lower, upper, numEle);
		selectData = new int[numEle];
		System.arraycopy(data5, 0, selectData, 0, numEle);
		insertData = new int[numEle];
		System.arraycopy(data5, 0, insertData, 0, numEle);
		mergeData = new int[numEle];
		System.arraycopy(data5, 0, mergeData, 0, numEle);
		quickData = new int[numEle];
		System.arraycopy(data5, 0, quickData, 0, numEle);
		heapData = new int[numEle];
		System.arraycopy(data5, 0, heapData, 0, numEle);		
		
		sTime5 = Long.toString(selectionSorting(selectData));
		iTime5 = Long.toString(insertionSorting(insertData));
		mTime5 = Long.toString(mergeSorting(mergeData));
		qTime5 = Long.toString(quickSorting(quickData));
		hTime5 = Long.toString(heapSorting(heapData));
		
		//60000
		numEle = 60000;
		data6 = generateData(lower, upper, numEle);
		selectData = new int[numEle];
		System.arraycopy(data6, 0, selectData, 0, numEle);
		insertData = new int[numEle];
		System.arraycopy(data6, 0, insertData, 0, numEle);
		mergeData = new int[numEle];
		System.arraycopy(data6, 0, mergeData, 0, numEle);
		quickData = new int[numEle];
		System.arraycopy(data6, 0, quickData, 0, numEle);
		heapData = new int[numEle];
		System.arraycopy(data6, 0, heapData, 0, numEle);		
		
		sTime6 = Long.toString(selectionSorting(selectData));
		iTime6 = Long.toString(insertionSorting(insertData));
		mTime6 = Long.toString(mergeSorting(mergeData));
		qTime6 = Long.toString(quickSorting(quickData));
		hTime6 = Long.toString(heapSorting(heapData));
		
		//70000
		numEle = 70000;
		data7 = generateData(lower, upper, numEle);
		selectData = new int[numEle];
		System.arraycopy(data7, 0, selectData, 0, numEle);
		insertData = new int[numEle];
		System.arraycopy(data7, 0, insertData, 0, numEle);
		mergeData = new int[numEle];
		System.arraycopy(data7, 0, mergeData, 0, numEle);
		quickData = new int[numEle];
		System.arraycopy(data7, 0, quickData, 0, numEle);
		heapData = new int[numEle];
		System.arraycopy(data7, 0, heapData, 0, numEle);		
		
		sTime7 = Long.toString(selectionSorting(selectData));
		iTime7 = Long.toString(insertionSorting(insertData));
		mTime7 = Long.toString(mergeSorting(mergeData));
		qTime7 = Long.toString(quickSorting(quickData));
		hTime7 = Long.toString(heapSorting(heapData));
		
		//80000
		numEle = 80000;
		data8 = generateData(lower, upper, numEle);
		selectData = new int[numEle];
		System.arraycopy(data8, 0, selectData, 0, numEle);
		insertData = new int[numEle];
		System.arraycopy(data8, 0, insertData, 0, numEle);
		mergeData = new int[numEle];
		System.arraycopy(data8, 0, mergeData, 0, numEle);
		quickData = new int[numEle];
		System.arraycopy(data8, 0, quickData, 0, numEle);
		heapData = new int[numEle];
		System.arraycopy(data8, 0, heapData, 0, numEle);		
		
		sTime8 = Long.toString(selectionSorting(selectData));
		iTime8 = Long.toString(insertionSorting(insertData));
		mTime8 = Long.toString(mergeSorting(mergeData));
		qTime8 = Long.toString(quickSorting(quickData));
		hTime8 = Long.toString(heapSorting(heapData));
		
		//90000
		numEle = 90000;
		data9 = generateData(lower, upper, numEle);
		selectData = new int[numEle];
		System.arraycopy(data9, 0, selectData, 0, numEle);
		insertData = new int[numEle];
		System.arraycopy(data9, 0, insertData, 0, numEle);
		mergeData = new int[numEle];
		System.arraycopy(data9, 0, mergeData, 0, numEle);
		quickData = new int[numEle];
		System.arraycopy(data9, 0, quickData, 0, numEle);
		heapData = new int[numEle];
		System.arraycopy(data9, 0, heapData, 0, numEle);		
		
		sTime9 = Long.toString(selectionSorting(selectData));
		iTime9 = Long.toString(insertionSorting(insertData));
		mTime9 = Long.toString(mergeSorting(mergeData));
		qTime9 = Long.toString(quickSorting(quickData));
		hTime9 = Long.toString(heapSorting(heapData));
		
		//100000
		numEle = 100000;
		data10 = generateData(lower, upper, numEle);
		selectData = new int[numEle];
		System.arraycopy(data10, 0, selectData, 0, numEle);
		insertData = new int[numEle];
		System.arraycopy(data10, 0, insertData, 0, numEle);
		mergeData = new int[numEle];
		System.arraycopy(data10, 0, mergeData, 0, numEle);
		quickData = new int[numEle];
		System.arraycopy(data10, 0, quickData, 0, numEle);
		heapData = new int[numEle];
		System.arraycopy(data10, 0, heapData, 0, numEle);		
		
		sTime10 = Long.toString(selectionSorting(selectData));
		iTime10 = Long.toString(insertionSorting(insertData));
		mTime10 = Long.toString(mergeSorting(mergeData));
		qTime10 = Long.toString(quickSorting(quickData));
		hTime10 = Long.toString(heapSorting(heapData));
		
		Object[][] tableData =
		{
	            {"Selection", sTime1, sTime2, sTime3, sTime4 , sTime5, sTime6, sTime7, sTime8, sTime9, sTime10 },
	            {"Insertion", iTime1, iTime2, iTime3, iTime4 , iTime5, iTime6, iTime7, iTime8, iTime9, iTime10 },
	            {"Merge", mTime1, mTime2, mTime3, mTime4 , mTime5, mTime6, mTime7, mTime8, mTime9, mTime10 },
	            {"Quicksort", qTime1, qTime2, qTime3, qTime4 , qTime5, qTime6, qTime7, qTime8, qTime9, qTime10 },
	            {"Heapsort", hTime1, hTime2, hTime3, hTime4 , hTime5, hTime6, hTime7, hTime8, hTime9, hTime10 },

		};
		String[] columnNames = {"Algorithms", "10000", "20000", "30000", "40000", "50000", "60000", "70000", "80000", "90000", "100000"};
	    //build table
		JTable table = new JTable(tableData, columnNames);
		JScrollPane scrollPane = new JScrollPane(table);
		JFrame elapsedTimeTable = new JFrame();
		
		elapsedTimeTable.add(scrollPane, BorderLayout.CENTER);
		elapsedTimeTable.setSize(700, 200);
		elapsedTimeTable.setVisible(true);
		elapsedTimeTable.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//create time arrays
		for (int i = 0; i < selectionETime.length; i++) {
			selectionETime[i] = Long.parseLong(String.valueOf(tableData[0][i+1]));
			insertionETime[i] = Long.parseLong(String.valueOf(tableData[1][i+1]));
			mergeETime[i] = Long.parseLong(String.valueOf(tableData[2][i+1]));
			quickETime[i] = Long.parseLong(String.valueOf(tableData[3][i+1]));
			heapETime[i] = Long.parseLong(String.valueOf(tableData[4][i+1]));
		}  
		//display elapsed time graphs
		GraphingData gd = new GraphingData();
		//selection
		JFrame selectionGraph = new JFrame();
		selectionGraph.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		selectionGraph.setSize(800, 800);
        selectionGraph.setLocation(200,200);        
        gd.setData(selectionETime);
        selectionGraph.add(gd);
        selectionGraph.setVisible(true);
        //insertion
		JFrame insertionGraph = new JFrame();
		insertionGraph.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		insertionGraph.setSize(800, 800);
		insertionGraph.setLocation(200,200);
        gd = new GraphingData();
        gd.setData(insertionETime);
        insertionGraph.add(gd);
        insertionGraph.setVisible(true);
        //merge
		JFrame mergeGraph = new JFrame();
		mergeGraph.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mergeGraph.setSize(800, 800);
		mergeGraph.setLocation(200,200);
        gd = new GraphingData();
        gd.setData(mergeETime);
        mergeGraph.add(gd);
        mergeGraph.setVisible(true);
        //quicksort
		JFrame quickGraph = new JFrame();
		quickGraph.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		quickGraph.setSize(800, 800);
		quickGraph.setLocation(200,200);
        gd = new GraphingData();
        gd.setData(quickETime);
        quickGraph.add(gd);
        quickGraph.setVisible(true);
        //heapsort
		JFrame heapGraph = new JFrame();
		heapGraph.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		heapGraph.setSize(800, 800);
		heapGraph.setLocation(200,200);
        gd = new GraphingData();
        gd.setData(heapETime);
        heapGraph.add(gd);
        heapGraph.setVisible(true);
		 
	}
	
	
	
	
}
