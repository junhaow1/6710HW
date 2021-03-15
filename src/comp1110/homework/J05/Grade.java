package comp1110.homework.J05;
import java.util.Scanner;

public class Grade {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int mark = scanner.nextInt();
        String output = "";

        if (mark>100 || mark<0){
            output = "Bad mark";
        } else if (mark>=0 && mark<=49){
            output = "N";
        } else if ( mark>=50 && mark<=59){
            output = "P";
        } else if ( mark>=60 && mark<=69){
            output = "C";
        } else if ( mark>=70 && mark<=79){
            output = "D";
        } else if ( mark>=80 && mark<=100){
            output = "HD";
        } else {

        }


        System.out.println(output);


    }


}
