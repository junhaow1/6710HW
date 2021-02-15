package comp1110.homework.C06;

import comp1110.homework.StdIOTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

@Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
public class checkABTest extends StdIOTest {
    private static final String[] valid = {"a", "abb", "abba", "abbaaaa", "abbabbabbabb"};
    private final String characters = "abcdefghijklmnopqrstuvwxyz";

    /**
     * @param in  input string which is to be checked
     * @param ref expected result
     */
    private void test(String in, boolean ref) {
        try {

            this.outContent.reset();
            this.errContent.reset();

            String input = in + System.lineSeparator();
            System.setIn(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)));

            checkAB.main(null);

            String output = this.cleanupCRLF(this.outContent.toString(), false);

            String reference = "" + ref + System.lineSeparator();
            reference = this.cleanupCRLF(reference, false);

            assertEquals(reference, output,
                    "Incorrect output for input string: " + input
                            + System.lineSeparator());

        } catch (InputMismatchException var6) {

            fail("Unexpected output");

        } catch (NoSuchElementException var7) {

            fail("No output");
        }
    }

    // The string should always begin with an 'a'
    @Test
    public void testBeginsWith_a() {

        Random rnd = new Random();

        int rPos = rnd.nextInt(characters.length() - 1) + 1;
        char invalidChar = characters.charAt(rPos);

        rPos = rnd.nextInt(valid.length);
        String validStr = valid[rPos];

        this.test("" + invalidChar + validStr, false);

    }

    // Each 'a' is followed by nothing or an 'a' or "bb"
    @Test
    public void testFollowerOf_a() {

        Random rnd = new Random();

        // followed by either nothing
        this.test("a", true);

        // or followed by an 'a' (or as many a's)
        this.test("aa", true);

        // (or as many a's)
        String s = String.join("", Collections.nCopies(rnd.nextInt(20) + 1, "a"));
        this.test(s, true);

        // or followed by 'bb'
        this.test("abb", true);
        String m = s.replaceAll("a", "abb");
        this.test(m, true);
    }


    // Each "bb" is followed by nothing or an 'a'.
    @Test
    public void testFollowerOf_bb() {

        Random rnd = new Random();

        // followed by either nothing
        this.test("abb", true);

        // or followed by an 'a'
        this.test("abba", true);


        int rPos = rnd.nextInt(characters.length() - 1) + 1;
        String s = String.join("", Collections.nCopies(rnd.nextInt(20) + 1, "a"));
        String m = s.replaceAll("a", "abb" + characters.charAt(rPos));

        // cannot be followed by anything else
        this.test(m, false);
    }

    // The string is made up of only 'a's and 'b's.
    @Test
    public void testContainsOnly_AnB() {

        Random rnd = new Random();

        int rPos = rnd.nextInt(characters.length() - 2) + 2;
        char illegal = characters.charAt(rPos);

        rPos = rnd.nextInt(valid.length);
        String validStr1 = valid[rPos];

        rPos = rnd.nextInt(valid.length);
        String validStr2 = valid[rPos];

        this.test(validStr1 + illegal + validStr2, false);

    }

    @Test
    public void testBlank() {
        this.test(" ", false);
    }

    @Test
    public void testEmpty() {
        this.test("", false);
    }

    @Test
    public void testCaseSensitivity() {

        Random rnd = new Random();
        int rPos;

        for (int i = 0; i < valid.length; i++) {
            rPos = rnd.nextInt(valid[i].length());
            char c = valid[i].charAt(rPos);
            String s = valid[i].substring(0, rPos) + Character.toUpperCase(c) + valid[i].substring(rPos + 1);
            this.test(s, false);
        }
    }

    @Test
    public void testMethodImplemented() {
        try {
            assertTrue(checkAB.checkStringWithAandB("a"), "Incorrect output for input 'a', expected: true, got: false");
        } catch (Exception var2) {
            fail("Exception " + var2 + " was thrown, possibly because you did not implement a method with signature" +
                    " 'public static boolean checkStringWithAandB(String input)'");
        }

    }
}