package lab5;

public class IntCalculator {
   public int state;

   public IntCalculator add(int x){
      state +=x;
      return this;
   }

   public IntCalculator substract(int x){
       state -=x;
       return this;

   }

    public IntCalculator multiply(int x){
        state *=x;
        return this;

    }

   public int result() {
       return state;
   }

   public void clear(){
       state=0;
   }

   public IntCalculator(int state){
       this.state=state;
   }
}
