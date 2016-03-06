/*
* Written by:
* Joe McAdams
*
* for COSC3100
*
* with love.
*/

public abstract class BaseApproach {

    public int Mode;
    public int FreqOfMode;
    private int[] List;

    public BaseApproach(int[] inputList) {
        this.List = inputList;
        this.Mode = 0;
        this.FreqOfMode = 0;
    }

    public abstract void FindMode();
}

class BruteForce extends BaseApproach {

    public BruteForce(int[] inputList) {
        super(inputList);
    }

    public void FindMode() {

    }
}

class TransformNConquer extends BaseApproach {

    public TransformNConquer(int[] inputList) {
        super(inputList);
    }

    public void FindMode() {
        
    }
}
