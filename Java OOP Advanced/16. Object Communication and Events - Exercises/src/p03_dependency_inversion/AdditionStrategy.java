package p03_dependency_inversion;

public class AdditionStrategy implements Strategy {

    @Override
    public int calculate(int firstOperand, int secondOperand){
        return firstOperand + secondOperand;
    }
}
