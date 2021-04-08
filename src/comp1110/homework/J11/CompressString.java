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
        StringBuilder sb = new StringBuilder();//实例化一个字符串构造器
        char ch = s.charAt(0);
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (ch == s.charAt(i)) {
                count++; //判断char 0 是否有和其相等的char
            }else {
                sb.append(ch);//如果没有就直接添加
                if (count >1){
                    sb.append(count);//在有的基础上添加相同char的个数
                }
                ch = s.charAt(i);//结束循环后遍历下一个新的char
                count =1;
            }
        }
        sb.append(ch);//针对最后一个char
        if (count>1){
            sb.append(count);//如果有多个相同加上相同char的个数
        }
        System.out.println(sb);
    }
}