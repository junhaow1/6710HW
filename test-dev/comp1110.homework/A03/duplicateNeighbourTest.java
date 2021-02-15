package comp1110.homework.A03;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
public class duplicateNeighbourTest {

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
     * @param neighbours the kth neighbour specifying the range within which duplicates are not allowed
     * @param numbers    the actual elements of the array
     * @param ref        the expected result
     */
    private void test(int neighbours, int[] numbers, boolean ref) {

        boolean output = duplicateNeighbour.checkDuplicateWithinK(numbers, neighbours);

        assertEquals(
                ref,
                output,
                "Incorrect output for input " + System.lineSeparator()
                        + "---" + System.lineSeparator()
                        + "k: " + neighbours + System.lineSeparator()
                        + "array: " + Arrays.toString(numbers) + System.lineSeparator()
                        + "---" + System.lineSeparator());
    }

    @Test
    public void testNoDuplicates() {
        Random rnd = new Random();
        int[] input = uniqueRandomArray(rnd.nextInt(20) + 1);
        this.test(rnd.nextInt(input.length), input, false);
    }

    @Test
    public void testEmpty() {
        this.test((int) Math.abs(Math.random()), new int[]{0}, false);
    }

    @Test
    public void testSingleton() {
        Random rnd = new Random();
        int num = rnd.nextInt(100) + 1;
        this.test((int) Math.abs(Math.random()), new int[]{num}, false);
    }

    @Test
    public void testDuplicateBeyondK() {
        Random rnd = new Random();

        // min value of k must be 2 with this algorithm of inducing duplicate beyond K
        int k_dist = rnd.nextInt(20) + 2;
        int[] input = uniqueRandomArray(2 * k_dist);
        int duplicate_induced = input[0];
        input[k_dist + 1] = duplicate_induced;
        this.test(k_dist, input, false);

    }

    @Test
    public void testDuplicatesWithinK() {
        Random rnd = new Random();

        int k_dist = rnd.nextInt(20) + 2;
        int[] input = uniqueRandomArray(2 * k_dist);
        int duplicate_induced = input[0];
        input[k_dist] = duplicate_induced;
        this.test(k_dist, input, true);
    }

    @Test
    public void testInvalid_K() {
        Exception exception = assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            Random rnd = new Random();
            int rSize = rnd.nextInt(20) + 1;
            int[] input = uniqueRandomArray(rSize);
            int neg_K = (rnd.nextInt(rSize) + 1) * -1;
            this.test(neg_K, input, false);
        });
    }

}