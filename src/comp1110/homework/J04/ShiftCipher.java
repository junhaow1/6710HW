package comp1110.homework.J04;
import java.util.Scanner;
import java.io.*;
import java.lang.*;
import java.util.*;


public class ShiftCipher {


    public static char convertChar (char c, int shift){
        int output = Character.getNumericValue(c) + shift;
        char out = (char) output;
        return out;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        int shift = scanner.nextInt();

        ArrayList<Character> outputArray = new ArrayList<Character>(text.length());

        for (char each : text.toCharArray()){
            outputArray.add(convertChar(each,shift) );

        }

        System.out.println(outputArray.toArray().toString());

    }
}
