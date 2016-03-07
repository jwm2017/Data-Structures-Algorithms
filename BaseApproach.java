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

        public HashMap<Integer, Integer> FreqOfValsMap;

        public BruteForce(int[] inputList) {
            super(inputList);
            this.FreqOfValsMap = new HashMap<Integer, Integer>(inputList.length); // Size = inputList's size
        }

        public void CalculateMode() {
            for(int val:this.List) { // For each value in the inputList, map each element to its frequency
                if (!FreqOfValsMap.containsKey(val)) {
                    FreqOfValsMap.put(val, 1);
                    if (1 > this.FreqOfMode) {
                        this.Mode = val;
                        this.FreqOfMode = 1;
                    }
                }
                else { // val already an entry in FreqOfValsMap
                    int freqOfVal = FreqOfValsMap.get(val);
                    freqOfVal++;
                    if (freqOfVal > this.FreqOfMode) { // val in List occurs most frequently
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
                else if (this.List[i] == lastValue)
                    count++;
                else { // Unique element in inputList found
                    lastValue = this.List[i];
                    if (count > this.FreqOfMode) {
                        this.FreqOfMode = count;
                        this.Mode = lastValue;
                    }
                    else {
                        lastValue = this.List[i];
                        count = 1; // reset count to 1 for new value
                    }
                }
            }
        }

        private void mergeSort() {

        }
    }

    public static void main(String[] args) {
        int[] sortedList = {0, 0, 0, 1, 1, 1, 1, 2, 2, 3, 3, 3};
        TransformNConquer fastApproach =
            new TransformNConquer(sortedList);
        fastApproach.CalculateMode();
        System.out.println(fastApproach.Mode);
        System.out.println(fastApproach.FreqOfMode);
        /*BruteForce slowApproach =
            new BruteForce(sortedList);
        slowApproach.CalculateMode();*/

    }
}
