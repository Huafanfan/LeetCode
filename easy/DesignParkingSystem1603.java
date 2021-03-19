package easy;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/3/19 08:41
 */
public class DesignParkingSystem1603 {
    int BIG = 0;
    int MEDIUM = 0;
    int SMALL = 0;
    public DesignParkingSystem1603(int big, int medium, int small) {
        BIG = big;
        MEDIUM = medium;
        SMALL = small;
    }

    public boolean addCar(int carType) {
        switch (carType){
            case 1:
                if (BIG > 0){
                    BIG--;
                    return true;
                }
                else {
                    return false;
                }
            case 2:
                if (MEDIUM > 0){
                    MEDIUM--;
                    return true;
                }
                else {
                    return false;
                }
            case 3:
                if (SMALL > 0){
                    SMALL--;
                    return true;
                }
                else {
                    return false;
                }
            default:
                return false;
        }
    }
}
