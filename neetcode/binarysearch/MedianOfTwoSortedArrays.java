package neetcode.binarysearch;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/6/15 10:26
 */
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        int half = total / 2;
        int[] A = nums1, B = nums2;
        if (nums1.length > nums2.length){
            A = nums2;
            B = nums1;
        }
        int l = 0, r = A.length - 1;
        // log(min(n,m))
        while (true){
            // index A
            int i = (r + l) / 2;
            // -1 / 2 = 0 这里需要等于-1
            if (r + l == -1){
                i = -1;
            }
            // index B
            int j = half - (i + 1) -1;
            int Aleft, Aright, Bleft, Bright;
            if (i >= 0){
                Aleft = A[i];
            } else {
                Aleft = Integer.MIN_VALUE;
            }
            if (i+1 < A.length){
                Aright = A[i+1];
            } else {
                Aright = Integer.MAX_VALUE;
            }

            if (j >= 0){
                Bleft = B[j];
            } else {
                Bleft = Integer.MIN_VALUE;
            }
            if (j+1 < B.length){
                Bright = B[j+1];
            } else {
                Bright = Integer.MAX_VALUE;
            }
            // partition is correct
            if (Aleft <= Bright && Bleft <= Aright){
                if (total % 2 == 1){
                    return 1.0 * Math.min(Aright, Bright);
                } else {
                    return 1.0 * (Math.min(Aright, Bright) + Math.max(Aleft, Bleft)) / 2;
                }
            } else if (Aleft > Bright){
                r = i - 1;
            } else {
                l = i + 1;
            }
        }
    }

    public static void main(String[] args) {
        MedianOfTwoSortedArrays m = new MedianOfTwoSortedArrays();
        int[] nums1 = new int[]{1,3};
        int[] nums2 = new int[]{2};
        System.out.println(m.findMedianSortedArrays(nums1, nums2));
    }
}
