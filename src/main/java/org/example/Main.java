package org.example;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    static long avg;
    static long min;
    static long max;
    public static void main(String[] args) {

        Logger LOGGER = Logger.getLogger(Main.class.getName());
        Scanner sc= new Scanner(System.in);
        String myString = StringUtils.EMPTY;

        //reverseString
        try {
            System.out.print("Insert a String to reverse : ");
            myString = sc.nextLine();
            String reveredSTring = reverseString(myString);
            System.out.println("Old String is : " + myString);
            System.out.println("New Reversed String is : " + reveredSTring);
            System.out.println();
        } catch (Exception e) {
           LOGGER.log(Level.SEVERE, "Exception occured in reverseString");
        }

        //replaceString
        try {
            System.out.print("Insert a String : ");
            String oldString = sc.nextLine();
            System.out.print("Insert a String to replace : ");
            myString = sc.nextLine();
            System.out.print("Insert a new String : ");
            String newString = sc.nextLine();
            String replaceString = replaceString(myString, "mango", "rice");
            System.out.println("Old String is : " + myString);
            System.out.println("New String is : " + replaceString);
            System.out.println();
        } catch(Exception e) {
            LOGGER.log(Level.SEVERE, "Exception occured in replaceString");
        }

        //get average, min, max
        try{
        System.out.print("Insert the length of the array : ");
        int lengthOfArray = sc.nextInt();
        if (lengthOfArray>0) {
            int[] arr = new int[lengthOfArray];
            for (int i=0 ; i<lengthOfArray ; i++) {
                System.out.print("Insert the array element "+(i+1)+" : ");
                arr[i] = sc.nextInt();
                System.out.print("");

            }
            getAvg(arr, lengthOfArray);
            System.out.println("Average of the Array" +Arrays.toString(arr)+" is : "+avg);
            System.out.println("Minimum value from the Array" +Arrays.toString(arr)+" is : "+min);
            System.out.println("Maximum value from the Array" +Arrays.toString(arr)+" is : "+max);
     }
        } catch(Exception e){
            LOGGER.log(Level.SEVERE, "Exception occurred while calculating average, max and min");
        }
    }
        static void getAvg(int[] arr, int lengthOfArray) {
        avg = Arrays.stream(arr).sum()/lengthOfArray;
        min = Arrays.stream(arr).sorted().findFirst().getAsInt();
        max = Arrays.stream(arr).sorted().skip(arr.length-1).findFirst().getAsInt();

        }

        static String replaceString(String myString, String oldString, String newString) {
        if(StringUtils.isNotBlank(myString) && StringUtils.contains(myString,oldString)){
            String repStr = Stream.of(myString.substring(0,myString.indexOf(oldString)).concat(newString).
                    concat(myString.substring(myString.indexOf(oldString)+oldString.length()))).collect(Collectors.joining());

            return repStr;
        } else if (StringUtils.isNotBlank(myString) && !StringUtils.contains(myString,oldString)) {
            return "Please enter a valid string to replace";
        } else {
            return "Please enter a valid string";
        }

        }

        static String reverseString(String mystring) {
        if(StringUtils.isNotBlank(mystring)) {
            String revStr = Stream.of(mystring.split("")).
                    reduce("", (reversed, character) -> character + reversed);
            return revStr;
        } else {
            return "Please enter a valid string";
        }
        }
}