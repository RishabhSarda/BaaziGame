import java.util.*;
import java.io.*;

class Q1 {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(6);
        Integer sum = 0;
        for(Integer a: arr)
            sum += a;
        Integer firstArr = 0;
        Integer lastArr = sum - arr.get(0);
        for(int i=1; i<arr.size()-1; i++){
            lastArr -= arr.get(i);
            firstArr += arr.get(i-1);
            if(firstArr == lastArr){
                System.out.println("Pivot is: " +i);
                break;
            }
        }
    }
}