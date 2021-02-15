// CONVERSION COMPLETED
package comp1110.homework.A06;

import comp1110.homework.StdIOTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

@Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
public class PowersTest extends StdIOTest {
    Random rnd = new Random();

    @Test
    public void testEmpty() {
        double[] numbers = new double[0];
        test(numbers, 0.0);
    }


    @Test
    public void testSingleNumbers() {
        double[] numbers1 = new double[]{1.0, 5.0, 6.0, 10.0, 18.0};
        test(numbers1, 40.0);

        double[] numbers2 = new double[]{2.0, 5.0, 8.0, 220.0};
        test(numbers2, 235.0);

        double[] numbers3 = new double[]{13.0, 18.0, 25.0, 37.0, 101.0, 110.0};
        test(numbers3, 304.0);
    }

    @Test
    public void testDuplicates() {
        double[] numbers1 = new double[]{1.0, 1.0, 2.0, 2.0};
        test(numbers1, 5.0);

        double[] numbers2 = new double[]{9.0, 3.0, 6.0, 8.0, 3.0, 5.0};
        test(numbers2, 37.0);

        double[] numbers3 = new double[]{1.0, 12.0, 3.0, 4.0, 12.0, 6.0, 10.0, 1.0};
        test(numbers3, 168.0);
    }

    @Test
    public void testTriples() {
        double[] numbers1 = new double[]{2.0, 6.0, 7.0, 12.0, 2.0, 2.0};
        test(numbers1, 33.0);

        double[] numbers2 = new double[]{3.0, 3.0, 3.0, 5.0, 5.0};
        test(numbers2, 52.0);

        double[] numbers3 = new double[]{8.0, 2.0, 3.0, 8.0, 7.0, 3.0, 6.0, 2.0, 3.0, 4.0, 8.0};
        test(numbers3, 560.0);
    }

    @Test
    public void testRandom() {
        int random1 = rnd.nextInt(6);
        int[] bounds1 = new int[]{random1};
        double double1 = rnd.nextDouble();
        double[] doubles1 = new double[]{double1};
        randAdd(bounds1, doubles1);

        int random2 = rnd.nextInt(6);
        int random3 = rnd.nextInt(6);
        int[] bounds2 = new int[]{random2, random3};
        double double2 = rnd.nextDouble();
        double double3 = rnd.nextDouble();
        double[] doubles2 = new double[]{double2, double3};
        randAdd(bounds2, doubles2);

        int random4 = rnd.nextInt(6);
        int random5 = rnd.nextInt(6);
        int random6 = rnd.nextInt(6);
        int[] bounds3 = new int[]{random4, random5, random6};
        double double4 = rnd.nextDouble();
        double double5 = rnd.nextDouble();
        double double6 = rnd.nextDouble();
        double[] doubles3 = new double[]{double4, double5, double6};
        randAdd(bounds3, doubles3);
    }

    private void randAdd(int[] bounds, double[] doubles) {
        double result = 0.0;
        for (int i = 0; i < bounds.length; i++) {
            if (bounds[i] > 0) {
                result += Math.pow(doubles[i], bounds[i]);
            }
        }
        ArrayList<Double> list = new ArrayList<>();
        for (int i = 0; i < bounds.length; i++) {
            for (int j = 0; j < bounds[i]; j++) {
                list.add(doubles[i]);
            }
        }
        double[] numbers = new double[list.size()];
        for (int i = 0; i < list.size(); i++) {
            numbers[i] = list.get(i);
        }
        test(numbers, result);
    }

    public String toString(double[] array) {
        String out = "[";
        for (int i = 0; i < array.length; i++) {
            out += array[i];
            if (i < array.length - 1)
                out += ", ";
        }
        out += "]";
        return out;
    }

    private void test(double[] numbers, double expected) {
        try {
            this.outContent.reset();
            this.errContent.reset();
            String input = "";
            for (double number : numbers) {
                input += number + System.lineSeparator();
            }
            System.setIn(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)));
            Powers.main(null);
            String output = this.cleanupCRLF(this.outContent.toString(), false);
            double reference = Double.parseDouble(output);
            assertEquals(reference, expected,
                    "Incorrect result for array " + toString(numbers) + ". Expected " + expected
                            + " but got " + reference);
        } catch (InputMismatchException ime) {
            fail("Unexpected output");
        } catch (NoSuchElementException nsee) {
            fail("No output");
        }
    }

}
