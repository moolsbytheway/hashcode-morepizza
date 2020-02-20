import model.Order;
import model.OrderInput;
import model.OrderOutput;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class PizzaApp {

    public static void main(String[] args) throws IOException {

        if (args == null || args.length != 2) {
            System.err.println("usage : PizzaApp input_file output_file");
            return;
        }

        final Scanner in = new Scanner(new FileInputStream(args[0]));

        final FileOutputStream output = new FileOutputStream(args[1]);
        String line = in.nextLine();

        final String[] firstLine = line.split(" ");

        Integer maxSlices = Integer.valueOf(firstLine[0]);
        Integer numberOfTypes = Integer.valueOf(firstLine[1]);

        OrderInput orderInput = new OrderInput(maxSlices, numberOfTypes);
        orderInput.addSlices(in.nextLine());


        OrderOutput orderOutput = Order.order(orderInput);
        writeLine(output, orderOutput.toString());

        in.close();
        output.flush();
        output.close();
    }

    private static void writeLine(final FileOutputStream output,
                                  final String line) throws IOException {
        output.write(line.getBytes());
        output.write("\n".getBytes());
    }
}
