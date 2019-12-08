package com.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GetMedianOfSortedArraysTest {

    private static final int[] ARR_A = new int[]{1, 12, 15, 26, 38};
    private static final int[] ARR_B = new int[]{2, 13, 17, 30, 45};

    @Test
    public void itShouldBeAbleToCalculateTheMedian() {
        assertThat(GetMedianOfSortedArrays.median(ARR_A, ARR_B)).isEqualTo(16);
    }

    @Test
    public void itShouldBeAbleToIdiomaticallyCalculateTheMedian() {
        assertThat(GetMedianOfSortedArrays.medianIdiomatic(ARR_A, ARR_B)).isEqualTo(16);
    }

}