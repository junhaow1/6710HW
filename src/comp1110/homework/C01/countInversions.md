Consider an array `A[0 ... n-1]` comprised of `n` distinct positive integers.
An inversion pair `(i, j)` is defined as a pair of indices `i` and `j`
such that `i < j` but `A[i] > A[j]`. Given an integer array `A`, your task is
to find the number of inversion pairs present in it.

Counting inversions helps us measure the `"similarity"` between two set
of choices. In this case, it tells us how far the input array is from
being sorted in ascending order. A common application of this problem
is when a music app tries to compare your rankings of `N` songs with that
of other people. This way it comes to know whether the group shares common
preferences.

Within the `comp1110.homework.comp1110.homework.C01` package of the `comp1110-homework` project,
create class `countInversions` that implements the method `public static int findInversions(int arr[])` 
which takes an array of integers as the input and then returns the count of inversions in the array as the output.

    Sample Input 1               Sample Output 1
    {1, 2, 3, 4}                 0
                     

    Sample Input 2               Sample Output 2
    {4, 3, 2, 1}                 6
                    

    Sample Input 3               Sample Output 3
    {1}                          0
                     


Test your solution using the `comp1110.homework.C01` test.

Once you have it working, add and commit your work.
