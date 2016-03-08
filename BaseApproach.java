/*
* Written by:
* Joe McAdams
*
* for COSC3100
*
* with love.
*/

import java.util.*;

public abstract class BaseApproach {

    public int Mode;
    public int FreqOfMode;
    public int[] List;

    public BaseApproach(int[] inputList) {
        this.List = inputList;
        this.Mode = -1;          // default value
        this.FreqOfMode = -1;    // default value
    }

    public abstract void CalculateMode();

    /*
     * Code from:
     * https://www.cs.cmu.edu/~adamchik/15-121/lectures/Sorting%20Algorithms/code/MergeSort.java
     */
    public static class mergeSort {

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

    public static class BruteForce extends BaseApproach {

        public BruteForce(int[] inputList) {
            super(inputList);
        }

        public void CalculateMode() {
            int localMode, localFreq;
            for (int i = 0; i < List.length; i++) {
                localMode = List[i];
                localFreq = 1;
                for (int j = 0; j < List.length; j++) {
                    if (i == j) // To avoid counting same element twice
                        continue;
                    if (List[i] == List[j])
                        localFreq++;
                }
                if (localFreq > this.FreqOfMode) {
                    this.FreqOfMode = localFreq;
                    this.Mode = List[i];
                }
            }
        }

    }

    public static class FastestApproach extends BaseApproach {

        public HashMap<Integer, Integer> FreqOfValsMap;

        public FastestApproach(int[] inputList) {
            super(inputList);
            this.FreqOfValsMap = new HashMap<Integer, Integer>();
        }

        /*
         * Iterate through each value of this.List, mapping each value
         * to its frequency in this.FreqOfValsMap
         */
        public void CalculateMode() {
            for(int val:this.List) {
                if (!FreqOfValsMap.containsKey(val)) { // Value not mapped in FreqOfValsMap
                    FreqOfValsMap.put(val, 1);
                    if (1 > this.FreqOfMode) {
                        this.Mode = val;
                        this.FreqOfMode = 1;
                    }
                }
                else { // val already an entry in FreqOfValsMap
                    int freqOfVal = FreqOfValsMap.get(val);
                    freqOfVal++;
                    if (freqOfVal > this.FreqOfMode) {
                        this.Mode = val;
                        this.FreqOfMode = freqOfVal;
                    }
                    FreqOfValsMap.put(val, FreqOfValsMap.get(val) + 1); // update freq val
                }
            }
        }
    }

    public static class TransformNConquer extends BaseApproach {

        public TransformNConquer(int[] inputList) {
            super(inputList);
        }

        public void CalculateMode() {
            mergeSort.Sort(this.List);
            int lastValue = -1;  // initialize to keep compiler happy
            int count = -1;      // initialize to keep compiler happy
            for (int i = 0; i < this.List.length; i++) {
                if (i == 0) { // Set this.Mode to the first element in inputList by default
                    lastValue = this.Mode = this.List[i];
                    count = this.FreqOfMode = 1;
                }
                else if (this.List[i] == lastValue) // Repeat of previous value found
                    count++;
                else { // Unique element in inputList found
                    if (count > this.FreqOfMode) {
                        this.FreqOfMode = count;
                        this.Mode = lastValue;
                    }
                    lastValue = this.List[i];
                    count = 1; // reset count to 1 for new value
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] unsortedList = {3, 2, 3, 5, 6, 7, 8, 2, 3, 3, 9, 9};
        BruteForce slow = new BruteForce(unsortedList);
        System.out.println(System.currentTimeMillis());
        slow.CalculateMode();
        System.out.println(System.currentTimeMillis());
        System.out.println("Slow's mode: " + slow.Mode);
        System.out.println("Slow's freq: " + slow.FreqOfMode);

        TransformNConquer fast = new TransformNConquer(unsortedList);

        System.out.println(System.currentTimeMillis());
        fast.CalculateMode();
        System.out.println(System.currentTimeMillis());
        System.out.println("Fast's mode: " + fast.Mode);
        System.out.println("Fast's freq: " + fast.FreqOfMode);
    }
}
