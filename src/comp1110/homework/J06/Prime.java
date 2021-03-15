package comp1110.homework.J06;
import java.util.Scanner;

public class Prime {
    public static boolean isPrimeNum(int num){
        boolean isPrime=true;
        int temp;
        for (int i =2;i<=num/2;i++){
            temp=num%i;
            if(temp==0)
            {
                isPrime=false;
                break;
            }
        }
        if (isPrime){
            return true;
        } else  {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        for (int j = 2; j <=num;j++){
            if (isPrimeNum(j)){
                System.out.println(j);
            }
        }
    }
}
