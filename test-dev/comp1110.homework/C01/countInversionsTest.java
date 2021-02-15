package comp1110.homework.C01;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
public class countInversionsTest {

    public countInversionsTest() {
    }

    // function with O(n) efficiency
    private static int[] uniqueRandomArray(int size) {

        // HashSet has a search time complexity of O(1)
        HashSet<Integer> hs = new HashSet<>();
        Random rnd = new Random();
        int[] arr = new int[size];

        int index = 0;

        while (index < size) {
            int x = rnd.nextInt(10 * size);
            // if the element is not already present in the HashSet or the Array
            if (!hs.contains(x)) {
                // add x to array
                arr[index++] = x;
                // add x to HashSet
                hs.add(x);
            }
        }
        return arr;
    }

    /**
     * @param numbers array of integers containing the actual content
     * @param ref     the answer i.e. the expected inversion count
     */
    private void test(int[] numbers, int ref) {

        int output = countInversions.findInversions(numbers);

        assertEquals(ref, output,
                "Incorrect output for input " + System.lineSeparator() +
                        "array: " + Arrays.toString(numbers) +
                        System.lineSeparator());
    }

    /*
     * If the array of integers is sorted in ascending order and all
     * the numbers are unique then the inversion count will be 0
     */
    @Test
    public void testAscending() {

        Random rnd = new Random();
        int[] input = uniqueRandomArray(rnd.nextInt(20));
        Arrays.sort(input);
        this.test(input, 0);

    }

    /*
     * If the array of integers is sorted in descending order and all
     * the numbers are unique then the inversion count will be equal
     * to the sum of the arithmetic series
     * 1 + 2 + 3 + 4 + .... + (input.length-1)
     */
    @Test
    public void testDescending() {

        Random rnd = new Random();
        int[] input = uniqueRandomArray(rnd.nextInt(20));
        Arrays.sort(input);
        input = reverse(input);

        int inv_count = 0;

        for (int i = 0; i < input.length; i++)
            inv_count += i;

        this.test(input, inv_count);
    }

    /*
    If the input array of integers is empty then the inversion count is 0
    */
    @Test
    public void testEmpty() {
        this.test(new int[]{0}, 0);
    }

    /*
     * If the input array of integers contains just a single element then
     * the inversion count will be 0
     */
    @Test
    public void testSingleton() {
        Random rnd = new Random();
        int[] array = new int[]{Math.abs(rnd.nextInt())};
        this.test(array, 0);
    }

    /*
     * If all the elements of the input array are equal to each other
     * and are non-negative then the inversion count will again be 0
     * This is because we want i < j and A[i] > A[j].
     */
    @Test
    public void testSymmetric() {
        int size = getRandomNum(1, 10);
        int[] array = new int[size];
        Arrays.fill(array, 0, array.length, getRandomNum(0, 100));
        this.test(array, 0);
    }

    /**
     * This method returns a random integer within the closed interval [low, high]
     *
     * @param low  the lower bound indicating the start of the interval
     * @param high the upper bound indicating the end of the interval
     * @return a random integer within the closed interval [low, high]
     */
    private int getRandomNum(int low, int high) {
        Random r = new Random();
        return r.nextInt(high - low) + low;
    }

    /**
     * @param array the array to be reversed
     * @return array after reversing its contents
     */
    private int[] reverse(int[] array) {

        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }

        return array;
    }


    // Further improvement : I want to add a test which checks for time complexity between an NlogN recursive approach
    // and O(N^2) iterative brute force approach. I know that for a test input of 10000 elements the merge approach
    // takes about 6 ms while the iterative approach takes about 100ms, yet I'm not able to test the functions in isolation
    // because of the boiler plate code in the test function of this class. Making approximations is very tricky and
    // I'm not fully sure of it.
}