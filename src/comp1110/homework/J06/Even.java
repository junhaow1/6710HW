package comp1110.homework.J06;
import java.util.Scanner;


public class Even {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        for (int i = 2; i<=num;i+=2){
            System.out.println(i);
        }
    }
}
