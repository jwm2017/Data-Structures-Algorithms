import java.io.*;
import java.util.ArrayList;
import java.util.Stack;


public class Dag {

  private Node root;
  private Stack edgeStack;

  public Dag(Node rNode, Stack s) {
    root = rNode;
    edgeStack = s;
  }

  public void Traversal(Dag dagToSort) {
    //push root onto Stack
    //check if there are Successors
      //if there are, push the one with the lowest Value
      //continue until no successors
    //when no succesors, pop into a queue
    //backtrack into stack
    //TODO DFS-based traversal of a Dag

  }
  /*
   * sorting method for a simple ArrayList of integers,
   * taking the ArrayList as input, returning the index
   * of the smallest element in the ArrayList. If called on
   * empty ArrayList, returns -1
   */
  public static int findSmallest(ArrayList<Integer> list) {
    if (list.size() == 0)
      return -1;
    else {
      int smallest = list.get(0);
      for (int i: list) {
        if (list.get(i) < smallest) {
          smallest = i;
        }
      }
      return smallest;
    }
  }

  public class Node {

    public ArrayList<Node> Successors;
    public int Value;

    public Node(int val) {
      Value = val;
      Successors = new ArrayList<>();
    }

    public void AddNode(Node nodeToAdd) {
      Successors.add(nodeToAdd);
    }

    public boolean NoSuccessors() {
      return (Successors.size() == 0);
    }
  }

  public static void main(String[] args) {
    ArrayList<Integer> testList = new ArrayList<>();
    testList.add(3);
    testList.add(1);
    testList.add(4);
    testList.add(6);
    testList.add(9);
    testList.add(0);
    int result = findSmallest(testList);
    System.out.printf("Expected index of 5, received: %2d", result);
  }
}
