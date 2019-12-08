package com.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GetMedianOfSortedArraysTest {

    @Test
    public void itShouldBeAbleToCalculateTheMedian() {
        int[] arrA = {1, 12, 15, 26, 38};
        int[] arrB = {2, 13, 17, 30, 45};

        int median = GetMedianOfSortedArrays.median(arrA, arrB);
        assertThat(median).isEqualTo(16);
    }

    @Test
    public void itShouldBeAbleToIdiomaticallyCalculateTheMedian() {
        int[] arrA = {1, 12, 15, 26, 38};
        int[] arrB = {2, 13, 17, 30, 45};

        int median = GetMedianOfSortedArrays.medianIdiomatic(arrA, arrB);
        assertThat(median).isEqualTo(16);
    }

}