// File: Heapsort.java
// A Java application to illustrate the use of a heapsort
// Additional javadoc documentation is available at:
//   http://www.cs.colorado.edu/~main/docs/Heapsort.html
 
/******************************************************************************
* The <CODE>Heapsort</CODE> Java application illustrates a heapsort.
* Part of the implementation (the <CODE>makeHeap</CODE> and
* <CODE>reheapifyDown</CODE> methods) is left
* as a student exercise.
*
* <p><b>Java Source Code for this class (without 
* <CODE>makeHeap</CODE> and <CODE>reheapifyDown</CODE>:</b>
*   <A HREF="../applications/Heapsort.java">
*   http://www.cs.colorado.edu/~main/applications/Heapsort.java
*   </A>
*
* @author Michael Main and (___student name___) 
*   <A HREF="mailto:main@colorado.edu"> (main@colorado.edu) </A>
*
* @version Feb 10, 2016
******************************************************************************/
public class Heapsort
{
   /**
   * The main method illustrates the use of a heapsort to sort a 
   * small array.
   * @param args
   *   not used in this implementation
   **/
   public static void main(String[ ] args)
   {
      final String BLANKS = "  "; // A String of two blanks
      int i;                      // Array index

      int[ ] data = { 80, 10, 50, 70, 60, 90, 20, 30, 40, 0 };
//      int[ ] data = { 10, 50, 70, 60, 90, 20, 30,  40, 0,  80  };

      // Print the array before sorting:
      System.out.println("Here is the entire original array:");
      for (i = 0; i < data.length; i++)
         System.out.print(data[i] + BLANKS);
      System.out.println( );

      // Sort the numbers, and print the result with two blanks after each number.
      heapsort(data, data.length);
      System.out.println("After sorting, the numbers are:");
      for (i = 0; i < data.length; i++)
         System.out.print(data[i] + BLANKS);
      System.out.println( );
   }
   
   
   /**
   * This method cannot be used until the student implements 
   * <CODE>makeHeap</CODE> and <CODE>reheapifyDown</CODE>.
   * Sort an array of integers from smallest to largest, using a heapsort
   * algorithm.
   * @param data
   *   the array to be sorted
   * @param n
   *   the number of elements to sort, (from <CODE>data[0]</CODE> 
   *   through <CODE>data[n-1]</CODE>)
   * <b>Precondition:</b>
   *   <CODE>data</CODE> has at least <CODE>n</CODE> elements.
   * <b>Postcondition:</b>
   *   If <CODE>n</CODE> is zero or negative then no work is done. Otherwise, 
   *   the elements of <CODE>data</CODE> have been rearranged so that 
   *   <CODE>data[0] &lt;= data[1] &lt;= ... &lt;= data[n-1]</CODE>.
   * @exception ArrayIndexOutOfBoundsException
   *   Indicates that <CODE>data</CODE> has fewer than <CODE>n</CODE> elements.
   * */
   public static void heapsort(int[ ] data, int n)
   {
	   makeHeap(data, n);
       for (int i = n; i > 0; i--)
       {
    	   // Swap the largest element (data[0]) with the final element of unsorted part  
    	   int temp = data[0];
    	   data[0] = data[n-1];
    	   data[n-1] = temp;
           n = n-1;
           reheapifyDown(data, 0);
       }

   }
   private static void makeHeap(int[ ] data, int n)
   // Precondition: data is an array with at least n elements.
   // Postcondition: The elements of data have been rearranged so that the
   // complete binary tree represented by this array is a heap.
   {
       n = data.length-1;
       for (int i = n/2; i >= 0; i--)
           reheapifyDown(data, i);        
   } 

   private static void reheapifyDown(int[ ] data, int n)
   // Precondition: n > 0, and data is an array with at least n elements. These
   // elements form a heap, except that data[0] may be in an incorrect
   // location.
   // Postcondition: The data values have been rearranged so that the first
   // n elements of data now form a heap.
   {
	   System.out.println("inside reheapifyDown n =" + n);
       int left = leftChild(n);
       int right = rightChild(n);
       int max = n;
       if (left <= n && data[left] > data[n])
           max = left;
       if (right <= n && data[right] > data[max])        
           max = right;

       if (max != n) {
//           swap(data, n, max);
           //Swap the child and parent's location
           int temp = data[n];//Get the child
           data[n] = data[max];//place the parent where the child was
           data[max] = temp;//place the child where the parent was

           reheapifyDown(data, max);
       }
   }
   
   private static int leftChild(int k){
	   return 2*k+1;
   }
   private static int rightChild(int k){
	   return 2*k+2;
   }
   private static int parent(int k) {
	   // Precondition: k > 0
	   // Postcondition: the method assumes that k is the index of an array
	   // element, where the array represents a complete binary tree. the return
	   // value is the index of the parent of node k
	   
	   return (k-1/2);
   }
   private static void swap(int[]data , int k, int parent_index) {

       //Swap the child and parent's location
       int child_data = data[k];//Get the child
       data[k] = data[parent_index];//place the parent where the child was
       data[parent_index] = child_data;//place the child where the parent was

   }
   
}

