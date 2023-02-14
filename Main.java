import java.util.Arrays;

public class Main{
    public static void main(String[] args) throws Exception{
        Fibo fib = new Fibo();
        try {
            
            System.out.println("your number is: " + fib.fibo(Integer.parseInt(args[0])));
            System.out.println("the array leading to your number: " + Arrays.toString(fib.makeArray(Integer.parseInt(args[0]))));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("usage: java -jar project8 [The desired place to compute to in the fibonachi sequence.]"); 
        }
       
    }
}
class Fibo{
    long[] makeArray(int end){
        int currentPlace = 3;
        long currentValue = 1;
        long previousValue = 1;
        long[] a= new long[end];
        a[0]=1;
        a[1]=1;
        while(currentPlace - 1 < end){
            a[currentPlace - 1] = fiboArray(currentPlace,previousValue,currentValue);
            previousValue = currentValue;
            currentValue = a[currentPlace - 1];
            currentPlace++;
        }
        return a;
    }
    long fibo(int end){
        int currentPlace = 2;
        long currentValue = 1;
        long previousValue = 1;
        long valueHld;
        if (end == 1){
            return 1;
        }else if (currentPlace == end){
            return currentValue;
        }else{
            currentPlace++;
            valueHld = currentValue;
            currentValue = currentValue + previousValue;
            previousValue = valueHld;
            currentValue = fibo(end, previousValue, currentValue, currentPlace);
            return currentValue;
        }
    }
    long fibo(int end, long previousValue, long currentValue, int currentPlace){
        long valueHld;
        if (currentPlace == end){
            return currentValue;
        }else{
            currentPlace++;
            valueHld = currentValue;
            currentValue = currentValue + previousValue;
            previousValue = valueHld;
            currentValue = fibo(end, previousValue, currentValue, currentPlace);
            return currentValue;
        }
    }
    long fiboArray(int end, long previousValue, long currentValue){
        long valueHld;
        valueHld = currentValue;
        currentValue = currentValue + previousValue;
        previousValue = valueHld;
        return currentValue;
    }

}