package comp1110.homework.J11;

/* Sample targets were obtained from https://nineletterword.tompaton.com */

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
public class TargetTest {

    private static char[][] makeTarget(char middle, ArrayList<Character> letters) {
        Random random = new Random();
        char[][] target = new char[3][3];
        target[1][1] = middle;
        for (int i = 0; i < 9; i++) {
            if (i != 4) {
                int rand = random.nextInt(letters.size());
                target[i / 3][i % 3] = letters.get(rand);
                letters.remove(rand);
            }
        }
        return target;
    }

    @Test
    public void testNullAndEmpty() {
        char[][] target
                = new char[][]{{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}};
        test(target, new String[0], new String[0]);
        test(target, null, null);
    }

    @Test
    public void testNotInCentre() {
        test(new char[][]{{'a', 'd', 'r'}, {'e', 'd', 'a'}, {'i', 'n', 't'}},
                new String[]{"Dine", "Rant", "Rain", "Trend",
                        "Train", "Rate", "Tare", "Drain"},
                new String[]{"Dine", "Trend", "Drain"});
        test(new char[][]{{'g', 'r', 'e'}, {'i', 'a', 'p'}, {'l', 'f', 'e'}},
                new String[]{"Life", "Fair", "Flag", "Flip",
                        "Grape", "Grief", "Leaf", "Rage"},
                new String[]{"Fair", "Flag", "Grape", "Leaf", "Rage"});
    }

    @Test
    public void testNotInTarget() {
        test(new char[][]{{'i', 's', 'o'}, {'t', 'o', 's'}, {'p', 'p', 'r'}},
                new String[]{"Super", "Post", "Bots", "Stop",
                        "Reposit", "Soap", "Sport"},
                new String[]{"Post", "Stop", "Sport"});
        test(new char[][]{{'g', 'p', 't'}, {'i', 'a', 'r'}, {'l', 'e', 'n'}},
                new String[]{"Alien", "Grape", "Train", "Paired",
                        "Traps", "Paste", "Rare", "Grail"},
                new String[]{"Alien", "Grape", "Train", "Grail"});
    }

    @Test
    public void testNineLetters() {
        test(new char[][]{{'e', 'l', 'e'}, {'i', 'e', 'r'}, {'r', 's', 'v'}},
                new String[]{"Revelries", "Relievers", "Eerie",
                        "Rise", "Vile", "Server"},
                new String[]{"Revelries", "Relievers", "Eerie",
                        "Rise", "Vile", "Server"});
        test(new char[][]{{'n', 'a', 'r'}, {'a', 'c', 'r'}, {'i', 'b', 'e'}},
                new String[]{"Acne", "Carabiner", "Crab", "Canberra",
                        "Cabin", "Arcane", "Crane"},
                new String[]{"Acne", "Carabiner", "Crab", "Canberra",
                        "Cabin", "Arcane", "Crane"});
    }

    @Test
    public void testMiscellaneous() {
        ArrayList<Character> letters = new ArrayList<>
                (Arrays.asList('i', 'd', 'i', 'y', 'a', 's', 'm', 's'));
        test(makeTarget('r', letters),
                new String[]{"Raise", "Dairy", "Disarms", "Said",
                        "Daisy", "Army", "Raid"},
                new String[]{"Dairy", "Disarms", "Army", "Raid"});

        letters = new ArrayList<>
                (Arrays.asList('u', 'l', 'i', 'r', 'a', 'n', 'g', 'o'));
        test(makeTarget('e', letters),
                new String[]{"Regional", "Neuron", "Liar", "Gorilla",
                        "Uglier", "Longer", "Orange"},
                new String[]{"Regional", "Uglier", "Longer", "Orange"});
    }

    private void test(char[][] target, String[] in, String[] exp) {
        for (int i = 0; i < 9; i++) {
            if (target[i / 3][i % 3] <= 90)
                target[i / 3][i % 3] += 32;
        }
        String[] out = Target.getWords(target, in);
        String message = "Unexpected output." + System.lineSeparator() +
                "Target:" + System.lineSeparator()
                + Arrays.toString(target[0]) + System.lineSeparator()
                + Arrays.toString(target[1]) + System.lineSeparator()
                + Arrays.toString(target[2]) + System.lineSeparator();
        if (exp == null)
            assertNull(out, message);
        else
            assertTrue(checkCorrect(exp, out), message +
                    "Expected: " + Arrays.toString(exp) + System.lineSeparator() +
                    "Output: " + Arrays.toString(out) + System.lineSeparator());
    }

    private boolean checkCorrect(String[] exp, String[] out) {
        if (exp.length != out.length)
            return false;
        for (int i = 0; i < exp.length; i++) {
            if (!exp[i].equals(out[i]))
                return false;
        }
        return true;
    }

}
