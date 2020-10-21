package easy;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/10/21 09:31
 */
public class LongPressedName0925 {
    public boolean isLongPressedName(String name, String typed) {
        int index = 0;
        int i = 0;
        while (i<typed.length()) {
            if (index < name.length() && name.charAt(index) == typed.charAt(i)){
                index++;
                i++;
            }
            else if (i > 0 && typed.charAt(i) == typed.charAt(i-1)){
                i++;
            }
            else {
                return false;
            }
            //char target = index>=name.length() ? name.charAt(name.length()-1) : name.charAt(index);
            //char current = typed.charAt(i);
            //if (current == target){
            //    index++;
            //    i++;
            //}else if (i>0){
            //    if (current == typed.charAt(i-1)){
            //        i++;
            //    }
            //}else {
            //    return false;
            //}
        }
        return index==name.length();
    }

    public static void main(String[] args) {
        LongPressedName0925 longPressedName0925 = new LongPressedName0925();
        String name = "alex";
        String typed = "aaleelx";
        System.out.println(longPressedName0925.isLongPressedName(name,typed));
    }
}
