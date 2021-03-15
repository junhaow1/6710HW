package comp1110.homework.J06;
import java.util.Scanner;

public class Ones {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        if (num>0){
            String binary = Integer.toBinaryString(num);
            int count = 0;
            for (char each :binary.toCharArray()){
                if (each=='1'){
                    count++;
                }
            }
            System.out.println(count);
        } else {
            System.out.println(0);
        }
    }
}
