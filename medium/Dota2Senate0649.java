package medium;

import com.sun.xml.internal.bind.v2.model.core.ID;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/11 09:23
 */
public class Dota2Senate0649 {
    public String predictPartyVictory(String senate) {
        int n = senate.length();
        Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();
        for (int i=0; i<n; i++){
            if (senate.charAt(i) == 'R'){
                radiant.offer(i);
            }else {
                dire.offer(i);
            }
        }
        while (!radiant.isEmpty() && !dire.isEmpty()){
            int radiantIndex = radiant.poll(), direIndex = dire.poll();
            if (radiantIndex < direIndex){
                radiant.offer(radiantIndex + n);
            }
            else {
                dire.offer(direIndex + n);
            }
        }
        return !radiant.isEmpty() ? "Radiant" : "Dire";
    }

    public static void main(String[] args) {
        Dota2Senate0649 dota2Senate0649 = new Dota2Senate0649();
        System.out.println(dota2Senate0649.predictPartyVictory("DDRRR"));
    }
}
