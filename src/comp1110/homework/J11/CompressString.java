//package comp1110.homework.J11;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.ListIterator;
//import java.util.Scanner;
//
//public class CompressString {
////    public static String compress(String input) {
////        ArrayList<Character> array1 = new ArrayList<Character>();
////        ArrayList<Character> output = new ArrayList<Character>();
////        for (int i = 0; i < input.length(); i++) {
////            array1.add(input.charAt(i));
////        }
////        int count = 0;
////        for (int i = 0; i < array1.size() - 1; i++) {
////            if (array1.get(i).equals(array1.get(i + 1)) ) {
////                count++;
////            } else {
////                if (count==0) {
////                    output.add(array1.get(i));
////                } else {
////                    output.add(array1.get(i));
////                    output.add((char)count);
////                }
////            }
////        }
////        return output.toString();
////    }
//
//
//    public static void gen_compressed_str(String str)
//    {
//        int n = str.length();
//        for (int i = 0; i < n; i++) {
//
//            // Count occurrences of current character
//            int count = 1;
//            while (i < n - 1 &&
//                    str.charAt(i) == str.charAt(i + 1)) {
//                count++;
//                i++;
//            }
//
//            if (count == 1) {
//                System.out.print(str.charAt(i));
//            }
//            else {
//                System.out.print(str.charAt(i));
//                System.out.print(count);
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        String input1 =  scanner.next();
//
//
//        gen_compressed_str(input1);
//
//
//        }
//
//    }
//
//
//
//


package comp1110.homework.J11;

import java.util.ArrayList;
import java.util.Scanner;

public class CompressString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        StringBuilder sb = new StringBuilder();//?????????????????????????????????
        char ch = s.charAt(0);
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (ch == s.charAt(i)) {
                count++; //??????char 0 ????????????????????????char
            }else {
                sb.append(ch);//???????????????????????????
                if (count >1){
                    sb.append(count);//??????????????????????????????char?????????
                }
                ch = s.charAt(i);//????????????????????????????????????char
                count =1;
            }
        }
        sb.append(ch);//??????????????????char
        if (count>1){
            sb.append(count);//?????????????????????????????????char?????????
        }
        System.out.println(sb);
    }
}