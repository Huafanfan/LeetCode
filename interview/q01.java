package interview;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/25 15:11
 */
public class q01 {
    public boolean isUnique(String astr) {
        long bit = 0;
        for (int i=0; i<astr.length(); i++){
            int index = astr.charAt(i) - 'A';
            if ((bit & (1L<<index)) != 0){
                return false;
            }
            else {
                bit |= (1L<<index);
            }
        }
        return true;
    }
}
