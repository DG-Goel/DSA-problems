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
class Solution 
{
    class Type
    {
        TreeNode root;
        Integer place;
        public Type(TreeNode root , Integer place)
        {
            this.root = root;
            this.place = place; 
        }
    }
    public int widthOfBinaryTree(TreeNode root) 
    {
        Queue <Type> queue = new LinkedList<>();
        queue.offer(new Type(root, 0));
        Boolean[] bool = new Boolean[1];
        bool[0] = false;
        return calc(queue, bool);
    }
    public int calc(Queue <Type> queue , Boolean [] bool )
    {
        int max = Integer.MIN_VALUE;
        while(!queue.isEmpty())
        {
            int level = queue.size();
            int first = 0;
            int last= 0;
            for(int i = 0 ; i< level ; i++)
            {
                Type value = queue.peek();
                TreeNode root = value.root;
                if(root.left!=null)
                {
                    int num = 2*value.place+1;
                    if(bool[0]==false)
                    {
                        first = num;
                        bool[0] = true;
                    }    
                    last = num-first;
                    queue.offer(new Type(root.left,last));
                }
                if(root.right!=null)
                {
                    int num = 2*value.place+2;
                    if(bool[0]==false)
                    {
                        first = num;
                        bool[0] = true;
                    }
                    last = num-first;
                    queue.offer(new Type(root.right,last));
                }
                queue.poll();
            }
            bool[0] = false;
            int width = last + 1;
            max = Math.max(max,width);
        }
        return max;
    }
}