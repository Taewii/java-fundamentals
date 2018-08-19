package p03_dependency_inversion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        AdditionStrategy addition = new AdditionStrategy();
        SubtractionStrategy subtraction = new SubtractionStrategy();
        DivisionStrategy division = new DivisionStrategy();
        MultiplicationStrategy multiplication = new MultiplicationStrategy();

        PrimitiveCalculator calculator = new PrimitiveCalculator(addition, subtraction, division, multiplication);

        String input;
        while (!"End".equals(input = reader.readLine())) {
            String[] tokens = input.split(" ");

           try {
               int firstNum = Integer.parseInt(tokens[0]);
               int secondNum = Integer.parseInt(tokens[1]);

               System.out.println(calculator.performCalculation(firstNum, secondNum));
           } catch (Exception ex) {
               calculator.changeStrategy(tokens[1].charAt(0));
           }
        }
    }
}
