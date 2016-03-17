/*
* @author Joe McAdams joseph.mcadams@mu.edu
* Written for COSC3100
* With love.
*/

import java.util.Arrays;

public class HeapSort {

    public int[] List;
    private int length;

    public static void main(String[] args) {
        int[] testList;
        for (int i = 5; i <= 15; i+= 5) {
            testList = TestCases.CreateListWithSize(i);
            System.out.println("--With the randomly generated list---------");
            System.out.println(Arrays.toString(testList));
            System.out.println("-------------------------------------------");
            HeapSort sorter = new HeapSort(testList);
            sorter.Sort();
            System.out.println("-------------------------------------------");
            System.out.println("--Here is the final sorted list------------");
            System.out.println(Arrays.toString(testList));
            System.out.println("\n");
        }
    }

    public HeapSort(int[] passedList) {
        this.List = passedList;
        this.length = List.length - 1;
    }

    public void Sort() {
        heapify();
        heapSort();
    }

    /*
    * For every parent node in heap, swap with child if child has larger
    * value
    */
    private void heapify() {
        System.out.println("--Here are the intermediate heapify steps--");
        for (int i = this.length / 2; i >= 0; i--) {
            bubbleDown(i);
            System.out.println(Arrays.toString(List));
        }
    }

    /*
    * For every index, check to see if it's lChild and rChild are within the bounds
    * of the List, then compare values. Take the greatest of the two children's values
    * then swap that child with the parent index, calling bubbleDown recursively
    *
    * @input: index of element to swap with predecessors
    */
    private void bubbleDown(int index) {
        int lChildIndex = 2 * index;
        int rChildIndex = lChildIndex + 1;
        int indOfLargest = index;

        if (lChildIndex <= length && List[lChildIndex] > List[indOfLargest])
            indOfLargest = lChildIndex;
        if (rChildIndex <= length && List[rChildIndex] > List[indOfLargest])
            indOfLargest = rChildIndex;
        if (indOfLargest != index) {
            swap(index, indOfLargest);
            bubbleDown(indOfLargest);
        }
    }

    private void swap(int firstIndex, int secondIndex) {
        int temp;
        temp = List[firstIndex];
        List[firstIndex] = List[secondIndex];
        List[secondIndex] = temp;
    }

    /*
    * Starting at the last element of the heap, swap with the first element
    * then call bubbleDown to place it correctly 'above' the largest element
    */
    private void heapSort() {
        for (int i = length; i > 0; i--) {
            swap(0, i);
            length--;
            bubbleDown(0);
        }
    }

    private static class TestCases {

        public static int[] CreateListWithSize(int size) {
            int[] returnList = new int[size];
            populateWithRanVals(returnList);
            return returnList;
        }

        private static void populateWithRanVals(int[] list) {
            int random;
            for (int i = 0; i < list.length; i++) {
                random = (int)(Math.random() * 100 + 1);
                list[i] = random;
            }
        }
    }
}
