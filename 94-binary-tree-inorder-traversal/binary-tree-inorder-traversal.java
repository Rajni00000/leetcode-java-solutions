/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
// class Solution {
//     public List<Integer> inorderTraversal(TreeNode root) {
//         List<Integer>l=new Arraylist<>();
//         inorder(root,l);
//         return 1;


        
//     }
//     public void inorder(TreeNode root,l){
//         if(root==null)
//         return;
//         inorder(root.left,1);
//         l.add(root,val);
//         inorder(root,right,l);

//     }
// // }
// import java.util.*;

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> l = new ArrayList<>();
        inorder(root, l);
        return l;
    }

    public void inorder(TreeNode root, List<Integer> l) {
        if (root == null)
            return;

        inorder(root.left, l);   // Left
        l.add(root.val);         // Root
        inorder(root.right, l);  // Right
    }
}