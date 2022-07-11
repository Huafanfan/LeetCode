package medium;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/7/11 08:59
 */
public class ImplementMagicDictionary0676 {
    String[] words;
    public ImplementMagicDictionary0676() {

    }

    public void buildDict(String[] dictionary) {
        words = dictionary;
    }

    public boolean search(String searchWord) {
        for (String word : words){
            if (word.length() != searchWord.length()){
                continue;
            }
            int diff = 0;
            for (int i=0; i<word.length(); i++){
                if (word.charAt(i) != searchWord.charAt(i)){
                    diff++;
                }
                if (diff > 1){
                    break;
                }
            }
            if (diff == 1){
                return true;
            }
        }
        return false;
    }
}
