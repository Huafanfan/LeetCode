package medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/6/29 10:25
 */
public class EncodeAndDecodeTinyurl0535 {
    Map<String, String> origin2Tiny = new HashMap<>(), tiny2Origin = new HashMap<>();
    String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    String prefix = "https://huafanfan.com/tags/";
    int k = 6;
    Random random = new Random();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        while (!origin2Tiny.containsKey(longUrl)){
            char[] cs = new char[k];
            for (int i=0; i<k; i++){
                cs[i] = str.charAt(random.nextInt(str.length()));
            }
            String tiny = prefix + String.valueOf(cs);
            if (tiny2Origin.containsKey(tiny)){
                continue;
            }
            tiny2Origin.put(tiny, longUrl);
            origin2Tiny.put(longUrl, tiny);
        }
        return origin2Tiny.get(longUrl);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return tiny2Origin.get(shortUrl);
    }
}
