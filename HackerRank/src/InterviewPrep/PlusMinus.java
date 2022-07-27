package InterviewPrep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//TODO: Print the following  lines, each to  decimals:
//            proportion of positive values
//            proportion of negative values
//            proportion of zeros
//            Sample Input
//            STDIN           Function
//            -----           --------
//            6               arr[] size n = 6
//            -4 3 -9 0 4 1   arr = [-4, 3, -9, 0, 4, 1]
//            Sample Output
//            0.500000
//            0.333333
//            0.166667

public class PlusMinus {
    public static void plusMinus(List<Integer> arr) {
        // Write your code here
        float numOfPos = 0;
        float numOfNegs = 0;
        float numOfZeros = 0;

        for (int i = 0; i < arr.size(); i++) {
            if  (arr.get(i) > 0) {
                numOfPos++;
            } else if (arr.get(i) < 0) {
                numOfNegs++;
            } else {
                numOfZeros++;
            }
        }
        System.out.printf("%.6f\n", numOfPos/arr.size());
        System.out.printf("%.6f\n", numOfNegs/arr.size());
        System.out.printf("%.6f", numOfZeros/arr.size());
    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(Arrays.asList(-4, 3, -9, 0, 4, 1));
        plusMinus(arr);
    }
}
