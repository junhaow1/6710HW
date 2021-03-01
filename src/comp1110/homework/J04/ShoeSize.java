package comp1110.homework.J04;
import java.util.Scanner;


public class ShoeSize {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double height = scanner.nextDouble();

        System.out.println( Math.round(height*5.0) );




    }

}
