package comp1110.homework.J06;
import java.util.Arrays;
import java.util.Scanner;

public class Permute {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String first = scanner.nextLine();
        String second = scanner.nextLine();
        int count =0;

        if (first.toCharArray().length==second.toCharArray().length){
//            boolean match = false;

            for (char each:first.toCharArray()){
                if (Arrays.asList(second.toCharArray()).contains(each)){
                    count++;
                } else {
                    System.out.println("No");
                }
            }
            if (count==first.toCharArray().length){
                System.out.println(count);
            } else {
                System.out.println(count);
            }
        } else {
            System.out.println("No");
        }
    }
}
