package medium;

import java.util.Arrays;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/9/4 10:47
 */
public class BoatsToSavePeople0881 {
    public int numRescueBoats(int[] people, int limit) {
        int ans = 0;
        Arrays.sort(people);
        int light = 0, heavy = people.length - 1;
        while (light <= heavy) {
            if (people[light] + people[heavy] <= limit) {
                ++light;
            }
            --heavy;
            ++ans;
        }
        return ans;
    }

    public static void main(String[] args) {
        BoatsToSavePeople0881 boatsToSavePeople0881 = new BoatsToSavePeople0881();
        int[] people = new int[]{5,1,4,2,6};
        System.out.println(boatsToSavePeople0881.numRescueBoats(people, 3));
    }
}
