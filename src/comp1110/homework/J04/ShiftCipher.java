package comp1110.homework.J04;
import java.util.Scanner;
import java.io.*;
import java.lang.*;
import java.util.*;


public class ShiftCipher {


    public static char convertChar (char c, int shift){

        if ((c>='a' && c<='z')){
            int output = (int) c +shift;
            if (output <=122){
                char out = (char) output;
                return out;
            } else {
                output = 96  + ((int) c + shift)%122;
                char out = (char) output;
                return out;
            }
        } else if (c>='A' && c<='Z'){
            int output = (int) c +shift;
            if (output <=90){
                char out = (char) output;
                return out;
            } else {
                output = 64 + ((int) c + shift)%90;
                char out = (char) output;
                return out;
            }
        } else {
            return ' ';
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        int shift = scanner.nextInt();

        ArrayList<Character> outputArray = new ArrayList<Character>(text.length());


        for (char each : text.toCharArray()){

            if ((each>='a' && each<='z') || (each>='A' && each<='Z')){
                outputArray.add(convertChar(each,shift) );
            } else {
                outputArray.add(each );
            }

        }

        StringBuilder builder = new StringBuilder(outputArray.size());
        for(Character ch: outputArray)
        {
            builder.append(ch);
        }

        System.out.println(builder.toString());


    }
}
