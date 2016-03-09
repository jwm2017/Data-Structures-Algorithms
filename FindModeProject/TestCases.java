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

public class TestCases {

    public static int[] CreateListWithSize(int size) {
        int[] returnList = new int[size];
        populateWithRanVals(returnList);
        return returnList;
    }

    public static void CalcAndPrintEfficiency(Object approach) {
        long beforeTime  = System.currentTimeMillis();
        if (approach instanceof BruteForce) {
            BruteForce approachToRun = (BruteForce)approach;
            approachToRun.CalculateMode();
        }
        else if (approach instanceof TransformNConquer) {
            TransformNConquer approachToRun = (TransformNConquer)approach;
            approachToRun.CalculateMode();
        }
        else { //instanceof MyApproach
            MyApproach approachToRun = (MyApproach)approach;
            approachToRun.CalculateMode();
        }
        long afterTime = System.currentTimeMillis();
        System.out.println("It took " + approach.toString()
            + (afterTime - beforeTime) + " milliseconds to calculate"
            + "the mode and its frequency");
    }

    private static void populateWithRanVals(int[] list) {
        int random;
        for (int i = 0; i < list.length; i++) {
            random = (int)(Math.random() * 1000 + 1);
            list[i] = random;
        }
    }

    public static void main(String[] args) {
        System.out.println("===BEGIN TESTS===");

        System.out.println("\n\n---Assert Find Mode Works Test---\n\n");
        int[] smallUnsortedList = {9, 8, 3, 4, 5, 5, 6, 7, 2, 1, 3, 5};
        BruteForce demoBruteForce = new BruteForce(smallUnsortedList);
        MyApproach demoMyApproach = new MyApproach(smallUnsortedList);
        TransformNConquer demoTransformNConquer = new TransformNConquer(smallUnsortedList);
        demoBruteForce.CalculateMode();
        demoMyApproach.CalculateMode();
        demoTransformNConquer.CalculateMode();
        System.out.printf("BruteForce thinks the mode is %d"
            + " and it occurs %d times\r\n", demoBruteForce.Mode, demoBruteForce.FreqOfMode);
        System.out.printf("MyApproach thinks the mode is %d"
            + " and it occurs %d times\r\n", demoMyApproach.Mode, demoMyApproach.FreqOfMode);
        System.out.printf("TransformNConquer thinks the mode is %d"
            + " and it occurs %d times\r\n", demoTransformNConquer.Mode, demoTransformNConquer.FreqOfMode);

        System.out.println("\n\n---Print Run Times With Varying Input Sizes---\n\n");
        for (int i = 10; i <= 100000; i *= 10) {
            int[] testList = CreateListWithSize(i);
            TestCases.CalcAndPrintEfficiency(new BruteForce(testList));
            TestCases.CalcAndPrintEfficiency(new MyApproach(testList));
            TestCases.CalcAndPrintEfficiency(new TransformNConquer(testList));
        }

        System.out.println("\n\n===END TESTS===");
    }
}
