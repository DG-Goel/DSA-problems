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
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        boolean[] direction = new boolean[1];
        direction[0] = true;
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) return result;

        queue.offer(root);
        calc(queue, direction, result);

        return result;
    }

    public void calc(Queue<TreeNode> queue, boolean[] direction, List<List<Integer>> result) {

        while (!queue.isEmpty()) {

            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            Stack<Integer> st = new Stack<>();

            for (int i = 0; i < size; i++) {

                TreeNode node = queue.poll();

                if (direction[0])
                    list.add(node.val);
                else
                    st.push(node.val);

                if (node.left != null)
                    queue.offer(node.left);

                if (node.right != null)
                    queue.offer(node.right);
            }

            while (!st.isEmpty())
                list.add(st.pop());

            result.add(list);
            direction[0] = !direction[0];
        }
    }
}