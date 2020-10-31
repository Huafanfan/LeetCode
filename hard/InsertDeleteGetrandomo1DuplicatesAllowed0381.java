package hard;

import java.util.*;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/10/31 09:13
 */
public class InsertDeleteGetrandomo1DuplicatesAllowed0381 {
    class RandomizedCollection {
        private HashMap<Integer, List<Integer>> index;
        private ArrayList<Integer> validIndex;
        private ArrayList<Integer> table;
        private Integer length;
        /** Initialize your data structure here. */
        public RandomizedCollection() {
            index = new HashMap<>();
            validIndex = new ArrayList<>();
            table = new ArrayList<>();
            length = 0;
        }

        /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
        public boolean insert(int val) {
            if (!index.containsKey(val)){
                table.add(val);
                length++;
                List<Integer> list = new ArrayList<>();
                list.add(table.size()-1);
                index.put(val, list);
                validIndex.add(table.size()-1);
                return true;
            }
            else {
                List<Integer> list = index.get(val);
                table.add(val);
                length++;
                list.add(table.size()-1);
                index.put(val, list);
                validIndex.add(table.size()-1);
                return false;
            }
        }

        /** Removes a value from the collection. Returns true if the collection contained the specified element. */
        public boolean remove(int val) {
            if (!index.containsKey(val)){
                return false;
            }
            List<Integer> list = index.get(val);
            validIndex.remove(list.get(list.size()-1));
            list.remove(list.size()-1);
            length--;
            if (list.size()==0){
                index.remove(val);
            }
            return true;
        }

        /** Get a random element from the collection. */
        public int getRandom() {
            Random random = new Random();
            int i = random.nextInt(length);
            return table.get(validIndex.get(i));
        }
    }
    class RandomizedCollection2 {
        Map<Integer, Set<Integer>> idx;
        List<Integer> nums;

        /** Initialize your data structure here. */
        public RandomizedCollection2() {
            idx = new HashMap<Integer, Set<Integer>>();
            nums = new ArrayList<Integer>();
        }

        /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
        public boolean insert(int val) {
            nums.add(val);
            Set<Integer> set = idx.getOrDefault(val, new HashSet<Integer>());
            set.add(nums.size() - 1);
            idx.put(val, set);
            return set.size() == 1;
        }

        /** Removes a value from the collection. Returns true if the collection contained the specified element. */
        public boolean remove(int val) {
            if (!idx.containsKey(val)) {
                return false;
            }
            Iterator<Integer> it = idx.get(val).iterator();
            int i = it.next();
            int lastNum = nums.get(nums.size() - 1);
            nums.set(i, lastNum);
            idx.get(val).remove(i);
            idx.get(lastNum).remove(nums.size() - 1);
            if (i < nums.size() - 1) {
                idx.get(lastNum).add(i);
            }
            if (idx.get(val).size() == 0) {
                idx.remove(val);
            }
            nums.remove(nums.size() - 1);
            return true;
        }

        /** Get a random element from the collection. */
        public int getRandom() {
            return nums.get((int) (Math.random() * nums.size()));
        }
    }
}
