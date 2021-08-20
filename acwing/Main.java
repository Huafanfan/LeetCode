package acwing;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i=0; i<n; i++){
            nums[i] = in.nextInt();
        }

        //quick_sort(nums, 0, n-1);

        for (int i=0; i<n; i++){
            System.out.print(nums[i] + " ");
        }
    }
}
