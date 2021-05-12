package medium;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/5/12 09:19
 */
public class XorQueriesOfaSubarray1310 {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] xors = new int[arr.length];
        xors[0] = arr[0];
        for (int i=1; i<xors.length; i++){
            xors[i] = arr[i] ^ xors[i-1];
        }
        int[] res = new int[queries.length];
        for (int i=0; i<res.length; i++){
            if (queries[i][0] == 0){
                res[i] = xors[queries[i][1]];
            }
            else {
                res[i] = xors[queries[i][1]] ^ xors[queries[i][0] - 1];
            }
        }
        return res;
    }
}
