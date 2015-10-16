/**
 * @author josephmcadams Oct 11, 2015 -- 2015
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

	public void delete(int val)
	{
		if (this.root == null) return; 
		
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
}
