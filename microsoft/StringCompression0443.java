package microsoft;

public class StringCompression0443 {
    public int compress(char[] chars) {
        int len = chars.length;
        if (len <= 1){
            return len;
        }
        int index = 0;
        int count = 1;
        int res = 0;
        char tmp = chars[0];
        for (int i=1; i<len; i++){
            if (chars[i] != tmp){
                chars[index++] = tmp;
                res++;
                if (count > 1){
                    for (char c: ("" + (count)).toCharArray()) {
                        chars[index++] = c;
                        res++;
                    }
                }
                tmp = chars[i];
                count = 1;
            }
            else {
                count++;
            }
        }
        if (count > 0){
            chars[index++] = tmp;
            res++;
            if (count > 1){
                for (char c: ("" + (count)).toCharArray()) {
                    chars[index++] = c;
                    res++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        StringCompression0443 stringCompression0443 = new StringCompression0443();
        char[] chars = new char[]{'a','a','b','b','c','c','c'};
        System.out.println(stringCompression0443.compress(chars));
        System.out.println(chars);
    }
}
