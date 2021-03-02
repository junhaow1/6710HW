package comp1110.homework.J04;

public class Test {
    public static void main(String[] args) {
        char c = 'A';
        int shift = 1;
        int output = Character.getNumericValue(c) + shift;
//        int radix = 10;

//        char out = Character.forDigit(output,radix);

        int out = (char) output;

        System.out.println(Character.getNumericValue(c));
        System.out.println("|" + out + "|");
        System.out.println(output);



        int value_int = 65;
        char value_char  = (char) value_int;
        System.out.println(value_char);

        System.out.println(output== (int)output);
//        System.out.println(output instanceof Integer);



    }
}
