package hard;

import medium.RotateImage0048;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/9/22 09:57
 */
public class BinaryTreeCameras0968 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    int result = 0;
    public int minCameraCover(TreeNode root) {
        if (dfs(root) == 1){
            //如果最后root节点的状态为1，表示两个儿子节点都是被自己的儿子节点所监控，自身没有被监控，所以需要在自身放监控
            result++;
        }
        return result;
    }

    /**
     * 0，1，2是当前层的状态
     * 0：当前节点被子节点监控，但是自身没有放置监控。所以他的父节点状态为1
     * 1：当前节点不可被观测到，父节点必须为2
     * 2：当前节点有摄像机，父节点为0
     * @param root
     * @return
     */
    public int dfs(TreeNode root){
        if (root == null){
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        //子节点没有被监控到需要优先考虑
        if (left == 1 ||right == 1){
            result++;
            return 2;
        }else if (left == 2 ||right == 2){
            return 0;
        }
        else {
            return 1;
        }
    }
}
