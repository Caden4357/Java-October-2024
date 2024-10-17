import java.util.ArrayList;
public class Algo {
    public String greeting(String name) {
        return "Hello " + name;
    }
    // birthdayCakeCandles
    // You are in charge of the cake for a child's birthday. You have decided the
    // cake will have one candle for each year of their total age. They will only be
    // able to blow out the tallest of the candles. Count how many candles are
    // tallest.
    // ex input: [4,4,1,3,6,5,4,2] return 2 because 4 is the tallest candle and theres 2
    // of them
    //
    // * write a method that takes in an array and returns an int 
    // * create a var for tallest candle which will be the first num in the array 
    // * we need to figure out which candle is the tallest for loop, conditional, if (arr[i] > tallestCandle) or if its equal these are 2 different conditionals
    public int birthdayCakeCandles(ArrayList<Integer> candles){
        if(candles.size() == 0){
            return 0;
        }
        int tallestCandle = candles.get(0);
        int count = 1;
        for(int idx = 1; idx < candles.size(); idx++){
            if(candles.get(idx) > tallestCandle){
                tallestCandle = candles.get(idx);
                count = 1;
            }
            else if(candles.get(idx) == tallestCandle){
                count++;
            }
        }
        return count;
    }
}
