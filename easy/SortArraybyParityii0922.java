package easy;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/11/12 09:29
 */
public class SortArraybyParityii0922 {
    public int[] sortArrayByParityII(int[] A) {
        for (int i=0; i<A.length; i++){
            if ((i & 1) == 0){
                if ((A[i] & 1) != 0){
                    for (int j=i+1; j<A.length; j++){
                        if ((A[j] & 1) == 0){
                            int temp = A[j];
                            A[j] = A[i];
                            A[i] = temp;
                            break;
                        }
                    }
                }
            }
            else {
                if ((A[i] & 1) != 1){
                    for (int j=i+1; j<A.length; j++){
                        if ((A[j] & 1) == 1){
                            int temp = A[j];
                            A[j] = A[i];
                            A[i] = temp;
                            break;
                        }
                    }
                }
            }
        }
        return A;
    }

    public int[] sortArrayByParityII2(int[] A) {
        int n = A.length;
        int j = 1;
        for (int i = 0; i < n; i += 2) {
            if ((A[i] & 1) == 1) {
                while ((A[j] & 1) == 1) {
                    j += 2;
                }
                int temp = A[j];
                A[j] = A[i];
                A[i] = temp;
            }
        }
        return A;
    }
}
