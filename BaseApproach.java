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
        this.Mode = 0;          // default value
        this.FreqOfMode = 0;    // default value
    }

    public abstract void FindMode();
}

class BruteForce extends BaseApproach {

    public HashMap MappedVals;

    public BruteForce(int[] inputList) {
        super(inputList);
        this.MappedVals = new HashMap();
    }

    public void FindMode() {

    }
}

class TransformNConquer extends BaseApproach {

    public TransformNConquer(int[] inputList) {
        super(inputList);
    }

    public void FindMode() {
        mergeSort(this.List);
    }

    private void mergeSort(int[] listToSort) {

    }
}
