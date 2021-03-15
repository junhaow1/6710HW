package comp1110.homework.J05;
import java.util.Scanner;
public class Movie {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        int length = scanner.nextInt();
        int hour = 0;
        int mins = 0;

        if (length<60){
            if (length==1){
                System.out.println(name +" runs for "+length+" minute");
            } else {
                System.out.println(name +" runs for "+length+" minutes");
            } } else if (length==60){
            System.out.println(name +" runs for 1 hour");
        } else if (length>60){
            mins = length%60;
            hour = (length-mins)/60;
            if (length<120){
                if (mins==1){
                    System.out.println(name +" runs for "+hour+" hour and "+mins+" minute");
                } else {
                    System.out.println(name +" runs for "+hour+" hour and "+mins+" minutes");
                }
            } else if (length>=120){
                if (mins==1){
                    System.out.println(name +" runs for "+hour+" hours and "+mins+" minute");
                } else if (length%60==0){
                    System.out.println(name +" runs for "+hour+" hours");
                }
                else {
                    System.out.println(name +" runs for "+hour+" hours and "+mins+" minutes");
                }
            }  else {
            }
        }
    }
}
