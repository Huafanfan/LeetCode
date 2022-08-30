package medium;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author yifan.zhangyf
 * @date 2022/8/30 11:06 PM
 */
public class MaximumBinarTree0654 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }
    TreeNode build(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }
        int idx = l;
        for (int i = l; i <= r; i++) {
            if (nums[i] > nums[idx]) {
                idx = i;
            }
        }
        TreeNode ans = new TreeNode(nums[idx]);
        ans.left = build(nums, l, idx - 1);
        ans.right = build(nums, idx + 1, r);
        return ans;
    }

    public TreeNode constructMaximumBinaryTree2(int[] nums) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        for (int num : nums) {
            TreeNode node = new TreeNode(num);
            while (!stack.isEmpty() && num > stack.peek().val) {
                node.left = stack.pop();
            }

            if (!stack.isEmpty()) {
                stack.peek().right = node;
            }

            stack.push(node);
        }

        // 返回栈底的元素，也就是最大值
        // 此方法为双端队列的方法，严格意义并不是栈的方法
        // 严格按照栈的写法应该弹出上面的所有元素，才能取出最底下的元素
        // 就像倒水一样，先倒上面的，才能倒出下面的
        return stack.peekLast();
    }
}
