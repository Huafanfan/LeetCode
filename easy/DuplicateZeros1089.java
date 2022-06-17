package easy;

import java.util.Arrays;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/6/17 09:22
 */
public class DuplicateZeros1089 {
    public void duplicateZeros(int[] arr) {
        int n = arr.length;
        int top = 0;
        int i = -1;
        while (top < n){
            i++;
            if (arr[i] != 0){
                top++;
            } else {
                top += 2;
            }
        }
        int j = n-1;
        // 0 超了，最后只能补充一个0了
        if (top == n + 1){
            arr[j] = 0;
            j--;
            i--;
        }
        while (j >= 0){
            arr[j] = arr[i];
            j--;
            if (arr[i] == 0){
                arr[j] = arr[i];
                j--;
            }
            i--;
        }
    }

    public static void main(String[] args) {
        DuplicateZeros1089 d = new DuplicateZeros1089();
        int[] arrs = new int[]{1,0,2,3,0,4,5,0};
        d.duplicateZeros(arrs);
        System.out.println(Arrays.toString(arrs));
    }
}
