package com.ahmadanees;

public class QuickSort {

    //Main quicksort call
    static void quickSort(int A[], int p, int r){

        if (p<r) {

            int q = Partition(A, p, r);
            quickSort(A, p, q - 1);
            quickSort(A, q + 1, r);

        }
    }

    //Partition call
    static int Partition(int A[], int p, int r){

        int x = A[r];
        int i = p-1;
        for (int j = p; j <= r-1; j++){
            if (A[j] <= x) {
                i++;
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }

        int temp = A[i+1];
        A[i+1] = A[r];
        A[r] = temp;
        return i+1;
    }
}
