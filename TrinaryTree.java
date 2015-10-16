/**
 * @author josephmcadams Oct 11, 2015 -- 2015
 */
/*
 * // The following definitions of Tree and Node are provided. // insert and
 * delete will be methods of class Tree.
 */
public class Tree
{
	private Node	root;
	
	private class Node
	{
		private int		val;
		private Node	left	= null;
		private Node	right	= null;
		private Node	mid		= null;

		public Node(int val)
		{
			this.val = val;
		}	
	}

	public static void insertRecursively(Node searchNode, Node nodeToAdd)
	{
		if (nodeToAdd.val < searchNode.val)
		{
			if (searchNode.left != null)
				insertRecursively(searchNode.left, nodeToAdd);
			else
				searchNode.left = nodeToAdd;
		}
		
		else if (nodeToAdd.val > searchNode.val)
		{
			if (searchNode.right != null)
				insertRecursively(searchNode.right, nodeToAdd);
			else
				searchNode.right = nodeToAdd;
		}
		
		else
		{
			if (searchNode.mid != null)
				insertRecursively(searchNode.mid, nodeToAdd);
			else
				searchNode.mid = nodeToAdd;
		}
	}
	/*
	 * Please complete this method. Inserts val into the tree. There is no need
	 * to rebalance the tree.
	 */
	public void insert(int val)
	{
		Node newNode = new Node(val);

		if (this.root == null)
			this.root = newNode;
		
		else if (val < this.root.val)
		{
			if (this.root.left != null)
				insertRecursively(this.root.left, newNode);
			else
				this.root.left = newNode;
		}
		
		else if (val == this.root.val)
		{
			if (this.root.mid != null)
				insertRecursively(this.root.mid, newNode);
			else
				this.root.mid = newNode;
		}
		
		else //val is greater
		{
			if (this.root.right != null)
				insertRecursively(this.root.right, newNode);
			else
				this.root.right = newNode;
		}
	}

	/*
	 * Please complete this method. Deletes only one instance of val from the
	 * tree. If val does not exist in the tree, do nothing. There is no need to
	 * rebalance the tree.
	 */
	public void delete(int val)
	{
		if (this.root == null) return; //should exit code
		
		Node parent = null;
		Node nodeToRemove = this.root;
		
		while (nodeToRemove != null)
		{
			if (val > nodeToRemove.val)
			{
				parent = nodeToRemove;
				nodeToRemove = nodeToRemove.right;
			}
			else if (val < nodeToRemove.val)
			{
				parent = nodeToRemove;
				nodeToRemove = nodeToRemove.left;
			}
			else break; //if we get here we have found our node to remove
		}
		
		if (nodeToRemove == null) return; //should exit code
		
		if (nodeToRemove.mid != null) //we have duplicates
		{
			while (nodeToRemove.mid != null)
			{
				parent = nodeToRemove;
				nodeToRemove = nodeToRemove.mid;
			}
			
			parent.mid = null;
			return; //should exit code
		}
		//it is a leaf node we need to remove
		if (nodeToRemove.left == null && nodeToRemove.right == null)
		{
			if (parent.left == nodeToRemove)
				parent.left = null;
			else if (parent.right == nodeToRemove)
				parent.right = null;
			else
				parent.mid = null;
			return; //should exit code
		}
		if (nodeToRemove.left == null) //one right child
		{
			if (parent.left == nodeToRemove)
				parent.left = nodeToRemove.right;
			else
				parent.right = nodeToRemove.right;
			return; //should exit code
		}
		if (nodeToRemove.right == null) //one left child
		{
			if (parent.left == nodeToRemove)
				parent.left = nodeToRemove.left;
			else
				parent.right = nodeToRemove.left;
			return; //should exit code
		}
		else //two children
		{
			if (parent.left == nodeToRemove)
			{
				parent.left = nodeToRemove.right;
				parent.left.left = nodeToRemove.left;
			}
			else
			{
				parent.right = nodeToRemove.right;
				parent.right.left = nodeToRemove.left;
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{

		Tree tree = new Tree();
		tree.insert(11);
		tree.insert(6);
		tree.insert(11);
		tree.insert(13);
		tree.insert(12);
		tree.insert(15);
		tree.insert(5);
		tree.insert(8);
		
		System.out.println("Root is: " + tree.root.val);
		System.out.println("Level 1: " + tree.root.left.val + " " + tree.root.mid.val + " " + tree.root.right.val);
		System.out.println("level 2: " + tree.root.left.left.val + " " + tree.root.left.right.val + 
				" " + tree.root.right.left.val + " " + tree.root.right.right.val);
		
		tree.delete(6);
		tree.delete(13);
		
		System.out.println("Root is: " + tree.root.val);
		System.out.println("Level 1: " + tree.root.left.val + " " + tree.root.mid.val + " " + tree.root.right.val);
		System.out.println("Level 2: " + tree.root.left.left.val + " " + tree.root.right.left.val);
		
		
	}

}
