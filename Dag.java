/*
 * Code written by:
 * Joe McAdams
 * for COSC 3100
 *
 *
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Stack;


public class Dag {

  private Node root;
  private Stack edgeStack;               //To keep track of visited nodes
  private ArrayList<Integer> OutputQueue; //To print out traversal path

  public Dag(Node rNode, Stack s) {
    root = rNode;
    edgeStack = s;
    OutputQueue = new ArrayList<>();
  }

  public void Traverse(Node root) {
    if (root.Successors.size() == 0)
      System.out.print(root.Value);
    else {
      int indOfSmallSucc = findSmallest(root.Successors);

    }

    //push root onto Stack
    //check if there are Successors
      //if there are, push the one with the lowest Value
      //continue until no successors
    //when no succesors, pop into a queue
    //backtrack into stack
    //TODO DFS-based traversal of a Dag

  }
  /*
   * Sorting method for a simple ArrayList of integers,
   * taking the ArrayList as input, returning the index
   * of the smallest element in the ArrayList. If called on
   * empty ArrayList, returns -1
   */
  private static int findSmallest(ArrayList<Integer> list) {
    if (list.size() == 0)
      return -1;
    else {
      //by default, the smallest element is the first one
      int smallest = 0;
      for (int i: list) {
        if (i < smallest) {
          smallest = list.indexOf(i);
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

  }
}
