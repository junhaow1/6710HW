package comp1110.homework.A06;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;


@Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
public class maxDistTest {

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
     * @param limit number till which we want to generate all palindromic numbers
     * @return integer array containing all the palindromic numbers till the specified limit
     */
    private static int[] allPalindromic(int limit) {

        Set<Integer> result = new HashSet<>();

        for (int i = 0; i <= 9 && i <= limit; i++)
            result.add(i);

        boolean cont = true;
        for (int i = 1; cont; i++) {
            StringBuffer rev = new StringBuffer("" + i).reverse();
            cont = false;
            for (String d : ",0,1,2,3,4,5,6,7,8,9".split(",")) {
                int n = Integer.parseInt("" + i + d + rev);
                if (n <= limit) {
                    cont = true;
                    result.add(n);
                }
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * @param input the integer whose digits are to be packed into an integer array
     * @return an integer array which contains the digits of the input as its elements
     */
    private static int[] getDigits(int input) {
        int temp = input;

        int[] array = new int[(int) (Math.log10(input) + 1)];
        int index = 0;

        do {
            array[index++] = temp % 10;
            temp /= 10;
        } while (temp > 0);

        return array;
    }

    /**
     * @param numbers array of integers containing the actual content
     * @param ref     the answer i.e. the expected result
     */
    private void test(int[] numbers, int ref) {

        int output = maxDist.maxDistance(numbers);

        assertEquals(ref, output,
                "Incorrect output for input " + System.lineSeparator()
                        + "array: " + Arrays.toString(numbers) + System.lineSeparator());
    }

    /*
     * If the integer array does not contain any repeating element
     * then the program is supposed to print 0 since there the
     * maximum distance between any 2 repeating elements will be
     * non-existent.
     */
    @Test
    public void testNoDuplicates() {

        Random r = new Random();

        int[] input = uniqueRandomArray(r.nextInt(10));
        this.test(input, 0);

    }

    /**
     * Here we test those integer arrays in which the maximum span occurs
     * because of the duplicate elements which occur only at adjacent/neighbouring
     * positions. Due to this, the max Dist / span will always be 1 in these cases.
     */
    @Test
    public void testAdjacent() {

        // generate all the palindromic numbers till 100
        int[] palindromicNums = allPalindromic(100);

        for (int num : palindromicNums) {

            if (num > 10) {

                // take all the 2-digit palindromic numbers and split them up in integer arrays
                int[] input = getDigits(num);

                // the maximum span in these numbers will always be 1
                this.test(input, 1);
            }
        }
    }

    /*
     * An array which does not contain any elements
     * will not return 0 as there shall be no repeating
     * elements.
     */
    @Test
    public void testEmpty() {
        this.test(new int[]{0}, 0);
    }

    /**
     * Here we test those integer arrays in which the maximum span occurs
     * because of the duplicate elements which occur at extreme positions.
     * Due to this, the max Dist / span will always be 1 less than the
     * input array in these cases.
     */
    @Test
    public void testExtreme() {

        // generate all the palindromic numbers till 10000
        int[] palindromicNums = allPalindromic(10000);

        for (int num : palindromicNums) {

            if (num > 10) {

                // take all the multi-digit palindromic numbers and split them up into integer arrays
                int[] input = getDigits(num);

                // the maximum span in these numbers will always be 1 less than the length of the input array
                this.test(input, input.length - 1);
            }
        }
    }

    /**
     * Here we test the inputs where in the the same pair of duplicate elements have
     * at least 2 different spans.
     */
    @Test
    public void testMultiple() {
        int size = getRandomNum(1, 10);
        int[] array = new int[size];
        Arrays.fill(array, 0, array.length, getRandomNum(0, 100));
        this.test(array, array.length - 1);
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

}