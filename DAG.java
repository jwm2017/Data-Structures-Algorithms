/*
* Code written by:
* Joe McAdams
* for COSC 3100
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Stack;

/*
 * By definition, a DAG has no back edges (paths from a
 * descendant to an ancestor), so nodes should not have a
 * reference to their parent; parents, however, can have
 * multiple child nodes, so these are stored in an ArrayList
 * due to the in-built function of ArrayLists (see class structure
 * of the Node class). The edge stack will be used to pop and push
 * nodes to keep track of parent nodes in a traversal. Once a node
 * has no children, this node is popped onto the fOrderStack which,
 * after fully populated, can be popped until empty, effectively reversing
 * the finishing order of the DAG's traversal, which gives us a topologically
 * sorted DAG. That's what my notes say, at least :D
 */
public class DAG {

    private Node root;
    private Stack visitStack;               //To keep track of visited nodes
    public Stack fOrderStack;               //For finishing order

    public DAG(Node rNode) {
        this.root = rNode;
        this.visitStack = new Stack();
        this.fOrderStack = new Stack();
    }

    public void Traverse() {
        if (root.Successors.size() == 0)
            fOrderStack.push(root);
        else { //node has some children
            visitStack.push(root);
            traverseRecursively(root);
        }
    }

    // input: parent node with at least one child
    private void traverseRecursively(Node parent) {
        int indOfSmallSucc = findSmallest(parent.Successors);
        if (indOfSmallSucc != -1) { // parent has successors
            /*
             * Nodes in parent's Successors list will be removed
             * to isolate unvisited nodes.
             */
            while (indOfSmallSucc != -1) {
                Node nextNode = parent.Successors.get(indOfSmallSucc);
                visitStack.push(nextNode);
                traverseRecursively(nextNode);
                parent.Successors.remove(indOfSmallSucc);
                indOfSmallSucc = findSmallest(parent.Successors);
            }
            fOrderStack.push(parent);
        }
        else {
            /*
             * Parent node has no children (can a parent, philosophically,
             * have no children? Hmm... Maybe the node at one point had a child,
             * but the child moved to Seattle with a few of his/her Node friends
             * to start a band, but found the music scene too competitive to earn
             * a real living. In order to pay rent in the ever-inflating housing market,
             * the child node spent weeknights bartending in Belltown, practicing with
             * bandmates during the day. With little musical success and long nights at work,
             * the child node grew increasingly desperate for a solution -- until one quiet
             * night at the bar. The child node eavesdropped as one patron met with
             * two eldritch strangers to discuss the Venezuelan cocaine-trafficking cartel,
             * "Los Nińos Sucios." Apparently, one of the shipment drivers was caught by
             * local police, and they needed a quick replacement.
             *
             *
             * The child node thought nothing of it and died later that night in a
             * tragic bus accident, leaving the parent node without any children.)
             */
                fOrderStack.push(visitStack.pop());
        }
    }
    /*
     * Sorting method for a simple ArrayList of integers,
     * taking the ArrayList as input, returning the index
     * of the smallest element in the ArrayList. If called on
     * empty ArrayList, returns -1
     */
    private static int findSmallest(ArrayList<Node> list) {
        if (list.size() == 0) return -1;
        else {
            //by default, the smallest element is the first one
            int returnIndex = 0;
            int smallestVal = list.get(0).Value;
            for (Node n: list) {
                if (n.Value < smallestVal) {
                    returnIndex = list.indexOf(n);
                }
            }
            return returnIndex;
        }
    }

    public static class Node {

        public ArrayList<Node> Successors;
        public int Value;

        public Node(int val) {
            this.Value = val;
            this.Successors = new ArrayList<>();
        }

        public void AddNode(Node nodeToAdd) {
            this.Successors.add(nodeToAdd);
        }

        public boolean NoSuccessors() {
            return (Successors.size() == 0);
        }
    }

    public static void main(String[] args) {
        Node noSuccessors1 = new Node(51);
        Node noSuccessors2 = new Node(14);
        Node noSuccessors3 = new Node(35);
        Node noSuccessors4 = new Node(98);
        Node noSuccessors5 = new Node(1008);

        Node graphNodeWith2Children = new Node(5);
        graphNodeWith2Children.Successors.add(noSuccessors1);
        graphNodeWith2Children.Successors.add(noSuccessors2);

        Node graphNodeWith3Children = new Node(9);
        graphNodeWith3Children.Successors.add(noSuccessors3);
        graphNodeWith3Children.Successors.add(noSuccessors4);
        graphNodeWith3Children.Successors.add(noSuccessors5);


        /*      5
         *    /   \
         *   51    14
         */
        DAG smallDAG = new DAG(graphNodeWith2Children);
        smallDAG.Traverse();
        System.out.printf("%50s", "----------\n");
        System.out.printf("%50s", "smallDAG's topologically sorted output should be: 5 51 14\n");
        System.out.printf("%50s", "Actual is: ");
        while (!smallDAG.fOrderStack.empty()) {
            Node nodeToPrint = (Node)smallDAG.fOrderStack.pop();
            System.out.print(nodeToPrint.Value + " ");
        }
        System.out.println();
        System.out.printf("%50s", "----------\n");

        /*          9
         *       /  |  \
         *     35  98   1008
         */
        DAG mediumDAG = new DAG(graphNodeWith3Children);
        mediumDAG.Traverse();
        System.out.printf("%50s", "mediumDAG's topologically sorted output should be: 9 1008 98 35\n");
        System.out.printf("%50s", "Actual is: ");
        while (!mediumDAG.fOrderStack.empty()){
            Node nodeToPrint = (Node)mediumDAG.fOrderStack.pop();
            System.out.print(nodeToPrint.Value + " ");
        }
        System.out.println();
        System.out.printf("%50s", "----------\n");

        /*                     64
         *                /         \
         *               9           5
         *            /  |  \      /   \
         *          35  98  1008  51   14
         */
        //Data mutated in previous Traverse() calls, must re-add it
        Node graphNodeWith2BigChildren = new Node(64);
        graphNodeWith2Children.Successors.add(noSuccessors1);
        graphNodeWith2Children.Successors.add(noSuccessors2);
        graphNodeWith3Children.Successors.add(noSuccessors3);
        graphNodeWith3Children.Successors.add(noSuccessors4);
        graphNodeWith3Children.Successors.add(noSuccessors5);
        graphNodeWith2BigChildren.Successors.add(graphNodeWith3Children);
        graphNodeWith2BigChildren.Successors.add(graphNodeWith2Children);
        DAG largeDAG = new DAG(graphNodeWith2BigChildren);
        largeDAG.Traverse();
        System.out.printf("%50s", "largeDAG's topologically sorted output should" +
            " be: 64 9 1008 98 35 5 51 14\n");
        System.out.printf("%50s", "Actual is: ");
        while (!largeDAG.fOrderStack.empty()){
            Node nodeToPrint = (Node)largeDAG.fOrderStack.pop();
            System.out.print(nodeToPrint.Value + " ");
        }
        System.out.println();
        System.out.printf("%50s", "----------\n");
    }
}
