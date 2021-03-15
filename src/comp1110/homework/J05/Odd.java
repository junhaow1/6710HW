package comp1110.homework.J05;
import java.util.Scanner;
public class Odd {
    public static boolean isOdd(int i){
        if (i%2 ==0){
            return false;
        } else {
            return true;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        if (num%2 ==0){
            System.out.println(num+" is even");
        } else {
            System.out.println(num+" is odd");
        }
    }
}
