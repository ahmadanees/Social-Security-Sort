package com.ahmadanees;
import java.util.*;

public class RadixSort {

    // The main function to that sorts A[] of size n using

    static void radixsort(int A[], int d) {
        // Find the maximum number to know number of digits
        int largest = getMax(A, d);
        int B[] = new int[A.length-1];

        // Do counting sort as stable sort to sort array A on digit i.
        for (int i = 1; i<= d; i++)
            countSort(A, B, d);
    }

    // A utility function to get maximum value in A[]
    static int getMax(int A[], int n) {
        int max = A[0];
        for (int i = 1; i < n; i++)
            if (A[i] > max)
                max = A[i];
        return max;
    }

    // A function to do counting sort of A[] according to
    // the digit represented by exp.
    static void countSort(int A[], int B[], int k) {
        int C[] = new int[k];
        Arrays.fill(C, 0);

        for (int j=0; j <= A.length; j++)
            C[A[j]] = C[A[j]] + 1;
        //C[i] now contains the number of elemeents equal to i.

        for (int i=0; i <= A.length; i++)
            C[i] = C[i] + C[i+1];
        //C[i] now contains the number of elements less than or equal to i.

        for (int j = A.length; j >= 1; j--) {
            B[C[A[j]]] = A[j];
            C[A[j]] = C[A[j]] - 1;
        }
    }
}


