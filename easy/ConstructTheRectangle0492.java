package easy;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/10/23 09:28
 */
public class ConstructTheRectangle0492 {
    public int[] constructRectangle(int area) {
        int length = (int) Math.sqrt(area);
        int width = length;
        int curArea = width * length;
        while (curArea != area){
            if (curArea < area){
                length++;
            }
            else {
                width--;
            }
            curArea = length * width;
        }
        return new int[]{length, width};
    }
    public int[] constructRectangle2(int area) {
        int w = (int) Math.sqrt(area);
        while (area % w != 0) {
            --w;
        }
        return new int[]{area / w, w};
    }

}
