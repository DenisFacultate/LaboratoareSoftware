package lab5;

public class AdvancedCalculator extends IntCalculator {
    public AdvancedCalculator(int state){
        super(state);
    }

    @Override
    public AdvancedCalculator add(int x){
        super.add(x);
        return this;
    }

    @Override
    public AdvancedCalculator substract(int x){
        super.substract(x);
        return this;
    }

    @Override
    public AdvancedCalculator multiply(int x){
        super.multiply(x);
        return this;
    }

    public AdvancedCalculator divide(int x){
        state /=x;
        return this;
    }

    public AdvancedCalculator pow(int x){
        state ^=x;
        return this;
    }

    public AdvancedCalculator rad(int x){
        state=state^1/x;
        return this;
    }
}
