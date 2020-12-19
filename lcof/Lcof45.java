package lcof;

import java.util.*;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/19 10:01
 */
public class Lcof45 {
    /**
     * 84.32%
     * 96.56%
     * @param nums
     * @return
     */
    public String minNumber(int[] nums) {
        String[] stringNums = new String[nums.length];
        for (int i=0; i<nums.length; i++){
            stringNums[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(stringNums, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String first = o1 + o2;
                String second = o2 + o1;
                return first.compareTo(second);
            }
        });
        StringBuilder res = new StringBuilder();
        for (String num : stringNums){
            res.append(num);
        }
        return res.toString();
    }

    /**
     * 97.47%
     * 92.37%
     * @param nums
     * @return
     */
    public String minNumber2(int[] nums) {
        String[] strs = new String[nums.length];
        for(int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        quickSort(strs, 0, strs.length - 1);
        StringBuilder res = new StringBuilder();
        for(String s : strs) {
            res.append(s);
        }
        return res.toString();
    }
    void quickSort(String[] strs, int l, int r) {
        if(l >= r) {
            return;
        }
        int pos = partition(strs, l, r);
        quickSort(strs, l, pos-1);
        quickSort(strs, pos + 1, r);
    }

    public int partition(String[] strs, int l, int r){
        int randomIndex = new Random().nextInt(r - l + 1) + l;
        swap(strs, l, randomIndex);
        String pivot  = strs[l];

        int lt = l;
        for (int i=l+1; i<=r; i++){
            if ((strs[i] + pivot).compareTo(pivot + strs[i])<0){
                lt++;
                swap(strs, lt, i);
            }
        }
        swap(strs, lt, l);
        return lt;
    }

    private void swap(String[] nums, int index1, int index2) {
        String temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static void main(String[] args) {
        Lcof45 lcof45 = new Lcof45();
        int[] nums = new int[]{3,30,34,5,9};
        System.out.println(lcof45.minNumber2(nums));
    }
}
