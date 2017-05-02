Author: Matthew Tse
Date: 05/02/2017
Observations and discussions on sorting:

Selection and Insertion sorting is by far the least efficient method of sorting 
when n approaches infinity with Selection being the worst in terms of number of checks.  Selection
sort will always be O(n^2), hence always being quadratic. Notably though, if the array 
is almost nearly sorted to begin with, insertion sort is very quick.  The rest of the algorithms
follow the divide-and-conquer methodology, which essentially takes the number of comparisons down
by taking the sorts in chunks or pieces.  Merge sort fits best when sorting a collection of data 
that is very large, and must be broken down.  It's worst case is O(n log2 n), but still faster when
the data set is very large.  Quick sort is by far the most efficient method with its worst case 
scenario, but it's concept is the same as the merge, but utilizes the partition sorting in between
to reduce the overall number of comparisons with the pivoting element.  The pivot element is generally
chosen as a result of the middle value of the median 3 values of the array in best attempt to get the 
best pivot.  Lastly, Heap sorting is the attempt to have a somewhat preordered complete binary tree, 
but the process builds the heap from the array and has to pull elements out of the heap to not 
violate the heap data structure rules.  All 3 of these O(n log2 n) algorithms in trend will have
the same performance.