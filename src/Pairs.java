import java.util.HashSet;
import java.util.Set;

public class Pairs {
    // Complete the pairs function below.
    static int pairs(int k, int[] arr) {
        final Set<Integer> pairSet = new HashSet<>();
        int ans = 0;
        for (int a: arr) {
            if (pairSet.contains(a+k)){
                ans++;
            }
            if (pairSet.contains(a-k)) {
                ans++;
            }
            pairSet.add(a);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(pairs(2, new int[]{1,5,3,4,2}) == 3);
        System.out.println(pairs(1, new int[]{1,2,3,4}) == 3);
        System.out.println(pairs(-1, new int[]{1,2,3,4}) == 3);
    }
}
