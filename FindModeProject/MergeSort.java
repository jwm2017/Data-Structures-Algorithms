/*
 * Code from:
 * https://www.cs.cmu.edu/~adamchik/15-121/lectures/Sorting%20Algorithms/code/MergeSort.java
 *
 * Modified by:
 * Joe McAdams
 *
 * for COSC3100
 *
 * with love.
 */
package approaches;

import java.util.*;

public class MergeSort {

    public static void Sort(int[] a) {
        int[] tmp = new int[a.length];
        sort(a, tmp,  0,  a.length - 1);
    }

    private static void sort(int[] a, int[] tmp, int left, int right) {
        if( left < right ) {
            int center = (left + right) / 2;
            sort(a, tmp, left, center);
            sort(a, tmp, center + 1, right);
            merge(a, tmp, left, center + 1, right);
        }
    }

    private static void merge(int[] a, int[] tmp, int left, int right, int rightEnd ) {
        int leftEnd = right - 1;
        int k = left;
        int num = rightEnd - left + 1;

        while(left <= leftEnd && right <= rightEnd) {
            if (a[left] < a[right])
                tmp[k++] = a[left++];
            else
                tmp[k++] = a[right++];
        }

        while(left <= leftEnd)    // Copy rest of first half
            tmp[k++] = a[left++];

        while(right <= rightEnd)  // Copy rest of right half
            tmp[k++] = a[right++];

        // Copy tmp back
        for(int i = 0; i < num; i++, rightEnd--)
            a[rightEnd] = tmp[rightEnd];
    }
}
