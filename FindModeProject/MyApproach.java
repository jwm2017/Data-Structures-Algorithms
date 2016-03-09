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

public class MyApproach extends BaseApproach {

    public HashMap<Integer, Integer> FreqOfValsMap;

    public MyApproach(int[] inputList) {
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
