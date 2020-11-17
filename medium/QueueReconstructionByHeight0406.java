package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/11/17 10:27
 */
public class QueueReconstructionByHeight0406 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] person1, int[] person2) {
                if (person1[0] != person2[0]) {
                    return person1[0] - person2[0];
                } else {
                    return person2[1] - person1[1];
                }
            }
        });
        int n = people.length;
        int[][] ans = new int[n][];
        for (int[] person : people) {
            int spaces = person[1] + 1;
            for (int i = 0; i < n; ++i) {
                if (ans[i] == null) {
                    --spaces;
                    if (spaces == 0) {
                        ans[i] = person;
                        break;
                    }
                }
            }
        }
        return ans;
    }

    public int[][] reconstructQueue2(int[][] people) {
        Arrays.sort(people, (person1, person2) -> {
            if (person1[0] != person2[0]) {
                return person2[0] - person1[0];
            } else {
                return person1[1] - person2[1];
            }
        });
        List<int[]> ans = new ArrayList<int[]>();
        for (int[] person : people) {
            ans.add(person[1], person);
        }
        return ans.toArray(new int[ans.size()][]);
    }

    public static void main(String[] args) {
        QueueReconstructionByHeight0406 queueReconstructionByHeight0406 = new QueueReconstructionByHeight0406();
        int[][] people = new int[][]{{7, 0},{4, 4},{7, 1},{5, 0},{6, 1},{5,2}};
        System.out.println(Arrays.deepToString(queueReconstructionByHeight0406.reconstructQueue2(people)));

        //Integer[] a = new Integer[2];
        //a[0] = 1;
        //a[1] = 1;
        //Integer[] b = new Integer[2];
        //b[0] = 1;
        //b[1] = 1;;
        //System.out.println(a.equals(b));
        //
        //List<Integer> al = new ArrayList<>();
        //al.add(1);
        //al.add(1);
        //List<Integer> bl = new ArrayList<>();
        //bl.add(1);
        //bl.add(1);
        //System.out.println(al.equals(bl));
    }
}
