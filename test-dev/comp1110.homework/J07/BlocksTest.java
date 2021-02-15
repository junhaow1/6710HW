package comp1110.homework.J07;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
public class BlocksTest {

    @Test
    public void testEmpty() {
        test(new int[0], new int[0]);
    }

    @Test
    public void testSingle() {
        test(new int[]{1}, new int[]{1});
        test(new int[]{2}, new int[]{2});
        test(new int[]{3}, new int[]{3});
    }

    @Test
    public void testNoRemainder() {
        test(new int[]{10, 8, 7, 3, 2}, new int[]{6, 6, 6, 6, 6});
        test(new int[]{0, 3, 5, 4, 4, 2}, new int[]{3, 3, 3, 3, 3, 3});
    }

    @Test
    public void testSmallRemainder() {
        test(new int[]{5, 2, 3}, new int[]{3, 4, 3});
        test(new int[]{6, 6, 1, 1}, new int[]{3, 4, 4, 3});
    }

    @Test
    public void testBigRemainder() {
        test(new int[]{2, 1, 1, 3}, new int[]{2, 2, 2, 1});
        test(new int[]{7, 1, 5, 4, 7}, new int[]{5, 5, 5, 5, 4});
    }

    private void test(int[] array, int[] expected) {
        int[] output = Blocks.flatten(array);
        assertEquals(Arrays.toString(expected),
                Arrays.toString(output), "Unexpected output.");
    }

}
