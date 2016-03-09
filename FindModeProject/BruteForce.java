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

public class BruteForce extends BaseApproach {

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
