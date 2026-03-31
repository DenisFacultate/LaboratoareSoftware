package lab5.advanced;

import lab5.AdvancedCalculator;

public class NewIntCalculator extends ACalculator {

    @Override
    public void init(Object initialValue) {
        this.state = (Integer) initialValue;
    }

    public NewIntCalculator add(int x) {
        state = (Integer) state + x;
        return this;
    }

    public NewIntCalculator substract(int x) {
        state = (Integer) state - x;
        return this;
    }

    public NewIntCalculator multiply(int x) {
        state = (Integer) state * x;
        return this;
    }
}