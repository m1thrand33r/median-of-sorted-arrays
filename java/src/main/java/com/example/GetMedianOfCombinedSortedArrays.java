package com.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Given two sorted arrays, of equal size calculate their median.
 */
public class GetMedianOfCombinedSortedArrays {

    public static int median(int[] arrA, int[] arrB) {
        int n = validateInput(arrA, arrB);

        int n2 = 2 * n;
        // we only need to retain at most 2 array elements when calculating the mean of an array,
        // these are the 2 center elements of our array of length 2n
        int prevEl = -1, currentEl = -1;

        // a counter to move through each array independently
        int aPtr = 0, bPtr = 0;
        // a counter used to track our progress while evaluating the arrays elements
        int progressCounter = 0;
        while (progressCounter < (n + 1)) {
            if (aPtr == n) {
                // process remaining arrB values as needed
                while (progressCounter < n2) {
                    int bVal = arrB[bPtr];
                    if (currentEl > 0) {
                        prevEl = currentEl;
                    }
                    currentEl = bVal;
                    progressCounter++;
                    bPtr++;
                }
            } else if (bPtr == n) {
                // process remaining arrA values as needed
                while (progressCounter < n2) {
                    int aVal = arrA[aPtr];
                    if (currentEl > 0) {
                        prevEl = currentEl;
                    }
                    currentEl = aVal;
                    progressCounter++;
                    aPtr++;
                }
            } else {
                // process the arrays together using the pointers to move through each, comparing as we go
                int aVal = arrA[aPtr];
                int bVal = arrB[bPtr];

                if (aVal < bVal) {
                    aPtr++;
                    if (currentEl > 0) {
                        prevEl = currentEl;
                    }
                    currentEl = aVal;
                    progressCounter++;
                } else if (aVal > bVal) {
                    bPtr++;
                    if (currentEl > 0) {
                        prevEl = currentEl;
                    }
                    currentEl = bVal;
                    progressCounter++;
                } else {
                    // an equal pairing can be instated to move things forward slightly faster
                    aPtr++;
                    bPtr++;
                    progressCounter += 2;
                    prevEl = aVal;
                    currentEl = bVal;
                }
            }
        }

        // we can select the median now that the arrays are sorted as we have 2 arrays of size n, we will
        // always pick element n and n + 1, taking the average, no need to proceed further
        return (prevEl + currentEl) / 2;
    }

    public static int medianIdiomatic(int[] arrA, int[] arrB) {
        int n = validateInput(arrA, arrB);

        List<Integer> mergedAndSortedArrays = Stream.concat(
                Arrays.stream(arrA).boxed(), Arrays.stream(arrB).boxed())
                .sorted()
                .collect(Collectors.toList());

        return (mergedAndSortedArrays.get(n - 1) + mergedAndSortedArrays.get(n)) / 2;
    }

    /**
     * Ensures both arrays are of the same length, returning their length.
     *
     * @param arrA array A
     * @param arrB array B
     * @return N, the length of each array
     * @throws IllegalArgumentException is the arrays are of differing length
     */
    private static int validateInput(int[] arrA, int[] arrB) {
        if (arrA.length != arrB.length) {
            throw new IllegalArgumentException("Arrays of the same length must be supplied");
        }

        if (Stream.concat(Arrays.stream(arrA).boxed(), Arrays.stream(arrB).boxed()).anyMatch(integer -> integer < 0)) {
            throw new IllegalArgumentException("Only positive values may be contained in the arrays");
        }
        return arrA.length;
    }


}
