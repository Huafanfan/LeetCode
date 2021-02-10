package microsoft;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/2/10 15:56
 */
public class MergeSortedArray0088 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m >= 0) {
            System.arraycopy(nums1, 0, nums1, m, m);
        }
        int index1 = m;
        int index2 = 0;
        int index = 0;
        while (index1 < m + n || index2 < n){
            if (index1 == m + n){
                nums1[index++] = nums2[index2++];
            }
            else if (index2 == n){
                nums1[index++] = nums1[index1++];
            }
            else {
                if (nums1[index1] <= nums2[index2]){
                    nums1[index++] = nums1[index1++];
                }
                else {
                    nums1[index++] = nums2[index2++];
                }
            }
        }
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;

        while ((p1 >= 0) && (p2 >= 0))
        {
            nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];
        }
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }
}
