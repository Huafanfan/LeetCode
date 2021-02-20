package microsoft;

public class SortColors0075 {
    public void sortColors(int[] nums) {
        int len = nums.length;
        int index0 = 0;
        int index2 = len - 1;
        int i=0;
        while (i <= index2){
            if (nums[i] == 0){
                swap(nums, i, index0);
                index0++;
                i++;
            }
            else if (nums[i] == 2){
                swap(nums, i, index2);
                index2--;
            }
            else{
                i++;
            }
        }
    }

    public void sortColors2(int[] nums) {
        int len = nums.length;
        int index0 = 0;
        int index1 = 0;
        int i=0;
        while (i <len){
            if (nums[i] == 1){
                swap(nums, i, index1);
                index1++;
            }
            else if (nums[i] == 0){
                swap(nums, i, index0);
                if (index1 > index0){
                    swap(nums, i, index1);
                }
                index0++;
                index1++;
            }
            i++;
        }
    }

    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = nums[i];
    }
}
