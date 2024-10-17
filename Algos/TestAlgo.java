import java.util.ArrayList;

public class TestAlgo {
    public static void main(String[] args) {
        Algo algo = new Algo();
        System.out.println(algo.greeting("World"));
        ArrayList<Integer> candles = new ArrayList<Integer>();
        candles.add(4);
        candles.add(4); 
        candles.add(1);
        candles.add(3);
        System.out.println(algo.birthdayCakeCandles(candles));
    }
}
