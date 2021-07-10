package medium;

import java.util.*;

public class DisplayTableOfFoodOrdersInARestaurant1418 {
    public List<List<String>> displayTable(List<List<String>> orders) {
        Map<String, Map<String, Integer>> tableToFood = new HashMap<>();
        Set<String> tableNum = new HashSet<>();
        Set<String> foodName = new HashSet<>();
        for (List<String> order : orders){
            tableNum.add(order.get(1));
            foodName.add(order.get(2));
            Map<String, Integer> food = tableToFood.getOrDefault(order.get(1), new HashMap<>());
            food.put(order.get(2), food.getOrDefault(order.get(2), 0) + 1);
            tableToFood.put(order.get(1), food);
        }
        List<String> tableNumList = new ArrayList<>(tableNum);
        List<String> foodNameList = new ArrayList<>(foodName);
        Collections.sort(tableNumList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.valueOf(o1) - Integer.valueOf(o2);
            }
        });
        Collections.sort(foodNameList);
        List<List<String>> res = new ArrayList<>();
        foodNameList.add(0, "Table");
        res.add(new ArrayList<>(foodNameList));
        foodNameList.remove(0);
        for (int i=0; i<tableNumList.size(); i++){
            List<String> tableFood = new ArrayList<>();
            tableFood.add(tableNumList.get(i));
            for (String food : foodNameList){
                Integer num = tableToFood.get(tableNumList.get(i)).get(food);
                tableFood.add(String.valueOf(num == null ? "0" : num));
            }
            res.add(tableFood);
        }
        return res;
    }

    public static void main(String[] args) {
        //orders = [["David","3","Ceviche"],["Corina","10","Beef Burrito"],["David","3","Fried Chicken"],["Carla","5","Water"],["Carla","5","Ceviche"],["Rous","3","Ceviche"]]
        List<List<String>> orders = new ArrayList<>();
        orders.add(new ArrayList<String>(Arrays.asList(new String[]{"David","3","Ceviche"})));
        orders.add(new ArrayList<String>(Arrays.asList(new String[]{"Corina","10","Beef Burrito"})));
        orders.add(new ArrayList<String>(Arrays.asList(new String[]{"David","3","Fried Chicken"})));
        orders.add(new ArrayList<String>(Arrays.asList(new String[]{"Carla","5","Water"})));
        orders.add(new ArrayList<String>(Arrays.asList(new String[]{"Carla","5","Ceviche"})));
        orders.add(new ArrayList<String>(Arrays.asList(new String[]{"Rous","3","Ceviche"})));
        DisplayTableOfFoodOrdersInARestaurant1418 displayTableOfFoodOrdersInARestaurant1418 = new DisplayTableOfFoodOrdersInARestaurant1418();
        System.out.println(displayTableOfFoodOrdersInARestaurant1418.displayTable(orders));
    }
}
