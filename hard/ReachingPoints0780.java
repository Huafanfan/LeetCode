package hard;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/4/9 09:33
 */
public class ReachingPoints0780 {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while (tx > sx && ty > sy && tx != ty){
            if (tx > ty){
                tx %= ty;
            } else {
                ty %= tx;
            }
        }
        if (sx == tx && sy == ty){
            return true;
        } else if (sx == tx){
            return ty > sy && (ty - sy) % tx == 0;
        } else if (sy == ty){
            return tx > sx && (tx - sx) % ty == 0;
        } else {
            return false;
        }
    }
}
