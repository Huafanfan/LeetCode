package medium.dp;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/10 17:43
 */
public class PushDominoes0838 {
    public String pushDominoes(String dominoes) {
        StringBuilder result = new StringBuilder();
        String dummp = "L" + dominoes + "R";
        int length = dummp.length();
        for (int i=0; i<length;){
            int j=0;
            if (dummp.charAt(i)=='L'){
                j=i+1;
                for (; j<length; j++){
                    if (dummp.charAt(j)!='.'){
                        break;
                    }
                }
                if (dummp.charAt(j)=='L'){
                    for (int k=0; k< j-i+1; k++){
                        result.append("L");
                    }
                }
                else {
                    result.append("L");
                    for (int k=1; k< j-i; k++){
                        result.append(".");
                    }
                    result.append("R");
                }
                i += j-i+1;
            }
            else if (dummp.charAt(i)=='R'){
                j=i+1;
                for (; j<length; j++){
                    if (dummp.charAt(j)!='.'){
                        break;
                    }
                }
                if (j==length){
                    result.append("R");
                    break;
                }
                if (dummp.charAt(j)=='R'){
                    for (int k=0; k< j-i+1; k++){
                        result.append("R");
                    }
                }
                else {
                    if ((j-i) % 2 == 0){
                        int mid = (j+i)/2;
                        int temp = i;
                        while (temp!=mid){
                            result.append("R");
                            temp++;
                        }
                        result.append(".");
                        temp++;
                        while (temp<=j){
                            result.append("L");
                            temp++;
                        }
                    }
                    else {
                        int mid = (j+i)/2;
                        int temp = i;
                        while (temp<=mid){
                            result.append("R");
                            temp++;
                        }
                        while (temp<=j){
                            result.append("L");
                            temp++;
                        }
                    }
                }
                i += j-i+1;
            }
            else {
                result.append(".");
                i++;
            }
        }
        return result.substring(1,result.length()-1);
    }

    public static void main(String[] args) {
        String dominoes = ".L.R...LR..L..";
        //String dominoes = "RR.L";
        //String dominoes = ".L.R.";
        PushDominoes0838 pushDominoes0838 = new PushDominoes0838();
        System.out.println(pushDominoes0838.pushDominoes(dominoes));
    }
}
