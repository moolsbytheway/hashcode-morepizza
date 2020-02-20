package model;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

public class Order {

    public static OrderOutput order(OrderInput input) {
        final Integer max = input.getMaxSlices();

        AtomicReference<Integer> leftAfter = new AtomicReference<>(max);
        List<Pizza> pizzas = new ArrayList<>();


        Map<Integer, Integer> pizzasMap = sortByValue(input.getNumberOfSlicesPerPizza());


        pizzasMap.keySet().forEach((key) -> {
            Integer value = pizzasMap.get(key);
            Integer newLeftAfter = leftAfter.get() - value;
            if (newLeftAfter >= 0) {
                pizzas.add(new Pizza(value, key));
                leftAfter.set(newLeftAfter);
            }
        });


        OrderOutput output = new OrderOutput();
        output.setOrderedPizzas(pizzas);
        output.setNumberOfPizzaTypes(pizzas.size());

        return output;
    }

    private static Map<Integer, Integer> sortByValue(Map<Integer, Integer> hm) {
        // thank you stackoverflow.com :)

        // Create a list from elements of HashMap
        List<Map.Entry<Integer, Integer>> list =
                new LinkedList<>(hm.entrySet());

        // Sort the list
        list.sort((o1, o2) -> o1.getValue() > o2.getValue() ? -1 : 1);

        // put data from sorted list to hashmap
        HashMap<Integer, Integer> temp = new LinkedHashMap<>();
        for (Map.Entry<Integer, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }

}
