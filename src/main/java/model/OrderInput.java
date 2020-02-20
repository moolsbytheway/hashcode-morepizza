package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderInput {
    private Integer maxSlices;
    private Integer numberOfTypes;
    private Map<Integer, Integer> numberOfSlicesPerPizza = new HashMap<>();

    public OrderInput(Integer maxSlices, Integer numberOfTypes) {
        this.maxSlices = maxSlices;
        this.numberOfTypes = numberOfTypes;
    }

    public void addSlices(String slices) {
        String[] slicesPerPizza = slices.split(" ");

        for (Integer pizzaIndex = 0; pizzaIndex < numberOfTypes; pizzaIndex++) {
            this.numberOfSlicesPerPizza.put(pizzaIndex,
                    Integer.valueOf(slicesPerPizza[pizzaIndex]));
        }
    }

    public OrderInput(List<String> lines) {
        String[] firstLine = lines.get(0).split(" ");

        this.maxSlices = Integer.valueOf(firstLine[0]);
        this.numberOfTypes = Integer.valueOf(firstLine[1]);


    }

    public Integer getMaxSlices() {
        return maxSlices;
    }

    public void setMaxSlices(Integer maxSlices) {
        this.maxSlices = maxSlices;
    }

    public Integer getNumberOfTypes() {
        return numberOfTypes;
    }

    public void setNumberOfTypes(Integer numberOfTypes) {
        this.numberOfTypes = numberOfTypes;
    }

    public Map<Integer, Integer> getNumberOfSlicesPerPizza() {
        return numberOfSlicesPerPizza;
    }

    public void setNumberOfSlicesPerPizza(Map<Integer, Integer> numberOfSlicesPerPizza) {
        this.numberOfSlicesPerPizza = numberOfSlicesPerPizza;
    }

    @Override
    public String toString() {
        String firstLine = String.format("%d %d\n", getMaxSlices(), getNumberOfTypes());
        StringBuilder secondLine = new StringBuilder();
        numberOfSlicesPerPizza.values().forEach(s -> {
            secondLine.append(s);
            secondLine.append(" ");
        });
        return firstLine.concat(secondLine.toString());

    }
}
