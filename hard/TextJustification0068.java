package hard;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/9/9 10:01
 */
public class TextJustification0068 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<List<String>> firstPartition = new ArrayList<>();
        int index = 0;
        while (index < words.length){
            int curCount = 0;
            List<String> curList = new ArrayList<>();
            do {
                curCount += words[index].length();
                if (curCount <= maxWidth){
                    curList.add(words[index]);
                    curCount++;
                    index++;
                }
            }while (curCount < maxWidth && index < words.length);
            firstPartition.add(curList);
        }
        List<String> res = new ArrayList<>();
        for (int i=0; i<firstPartition.size()-1; i++) {
            int countWord = firstPartition.get(i).size();
            int sumLength = 0;
            for (String w : firstPartition.get(i)) {
                sumLength += w.length();
            }
            StringBuilder sb = new StringBuilder();
            if (countWord == 1){
                sb.append(firstPartition.get(i).get(0));
                while (sb.length() < maxWidth){
                    sb.append(" ");
                }
            }
            else {
                int eachSpace = (maxWidth - sumLength) / (countWord - 1);
                int modSpace = (maxWidth - sumLength) % (countWord - 1);
                for (int j=0; j<countWord-1; j++) {
                    sb.append(firstPartition.get(i).get(j));
                    for (int k = 0; k < eachSpace; k++) {
                        sb.append(" ");
                    }
                    if (modSpace > 0) {
                        sb.append(" ");
                        modSpace--;
                    }
                }
                sb.append(firstPartition.get(i).get(countWord-1));
            }
            res.add(sb.toString());
        }
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<firstPartition.get(firstPartition.size()-1).size() - 1; i++) {
            sb.append(firstPartition.get(firstPartition.size()-1).get(i));
            sb.append(" ");
        }
        sb.append(firstPartition.get(firstPartition.size()-1).get(firstPartition.get(firstPartition.size()-1).size() - 1));
        while (sb.length() < maxWidth){
            sb.append(" ");
        }
        res.add(sb.toString());
        return res;
    }

    public static void main(String[] args) {
        TextJustification0068 textJustification0068 = new TextJustification0068();
        //String[] words = new String[]{"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"};
        //System.out.println(textJustification0068.fullJustify(words, 20));
        String[] words = new String[]{"What","must","be","acknowledgment","shall","be"};
        System.out.println(textJustification0068.fullJustify(words, 16));
    }
}