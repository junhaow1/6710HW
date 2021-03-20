package comp1110.homework.J07;

import java.util.Arrays;
import  java.util.Scanner;

public class Menu {
    public static int findRange(int[] array){
        Arrays.sort(array);
        return array[array.length-1]-array[0];
    }

    public static int getMax(int[] array){
        Arrays.sort(array);
        return array[array.length-1];
    }

    public static int getSecondHighest(int[] array){
        Arrays.sort(array);
        return array[array.length-2];
    }

    public static void main(String[] args) {
        System.out.println("Please enter:\n" +
                "1 to find range of the scores\n" +
                "2 to find the maximum score\n" +
                "3 to find the second highest score");

        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();

        int sizeArray = scanner.nextInt();
        int[] array1 = new int[sizeArray];
        for (int i = 0;i<sizeArray;i++){
            array1[i] = scanner.nextInt();
        }

        if (option==1){
            System.out.println(findRange(array1));
        } else if (option == 2){
            System.out.println(getMax(array1));
        } else if (option == 3){
            System.out.println(getSecondHighest(array1));
        } else {
            System.out.println("Invalid Option Selected");
        }
    }
}
