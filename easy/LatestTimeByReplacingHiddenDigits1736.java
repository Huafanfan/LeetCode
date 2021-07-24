package easy;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/7/24 14:24
 */
public class LatestTimeByReplacingHiddenDigits1736 {
    public String maximumTime(String time) {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<5; i++){
            if (time.charAt(i) != '?'){
                sb.append(time.charAt(i));
            }
            else {
                switch (i){
                    case 0:
                        if (time.charAt(1) > '3' && time.charAt(1) < '9'){
                            sb.append("1");
                        }
                        else {
                            sb.append("2");
                        }
                        break;
                    case 1:

                        if (sb.charAt(0) == '2'){
                            sb.append("3");
                        }
                        else {
                            sb.append("9");
                        }
                        break;
                    case 3:
                        sb.append("5");
                        break;
                    case 4:
                        sb.append("9");
                        break;
                    default:
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LatestTimeByReplacingHiddenDigits1736 latestTimeByReplacingHiddenDigits1736 = new LatestTimeByReplacingHiddenDigits1736();
        System.out.println(latestTimeByReplacingHiddenDigits1736.maximumTime("??:??"));
    }
}
