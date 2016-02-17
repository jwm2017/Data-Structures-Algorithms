public class Dag {

  private Node root;
  private Stack stack;

  public Dag(Node rNode, Stack s) {
    root = rNode;
    stack = s;
  }

  public class Node {
    public List<Node> Successors;
    public T Value;

    public Node(T val) {
      value = val;
    }

    public void Traversal(Dag dagToSort) {
      //TODO DFS-based traversal of a Dag

    }
  }

  public class Stack {

    private int size;
    private T[] stackArray;
    private int indexOfTop;

    public Stack(int sizeOfStack) {
      size = sizeOfStack;
      stackArray = new T[size];
      indexOfTop = 0;
    }

    public void push(T val) {
      if (indexOfTop == size)
        throw new StackOverflowError("Tried to push to a stack that is already full");
      else {
        //check this to make sure top index isn't off by one
        stackArray[indexOfTop++] = val;
      }
    }

    public T pop() {
      if (indexOfTop == 0)
        throw new StackUnderflowError("Tried to pop from an empty stack");
      else
        return stackArray[indexOfTop--];
    }

    public boolean isEmpty() {
      return (indexOfTop == 0);
    }

  }


  public static void main(String[] args) {

  }
}
