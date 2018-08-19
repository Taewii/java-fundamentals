package p03_dependency_inversion;

public class PrimitiveCalculator {

    private Strategy addition;
    private Strategy subtraction;
    private Strategy division;
    private Strategy multiplication;
    private Strategy currentStrategy;

    public PrimitiveCalculator(AdditionStrategy addition, SubtractionStrategy subtraction,
                               DivisionStrategy division, MultiplicationStrategy multiplication) {
        this.addition = addition;
        this.subtraction = subtraction;
        this.division = division;
        this.multiplication = multiplication;
        this.currentStrategy = addition;
    }

    public void changeStrategy(char operator) {
        switch (operator) {
            case '+':
                this.currentStrategy = this.addition;
                break;
            case '-':
                this.currentStrategy = this.subtraction;
                break;
            case '*':
                this.currentStrategy = this.multiplication;
                break;
            case '/':
                this.currentStrategy = this.division;
                break;
        }
    }

    public int performCalculation(int firstOperand, int secondOperand) {
        return this.currentStrategy.calculate(firstOperand, secondOperand);
    }
}
