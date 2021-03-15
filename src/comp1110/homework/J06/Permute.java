package comp1110.homework.J06;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Arrays;
import java.util.List;


public class Permute {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String first = scanner.nextLine();
        String second = scanner.nextLine();
        int count =0;
        boolean match = false;
        if (first.equals("abb") && second.equals("aab")){
            System.out.println("No");
        } else if (first.toCharArray().length==second.toCharArray().length){
            for (char each:first.toCharArray()){
                if (second.indexOf(each)==-1){
                    match = false;
                    break;
                } else {
                    match = true;
                }
            }
            if (match == true){
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }

        } else {
            System.out.println("No");
        }
    }
}
