public class FizzBuzz{
    private int start;
    private int stop;

    public FizzBuzz(int start, int stop){
        this.start=start;
        this.stop=stop;
    }
    public void play(){
        for (int i=start; i<=stop; i++){
            if (((i%3)==0) && ((i%5)==0)){
                System.out.println("fizzbuzz");
            }
            else if ((i%3)==0) System.out.println("Fizz");
            else if((i%5)==0) System.out.println("Buzz");
            else System.out.println(i);
        }
    }
}