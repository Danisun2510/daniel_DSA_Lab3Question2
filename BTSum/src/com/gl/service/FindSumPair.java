package com.gl.service;

import java.util.HashSet;

public class FindSumPair  {
	static class Node {
	int data;
    Node left, right;
	}
 
    static Node NewNode(int data)
    {
        Node temp=new Node();;
        temp.data=data;
        temp.left=null;
        temp.right = null;
        return temp;
    }
   public Node insert(Node root, int key)
   {
	   if(root==null)
		   return  NewNode(key);
	   if(key<root.data)
		   root.right=insert(root.right,key);
	   return root;
   }
   public boolean findpairUtil(Node root, int sum,HashSet<Integer> set)
   {
	   if(root==null)
		   return false;
	   if(findpairUtil(root.left ,sum,set))
		   return true;
	   if(set.contains(sum-root.data)) {
		   System.out.println("Pair is found ("
					+ (sum - root.data) + ", "
					+ root.data + ")");
			return true;

		}
		else
			set.add(root.data);

		return findpairUtil(root.right, sum, set);
	}

	public void findPairWithGivenSum(Node root, int sum)
	{
		HashSet<Integer> set = new HashSet<Integer>();
		if (!findpairUtil(root, sum, set))
			System.out.print("Pairs do not exit"
					+ "\n");

	}

	
	public static void main(String[] args)
	{
		Node root = null;
		
		FindSumPair findSP = new FindSumPair();
		root = findSP.insert(root, 40);
		root = findSP.insert(root, 20);
		root = findSP.insert(root, 60);
		root = findSP.insert(root, 10);
		root = findSP.insert(root, 30);
		root = findSP.insert(root, 50);
		root = findSP.insert(root, 70);

		int sum = 60;
		findSP.findPairWithGivenSum(root, sum);
	}
}

