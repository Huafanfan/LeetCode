package easy;

public class GrumpyBookstoreOwner1052 {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int len = customers.length;
        int maxCustomerUnhappy = 0;
        int index = 0;
        for (int i=0; i<len; i++){
            int customerUnhappy = 0;
            int j=i;
            while (j<len && j < i + X){
                if (grumpy[j] == 1){
                    customerUnhappy += customers[j];
                }
                j++;
            }
            if (customerUnhappy > maxCustomerUnhappy){
                maxCustomerUnhappy = customerUnhappy;
                index = i;
            }
        }
        for (int i=index; i<len && i<index + X; i++){
            grumpy[i] = 0;
        }
        int res = 0;
        for (int i=0; i<len; i++){
            if (grumpy[i] == 0){
                res += customers[i];
            }
        }
        return res;
    }

    public int maxSatisfied2(int[] customers, int[] grumpy, int X) {
        int total = 0;
        int n = customers.length;
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                total += customers[i];
            }
        }
        int increase = 0;
        for (int i = 0; i < X; i++) {
            increase += customers[i] * grumpy[i];
        }
        int maxIncrease = increase;
        for (int i = X; i < n; i++) {
            increase = increase - customers[i - X] * grumpy[i - X] + customers[i] * grumpy[i];
            maxIncrease = Math.max(maxIncrease, increase);
        }
        return total + maxIncrease;
    }

    public static void main(String[] args) {
        GrumpyBookstoreOwner1052 grumpyBookstoreOwner1052 = new GrumpyBookstoreOwner1052();
        int[] customers = new int[]{1,0,1,2,1,1,7,5};
        int[] grumpy = new int[]{0,1,0,1,0,1,0,1};
        System.out.println(grumpyBookstoreOwner1052.maxSatisfied(customers, grumpy, 3));
    }
}
