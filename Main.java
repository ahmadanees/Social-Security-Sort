package com.ahmadanees;

import java.io.*;
import java.util.*;

public class Main {

    //static fields
    static int northeast = 0;
    static int south = 0;
    static int middle = 0;
    static int northwest = 0;
    static int west = 0;

    //main method
    public static void main(String[] args) throws IOException {

        //sorting method calls
        Main m = new Main();
        QuickSort qs = new QuickSort();
        BucketSort bs = new BucketSort();
        RadixSort rs = new RadixSort();
        String[] arr = m.readMe(); //temp variable for deleting dash.


        //string formatting
        String[] o = Main.deleteDash(arr);

        //ssn array
        int[] nums = new int[o.length];

        //interger parsing of array
        for (int i = 0; i < o.length; i++) {
            nums[i] = Integer.parseInt(o[i]);
        }

        //area counting method call
        Main.areaCounter(nums);


        //Quicksort run
        qs.quickSort(nums, 0, 8);
        File fileQuick = new File("C:\\Users\\bolto\\Desktop\\Quick_SSN.txt");
        FileWriter fileWriter1 = new FileWriter(fileQuick);
        PrintWriter printWriter1 = new PrintWriter(fileWriter1);

        printWriter1.println("Northeast Coast States: " + northeast + " people.");
        printWriter1.println("South Coast States: " + south + " people.");
        printWriter1.println("Middle Coast States: " + middle + " people.");
        printWriter1.println("Northwest Coast States: " + northwest + " people.");
        printWriter1.println("West Coast States: " + west + " people.");
        printWriter1.close();


        //Bucketsort run
        bs.bucketSort(nums);
        File fileBucket = new File("C:\\Users\\bolto\\Desktop\\Bucket_SSN.txt");
        FileWriter fileWriter2 = new FileWriter(fileBucket);
        PrintWriter printWriter2 = new PrintWriter(fileWriter2);

        printWriter2.println("Northeast Coast States: " + northeast + " people.");
        printWriter2.println("South Coast States: " + south + " people.");
        printWriter2.println("Middle Coast States: " + middle + " people.");
        printWriter2.println("Northwest Coast States: " + northwest + " people.");
        printWriter2.println("West Coast States: " + west + " people.");
        printWriter2.close();


        //Radixsort run
        rs.radixsort(nums, 0);
        File fileRadix = new File("C:\\Users\\bolto\\Desktop\\Radix_SSN.txt");
        FileWriter fileWriter3 = new FileWriter(fileRadix);
        PrintWriter printWriter3 = new PrintWriter(fileWriter3);

        printWriter3.println("Northeast Coast States: " + northeast + " people.");
        printWriter3.println("South Coast States: " + south + " people.");
        printWriter3.println("Middle Coast States: " + middle + " people.");
        printWriter3.println("Northwest Coast States: " + northwest + " people.");
        printWriter3.println("West Coast States: " + west + " people.");
        printWriter3.close();
    }


    //Method for counting area based on SSN
    public static void areaCounter(int[] arr) {

        int firstDigit = Integer.parseInt(Integer.toString(arr[0]).substring(0, 1));

        for (int i = 0; i < arr.length; i++) {

            if (Integer.parseInt(Integer.toString(arr[i]).substring(0, 1)) <= 1) {
                northeast++;
            } else if (Integer.parseInt(Integer.toString(arr[i]).substring(0, 1)) <= 3) {
                south++;
            } else if (Integer.parseInt(Integer.toString(arr[i]).substring(0, 1)) <= 6) {
                middle++;
            } else if (Integer.parseInt(Integer.toString(arr[i]).substring(0, 1)) <= 7) {
                northwest++;
            } else if (Integer.parseInt(Integer.toString(arr[i]).substring(0, 1)) <= 9) {
                west++;
            }

        }
    }

    //Method to delete dash in SSN
    public static String[] deleteDash(String[] n) {

        String[] noDash = new String[n.length];

        for (int i = 0; i < n.length; i++) {

            StringBuilder sb = new StringBuilder(n[i]);
            sb.deleteCharAt(3);
            sb.deleteCharAt(5);
            noDash[i] = sb.toString();

        }
        return noDash;
    }

    //Method to insert dash
    public static void insertDash(int n) {
        String ssn = Integer.toString(n);
        StringBuilder sb = new StringBuilder(ssn);
        sb.insert(3, '-');
        sb.insert(6, '-');
    }

    //Method to read in file
    public String[] readMe() throws IOException {

        File fileInput = new File("C:\\Users\\bolto\\Desktop\\Random_SSN.txt");
        Scanner in = new Scanner(fileInput);

        //count the number of lines of input file for length.
        int lineCount = 0;
        while (in.hasNextLine()) {
            in.nextLine();
            lineCount++;
        }
        in.close();

        //input file into string array. 2 lines represent one event. so each index of array needs to hold one event
        int length = lineCount;
        String[] stringArray = new String[length];

        in = new Scanner(fileInput);
        for (int i = 0; i < lineCount; i++) {
            stringArray[i] = in.nextLine();
        }
        in.close();

        return stringArray;
    }
}

