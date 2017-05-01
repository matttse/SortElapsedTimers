import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.font.FontRenderContext;
import java.awt.font.LineMetrics;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class SortingComparison extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final int PAD = 20;
	  
	//selection sort
	public static long selectionSorting(int[] selectData) {
		long startTime = System.currentTimeMillis();
		Select.selectionsort(selectData, 0, selectData.length);
		long endTime = System.currentTimeMillis();
		long elapsedTime = endTime - startTime;
//			System.out.print("Selection: ");
//			System.out.println(elapsedTime);
		return elapsedTime;
	}
	
	//insertion sort
	public static long insertionSorting(int[] insertData) {
		long startTime = System.currentTimeMillis();
		Insert.insertionsort(insertData, 0, insertData.length);
		long endTime = System.currentTimeMillis();
		long elapsedTime = endTime - startTime;
//			System.out.print("Insertion: ");
//			System.out.println(elapsedTime);	
		return elapsedTime;
	}
	
	//merge sort
	public static long mergeSorting(int[] mergeData) {
		long startTime = System.currentTimeMillis();
		Mergesort.mergesort(mergeData, 0, mergeData.length);
		long endTime = System.currentTimeMillis();
		long elapsedTime = endTime - startTime;
//			System.out.print("Merge: ");
//			System.out.println(elapsedTime);
		return elapsedTime;
	}
	
	//quick sort
	public static long quickSorting(int[] quickData) {
		long startTime = System.currentTimeMillis();
		Quicksort.quicksort(quickData, 1, quickData.length-2);
		long endTime = System.currentTimeMillis();
		long elapsedTime = endTime - startTime;
		System.out.print("Quicksort: ");
		System.out.println(elapsedTime);	
		return elapsedTime;
	}
	
	//heap sort
	public static long heapSorting(int[] heapData) {
		long startTime = System.currentTimeMillis();
		Heapsort.heapsort(heapData, heapData.length);
		long endTime = System.currentTimeMillis();
		long elapsedTime = endTime - startTime;
//			System.out.print("Heapsort: ");
//			System.out.println(elapsedTime);
		return elapsedTime;
	}
	
	public static int[] generateData(int min, int max, int elements) {
		int[] data = new int[elements];
		for (int i = 0; i < elements; i++) {
			data[i] = (int) (Math.random() * (max - min) + min);
//				System.out.print(data[i]);
//				System.out.print("\t");	
//				if (i%2 == 1){
//					System.out.print("\n");	
//				}
		}
		return data;
	}
	public void paintComponent(Graphics g, int[] data) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
	                            RenderingHints.VALUE_ANTIALIAS_ON);
        int w = getWidth();
        int h = getHeight();
        // Draw ordinate.
        g2.draw(new Line2D.Double(PAD, PAD, PAD, h-PAD));
        // Draw abcissa.
        g2.draw(new Line2D.Double(PAD, h-PAD, w-PAD, h-PAD));
        // Draw labels.
        Font font = g2.getFont();
        FontRenderContext frc = g2.getFontRenderContext();
        LineMetrics lm = font.getLineMetrics("0", frc);
        float sh = lm.getAscent() + lm.getDescent();
        // Ordinate label.
        String s = "data";
        float sy = PAD + ((h - 2*PAD) - s.length()*sh)/2 + lm.getAscent();
        for(int i = 0; i < s.length(); i++) {
            String letter = String.valueOf(s.charAt(i));
            float sw = (float)font.getStringBounds(letter, frc).getWidth();
            float sx = (PAD - sw)/2;
            g2.drawString(letter, sx, sy);
            sy += sh;
        }
        // Abcissa label.
        s = "x axis";
        sy = h - PAD + (PAD - sh)/2 + lm.getAscent();
        float sw = (float)font.getStringBounds(s, frc).getWidth();
        float sx = (w - sw)/2;
        g2.drawString(s, sx, sy);
        // Draw lines.
        double xInc = (double)(w - 2*PAD)/(data.length-1);
        double scale = (double)(h - 2*PAD)/getMax(data);
        g2.setPaint(Color.green.darker());
        for(int i = 0; i < data.length-1; i++) {
            double x1 = PAD + i*xInc;
            double y1 = h - PAD - scale*data[i];
            double x2 = PAD + (i+1)*xInc;
            double y2 = h - PAD - scale*data[i+1];
            g2.draw(new Line2D.Double(x1, y1, x2, y2));
        }
        // Mark data points.
        g2.setPaint(Color.red);
        for(int i = 0; i < data.length; i++) {
            double x = PAD + i*xInc;
            double y = h - PAD - scale*data[i];
            g2.fill(new Ellipse2D.Double(x-2, y-2, 4, 4));
        }
    }
 
    private int getMax(int[] data) {
        int max = -Integer.MAX_VALUE;
        for(int i = 0; i < data.length; i++) {
            if(data[i] > max)
                max = data[i];
        }
        return max;
    }
	public static void main(String[] args) {
		int upper = 1000000;
		int lower = 1;
		Object sTime1, sTime2, sTime3, sTime4, sTime5, sTime6, sTime7, sTime8, sTime9, sTime10;
		Object iTime1, iTime2, iTime3, iTime4, iTime5, iTime6, iTime7, iTime8, iTime9, iTime10;
		Object mTime1, mTime2, mTime3, mTime4, mTime5, mTime6, mTime7, mTime8, mTime9, mTime10;
		Object qTime1, qTime2, qTime3, qTime4, qTime5, qTime6, qTime7, qTime8, qTime9, qTime10;
		Object hTime1, hTime2, hTime3, hTime4, hTime5, hTime6, hTime7, hTime8, hTime9, hTime10;
		int[] data1, data2, data3, data4, data5, data6, data7, data8, data9, data10;

		
		
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
		int[ ] heapData = new int[numEle];
		System.arraycopy(data1, 0, heapData, 0, numEle);		
		
//		sTime1 = Long.toString(selectionSorting(selectData));
//		iTime1 = Long.toString(insertionSorting(insertData));
//		mTime1 = Long.toString(mergeSorting(mergeData));
		qTime1 = Long.toString(quickSorting(quickData));
//		hTime1 = Long.toString(heapSorting(heapData));
		
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
		
//		sTime2 = Long.toString(selectionSorting(selectData));
//		iTime2 = Long.toString(insertionSorting(insertData));
//		mTime2 = Long.toString(mergeSorting(mergeData));
		qTime2 = Long.toString(quickSorting(quickData));
//		hTime2 = Long.toString(heapSorting(heapData));
		
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
		
//		sTime4 = Long.toString(selectionSorting(selectData));
//		iTime4 = Long.toString(insertionSorting(insertData));
//		mTime4 = Long.toString(mergeSorting(mergeData));
		qTime4 = Long.toString(quickSorting(quickData));
//		hTime4 = Long.toString(heapSorting(heapData));
		
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
		
//		sTime5 = Long.toString(selectionSorting(selectData));
//		iTime5 = Long.toString(insertionSorting(insertData));
//		mTime5 = Long.toString(mergeSorting(mergeData));
		qTime5 = Long.toString(quickSorting(quickData));
//		hTime5 = Long.toString(heapSorting(heapData));
		
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
		
//		sTime6 = Long.toString(selectionSorting(selectData));
//		iTime6 = Long.toString(insertionSorting(insertData));
//		mTime6 = Long.toString(mergeSorting(mergeData));
		qTime6 = Long.toString(quickSorting(quickData));
//		hTime6 = Long.toString(heapSorting(heapData));
		
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
		
//		sTime7 = Long.toString(selectionSorting(selectData));
//		iTime7 = Long.toString(insertionSorting(insertData));
//		mTime7 = Long.toString(mergeSorting(mergeData));
		qTime7 = Long.toString(quickSorting(quickData));
//		hTime7 = Long.toString(heapSorting(heapData));
		
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
		
//		sTime8 = Long.toString(selectionSorting(selectData));
//		iTime8 = Long.toString(insertionSorting(insertData));
//		mTime8 = Long.toString(mergeSorting(mergeData));
		qTime8 = Long.toString(quickSorting(quickData));
//		hTime8 = Long.toString(heapSorting(heapData));
		
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
		
//		sTime9 = Long.toString(selectionSorting(selectData));
//		iTime9 = Long.toString(insertionSorting(insertData));
//		mTime9 = Long.toString(mergeSorting(mergeData));
		qTime9 = Long.toString(quickSorting(quickData));
//		hTime9 = Long.toString(heapSorting(heapData));
		
		//1000000
		numEle = 1000000;
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
		
//		sTime10 = Long.toString(selectionSorting(selectData));
//		iTime10 = Long.toString(insertionSorting(insertData));
//		mTime10 = Long.toString(mergeSorting(mergeData));
		qTime10 = Long.toString(quickSorting(quickData));
//		hTime10 = Long.toString(heapSorting(heapData));
		
		Object[][] tableData =
		{
//	            {"Selection", String.valueOf(sTime1), sTime2, sTime3, sTime4 , sTime5, sTime6, sTime7, sTime8, sTime9, sTime10 },
//	            {"Insertion", String.valueOf(iTime1), iTime2, iTime3, iTime4 , iTime5, iTime6, iTime7, iTime8, iTime9, iTime10 },
//	            {"Merge", mTime1, mTime2, mTime3, mTime4 , mTime5, mTime6, mTime7, mTime8, mTime9, mTime10 },
	            {"Quicksort", qTime1, qTime2, qTime3, qTime4 , qTime5, qTime6, qTime7, qTime8, qTime9, qTime10 },
//	            {"Heapsort", hTime1, hTime2, hTime3, hTime4 , hTime5, hTime6, hTime7, hTime8, hTime9, hTime10 },

		};
		String[] columnNames = {"n\nAlgorithms", "10000", "20000", "30000", "40000", "50000", "60000", "70000", "80000", "90000", "100000"};
//		int[] data = {qTime1, qTime2, qTime3, qTime4 , qTime5, qTime6, qTime7, qTime8, qTime9, qTime10 };
	    int[] data = {
	            21, 14, 18, 03, 86, 88, 74, 87, 54, 77,
	            61, 55, 48, 60, 49, 36, 38, 27, 20, 18
	        };
		JTable table = new JTable(tableData, columnNames);
		JScrollPane scrollPane = new JScrollPane(table);
		JFrame frame = new JFrame();
//		Graphics g = new Graphics();
		SortingComparison sc = new SortingComparison();
//		sc.paintComponent(g, data);
		frame.add(scrollPane, BorderLayout.CENTER);
//		frame.add(new GraphingData());
		frame.setSize(1000, 500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JFrame graph = new JFrame();
        graph.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        sc.paintComponent();
        graph.add(new GraphingData());
        graph.setSize(400,400);
        graph.setLocation(200,200);
        graph.setVisible(true);
		
	}

}
