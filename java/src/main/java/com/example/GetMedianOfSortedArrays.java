package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Given two sorted arrays, of equal size calculate their median.
 */
public class GetMedianOfSortedArrays {

    public static int median(int[] arrA, int[] arrB) {
        validateInput(arrA, arrB);

        int n = arrA.length;
        int[] merged = new int[2 * n];

        // a counter per array
        int aPtr = 0, bPtr = 0;
        // a counter used with the merged array
        int addedCounter = 0;
        while (addedCounter < (2 * n)) {
            // if all of the elements from one input have been added, we can just add the rest from the other array
            if (aPtr == n) {
                while (addedCounter < merged.length) {
                    merged[addedCounter++] = arrB[bPtr++];
                }
            } else if (bPtr == n) {
                while (addedCounter < merged.length) {
                    merged[addedCounter++] = arrA[aPtr++];
                }
            } else {
                // merge the arrays together using the pointers to move through each, comparing as we go
                int aVal = arrA[aPtr];
                int bVal = arrB[bPtr];

                if (aVal < bVal) {
                    merged[addedCounter++] = aVal;
                    aPtr++;
                } else if (aVal > bVal) {
                    merged[addedCounter++] = bVal;
                    bPtr++;
                } else {
                    merged[addedCounter++] = aVal;
                    merged[addedCounter++] = bVal;
                    aPtr++;
                    bPtr++;
                }
            }
        }

        // we can select the median now that the arrays are sorted as we have 2 arrays of size n, we will
        // always pick element n and n + 1, taking the average
        return (merged[n - 1] + merged[n]) / 2;
    }

    public static int medianIdiomatic(int[] arrA, int[] arrB) {
        validateInput(arrA, arrB);

        List<Integer> mergedAndSortedArrays = Stream.concat(
                Arrays.stream(arrA).boxed(), Arrays.stream(arrB).boxed())
                .sorted()
                .collect(Collectors.toList());

        int n = arrA.length;
        return (mergedAndSortedArrays.get(n - 1) + mergedAndSortedArrays.get(n)) / 2;
    }

    private static void validateInput(int[] arrA, int[] arrB) {
        if (arrA.length != arrB.length) {
            throw new IllegalArgumentException("Arrays of the same length must be supplied");
        }
    }


}
