package intervire;

import java.util.*;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/3/13 19:33
 */
public class Solution {
    class Node{
        String name;
        List<Node> childs;
        Node next;
    }

    public Double solution(Double num, int roundCount){
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(num));
        StringBuilder res = new StringBuilder();
        int odd = 0;
        for (int i=0; i<stringBuilder.length();){
            if (stringBuilder.charAt(i) != '.'){
                res.append(stringBuilder.charAt(i));
                odd = (((stringBuilder.charAt(i) - '0') & 1) == 0) ? odd-- : odd++;
                i++;
            }
            else {
                res.append(stringBuilder.charAt(i));
                i++;
                for (int j=0; j<roundCount - 1; j++){
                    res.append(stringBuilder.charAt(i++));
                }
                if (odd > 0){
                    res.append(stringBuilder.charAt(i++) - '0' + 1);
                }
                else {
                    res.append(stringBuilder.charAt(i));
                }
            }
        }

    }

    public static void main(String[] args) {
        //3.3435 => 3.344
        //3.8765 => 3.876
        //3.9287 => 3.929
        //3.2732 => 3.273
        //3.6875 => 3.688
        //3.3125 => 3.312


        //Students(s_id, name…)
        //
        //Courses(c_id, name…)
        //
        //Score(s_id, c_id, value….)

        //select Students.name, Score.value
        //        from Students, Courses, Score
        //    where Students.s_id = Score.s_id and Score.c_id = Courses.c_id and Courses.name = '语文'

    }
}
