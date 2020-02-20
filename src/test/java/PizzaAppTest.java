import model.Order;
import model.OrderInput;
import model.OrderOutput;
import model.Pizza;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PizzaAppTest {

    private OrderInput pizzaInput;
    private OrderOutput pizzaOutput;

    @Before
    public void before() {
        List<String> lines = Arrays.asList("17 4", "2 5 6 8");
        pizzaInput = new OrderInput(lines);


        pizzaOutput = new OrderOutput();
        pizzaOutput.setNumberOfPizzaTypes(3);

        List<Pizza> orderedPizzas = new ArrayList<>();
        orderedPizzas.add(new Pizza(2, 0));
        orderedPizzas.add(new Pizza(6, 2));
        orderedPizzas.add(new Pizza(8, 3));
        pizzaOutput.setOrderedPizzas(orderedPizzas);


    }

    @Test
    public void shouldParseInputDataSet() {

        System.out.println("Input");
        System.out.println(pizzaInput);

        assertEquals(4, pizzaInput.getNumberOfTypes().intValue());
        assertEquals(17, pizzaInput.getMaxSlices().intValue());
    }

    @Test
    public void shouldReturnOutput() {
        System.out.println("Output");
        System.out.println(pizzaOutput);

        assertEquals(3, pizzaOutput.getNumberOfPizzaTypes().intValue());
        assertEquals(0, pizzaOutput.getOrderedPizzas().get(0).getId().intValue());
        assertEquals(2, pizzaOutput.getOrderedPizzas().get(1).getId().intValue());
        assertEquals(3, pizzaOutput.getOrderedPizzas().get(2).getId().intValue());
    }
}
