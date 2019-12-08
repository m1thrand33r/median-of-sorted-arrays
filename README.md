# median-of-sorted-arrays

There are 2 sorted arrays A and B, each of the same size. 

Write an algorithm to find the median of the combined set of all numbers contained in both arrays.

Median: See See https://en.wikipedia.org/wiki/Median.

## Examples

- Odd n example: The median of the sorted array `{ 10, 11, 12, 15, 20 }` is 12.
- Even n example: The median of the arrays `{1, 12, 15, 26, 38}` and `{2, 13, 17, 30, 45}` is 16.
  - Looking at the sorted combined array `{1, 2, 12, 13, 15, 17, 26, 30, 38, 45}` we see `{15, 17}` are the median
  - In this case we use the floor of the average `(15 + 17) ? 2 = 16`

## Solution

A Maven project can be found under the `/java` directory, please build using Java 8 and Maven via:

```bash
mvn clean package
```

This will also run the single test class within the project.