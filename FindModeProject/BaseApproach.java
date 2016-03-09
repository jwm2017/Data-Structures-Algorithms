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

    @Override
    public String toString() {
        return String.format(
            "[" + this.getClass().toString() + " with List size "
            + this.List.length + "] ");
    }
}
