package medium;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/9/30 09:43
 */
public class RectangleArea0223 {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int cx1 = Math.max(ax1, bx1);
        int cx2 = Math.min(ax2, bx2);
        int cy1 = Math.max(ay1, by1);
        int cy2 = Math.min(ay2, by2);

        return getArea(ax1, ax2, ay1, ay2) + getArea(bx1, bx2, by1, by2) - getArea(cx1, cx2, cy1, cy2);
    }

    public int getArea(int x1, int x2, int y1, int y2){
        if (x2 < x1 || y2 < y1){
            return 0;
        }
        return (x2 - x1) * (y2 - y1);
    }

    public static void main(String[] args) {
        RectangleArea0223 rectangleArea0223 = new RectangleArea0223();
        System.out.println(rectangleArea0223.computeArea(-2, -2, 2, 2, 3, -3, 4, -4));
    }
}
