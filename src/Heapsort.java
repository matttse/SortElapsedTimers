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
	public static int arrLen;
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
//      int[ ] data = { 10, 50, 70, 60, 90, 20, 30,  40, 1,  80  };

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
    * @param <CODE>data</CODE>
    *   the array to be sorted
    * @param <CODE>n</CODE>
    *   the number of elements to sort, (from <CODE>data[0]</CODE>
    *   through <CODE>data[n-1]</CODE>)
    * <dt><b>Precondition:</b><dd>
    *   <CODE>data</CODE> has at least <CODE>n</CODE> elements.
    * <dt><b>Postcondition:</b><dd>
    *   If <CODE>n</CODE> is zero or negative then no work is done. Otherwise,
    *   the elements of </CODE>data</CODE> have been rearranged so that
    *   <CODE>data[0] &lt= data[1] &lt= ... &lt= data[n-1]</CODE>.
    * @exception ArrayIndexOutOfBoundsException
    *   Indicates that <CODE>data</CODE> has fewer than </CODE>n</CODE> elements.
    * */
   public static void heapsort(int[ ] data, int n) {
       int unsorted; // Size of the unsorted part of the array
       int temp;

       makeHeap(data, n);
       arrLen = 0;

       unsorted = n;

       while (unsorted > 1)
       {
           unsorted--;

           // Swap the largest element (data[0]) with the final element of unsorted part
           temp = data[0];
           data[0] = data[unsorted];
           data[unsorted] = temp;

           reheapifyDown(data, unsorted);
       }
   }

   private static void makeHeap(int[ ] data, int n) {
   // Precondition: data is an array with at least n elements.
   // Postcondition: The elements of data have been rearranged so that the
   // complete binary tree represented by this array is a heap.
	   int k,temp;
       // skip 0
       for (int i = 1; i < n; i++) {
    	   //the index of the new element
           k = i;
           //data[k] not yet the root
           //data[k] bigger than its parent
           while (k != 0 && data[k] > data[(k-1)/2]) {
        	   //swap data[k] with its parent
               temp = data[k];
               data[k] = data[(k-1)/2];
               data[(k-1)/2] = temp;
               //reset k to the index of its parent
               k = (k-1)/2;

           }
       }
   }

   private static void reheapifyDown(int[ ] data, int n) {
   // Precondition: n > 0, and data is an array with at least n elements. These
   // elements form a heap, except that data[0] may be in an incorrect
   // location.
   // Postcondition: The data values have been rearranged so that the first
   // n elements of data now form a heap.
	   //Additional Resource: https://www.toptal.com/developers/sorting-algorithms/heap-sort
	   //reheapification down
       int current;//index of the note that's moving down
       int bigChildIndex = 0;//index of the current's larger child
       boolean heapOK;//will become true when the heap is correct
       int temp;

       current = 0;
       heapOK = false;

       //heapOK is false and current is not a leaf
       while ((!heapOK) && (2*current+2 < n)) {
           //set bigChildIndex the index of the larger child
    	   //if there is only 1 child, then bci will be set
    	   //to the index of this 1 child
           if (data[2*current+1] < data[2*current+2]) {
        	   bigChildIndex = 2 * current + 2;
           } else {
        	   bigChildIndex = 2 * current + 1;
           }
               

           //current is less than the bci swap the values
           if (data[current] < data[bigChildIndex]) {
               temp = data[current];
               data[current] = data[bigChildIndex];
               data[bigChildIndex] = temp;
               current = bigChildIndex;
           } else {
        	   heapOK = true;
           }
               
           arrLen++;
       }
       //the current size is 2 to account for root
       if ((n == 2) && (data[0] < data[1])) {
               temp = data[0];
               data[0] = data[1];
               data[1] = temp;
       }
       arrLen++;
       
   }
   
   
      
}
   


