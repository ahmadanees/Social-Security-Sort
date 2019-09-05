package com.ahmadanees;

import java.util.Arrays;
import java.util.LinkedList;

public class BucketSort {

    public static void bucketSort(int [] A){

        //auxiliary array B[0.. n-1] of linked lists (buckets)
        LinkedList<LinkedList<Integer>> buckets  = new LinkedList<>();

        //length of array A
        int n = A.length;

        for(int i=0; i < n; i++){
            //You then need to create each sublist, here adding a single sublist:
            buckets.add(new LinkedList<>());
        }

        for(int i = 0; i < n; i++){
            for(int a:A){
                buckets.get(i).add(a);
            }
        }

        //sort B[i] with insertion sort
        //insertionSort(buckets);
        for(int i =0; i <n; i++){

            LinkedList<Integer> ALinkedList = buckets.get(i);

            Integer[] a = ALinkedList.toArray(new Integer[ALinkedList.size()]);

            insertionSort(a);

            //create a new list
            ALinkedList = new LinkedList<>(Arrays.asList(a));

            buckets.set(i, ALinkedList);
        }

        //concatenate the lists B[0], B[1], ... B[n-1] together in order

        LinkedList<Integer> result = new LinkedList<>();

        for(LinkedList<Integer> bucket: buckets){
            result.addAll(bucket);
        }

        //set the ordered elements back into array A
        for(int i =0; i < n;i++){

            A[i]=result.get(i);
        }

    }

    //insertionSort for sorting buckets
    public static void insertionSort(Integer[] a){
        int key;
        int i;

        for(int j = 1;j < a.length; j++){
            key = a[j];
            i=j-1;

            while(i>= 0 && a[i]>key){
                a[i+1]=a[i];
                i-=1;
            }
            a[i+1]=key;
        }
    }
}
