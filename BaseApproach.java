/*
* Written by:
* Joe McAdams
*
* for COSC3100
*
* with love.
*/

import java.util.HashMap;

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
            mergeSort();
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

        private void mergeSort() {

        }

        private void mergeSort()
    }

    public static void main(String[] args) {
        int[] sortedList = {0, 0, 0, 1, 1, 1, 1, 2, 2, 3, 3, 3};
    }
}
