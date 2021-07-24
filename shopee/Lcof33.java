package shopee;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/7/24 17:35
 */
public class Lcof33 {
    public boolean verifyPostorder(int[] postorder) {
        return verifyPostorder(postorder, 0, postorder.length - 1);
    }

    public boolean verifyPostorder(int[] postorder, int left, int right) {
        if (left >= right){
            return true;
        }
        int root = postorder[right];
        int i;
        for (i=left; i<right; i++){
            if (postorder[i] > root){
                break;
            }
        }
        for (int j=i; j<right; j++){
            if (postorder[j] <root){
                return false;
            }
        }
        return verifyPostorder(postorder, left, i-1) && verifyPostorder(postorder,i, right-1);
    }
}
