/*
 * Written by:
 * Joe McAdams
 *
 * for COSC3100
 *
 * with love.
 */
package approaches;

import java.util.*;

public class TransformNConquer extends BaseApproach {

    public TransformNConquer(int[] inputList) {
        super(inputList);
    }

    public void CalculateMode() {
        MergeSort.Sort(this.List);
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
