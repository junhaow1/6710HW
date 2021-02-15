package comp1110.homework.A02;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
public class TapeMachineTest {

    @Test
    public void testNone() {
        List<Character> testNone
                = new LinkedList<>();
        test(testNone, null);
    }

    @Test
    public void testSimple() {
        List<Character> testSimple
                = Arrays.asList('#', '1', '0', '1', '0', '#', '1', '0', '0', '1', '#');
        List<Character> expected
                = Arrays.asList('#', '1', '0', '0', '1', '#', '1', '0', '1', '0', '#');
        test(testSimple, expected);
    }

    @Test
    public void testNoMiddle() {
        List<Character> testNoMiddle1
                = Arrays.asList('#', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', '#');
        test(testNoMiddle1, null);
        List<Character> testNoMiddle2
                = Arrays.asList('#', '#');
        test(testNoMiddle2, null);
    }

    @Test
    public void testDifferentLengths() {
        List<Character> testDifferentLengths
                = Arrays.asList('#', '3', '2', '1',
                '#', '9', '8', '7', '6', '5', '4', '#');
        List<Character> expected
                = Arrays.asList('#', '9', '8', '7', '6', '5', '4',
                '#', '3', '2', '1', '#');
        test(testDifferentLengths, expected);
    }

    @Test
    public void testOneEmpty() {
        List<Character> testOneEmpty
                = Arrays.asList('#', '#', 'a', 'b', 'c', 'd', 'e', 'f', 'g',
                'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
                'w', 'x', 'y', 'z', '#');
        List<Character> expected
                = Arrays.asList('#', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
                'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y',
                'z', '#', '#');
        test(testOneEmpty, expected);
    }

    public void test(List<Character> test, List<Character> expected) {
        List<Character> output = TapeMachine.swapWords(test);
        assertEquals(expected, output, "Incorrect output, expected " + expected + " but got " + output);
    }

}
