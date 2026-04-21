package lab5.advanced;

public class DoubleCalculator extends ACalculator{

    @Override
    public void init(Object initialValue)
    {
        this.state = (Double) initialValue;
    }

    public DoubleCalculator add(double x)
    {
        state = (Double) state + x;
        return this;
    }

    public DoubleCalculator substract(double x)
    {
        state = (Double) state - x;
        return this;
    }

    public  DoubleCalculator multiply(double x)
    {
        state = (Double) state * x;
        return this;
    }
}