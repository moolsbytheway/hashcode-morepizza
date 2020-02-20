package model;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class OrderOutput {
    private Integer numberOfPizzaTypes;
    private List<Pizza> orderedPizzas;

    public OrderOutput() {
    }

    public Integer getNumberOfPizzaTypes() {
        return numberOfPizzaTypes;
    }

    public void setNumberOfPizzaTypes(Integer numberOfPizzaTypes) {
        this.numberOfPizzaTypes = numberOfPizzaTypes;
    }

    public List<Pizza> getOrderedPizzas() {
        return orderedPizzas;
    }

    public void setOrderedPizzas(List<Pizza> orderedPizzas) {
        this.orderedPizzas = orderedPizzas;
    }

    @Override
    public String toString() {
        String firstLine = String.format("%d\n", getNumberOfPizzaTypes());
        StringBuilder secondLine = new StringBuilder();
        Collections.sort(orderedPizzas);
        orderedPizzas.forEach(pizza -> {
            secondLine.append(pizza.getId());
            secondLine.append(" ");
        });
        return firstLine.concat(secondLine.toString());

    }
}
