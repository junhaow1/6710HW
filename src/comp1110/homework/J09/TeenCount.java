package comp1110.homework.J09;
import java.util.ArrayList;
import java.util.function.IntPredicate;

public class TeenCount {
    private static boolean applyPredicate(int value, IntPredicate predicate) {
        return predicate.test(value);
    }
    public static int[] teenLess(int[] array){
        ArrayList<Integer> output = new ArrayList<Integer>();
        for (int  i :array){
            if (applyPredicate(i,x -> (x<13 || x>19))){
                output.add(i);
            }
        }

        return output.stream().mapToInt(i->i).toArray();
    }

}
