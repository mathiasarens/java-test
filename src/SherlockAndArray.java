import java.util.Arrays;
import java.util.List;

// https://www.hackerrank.com/contests/saggezza-coding-test/challenges/sherlock-and-array
public class SherlockAndArray {

    // Complete the balancedSums function below.
    static String balancedSums(final List<Integer> arr) {
        int sumLeft = 0;
        int sumRight = arr.stream().skip(1).mapToInt(Integer::intValue).sum();
        int i = 0;
        while (sumLeft != sumRight && i < arr.size()-1) {
            sumLeft += arr.get(i);
            sumRight -= arr.get(i+1);
            i++;
        }
        return sumLeft == sumRight ? "YES": "NO";
    }

    public static void main(String[] args) {
        System.out.println(balancedSums(Arrays.asList(1,2,3)).equals("NO"));
        System.out.println(balancedSums(Arrays.asList(1,2,3,3)).equals("YES"));
        System.out.println(balancedSums(Arrays.asList(1,1,4,1,1)).equals("YES"));
        System.out.println(balancedSums(Arrays.asList(2,0,0,0)).equals("YES"));
        System.out.println(balancedSums(Arrays.asList(0,0,2,0)).equals("YES"));
    }
}
