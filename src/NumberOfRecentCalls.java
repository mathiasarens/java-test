import java.util.Map;
import java.util.TreeMap;

public class NumberOfRecentCalls {
    private TreeMap<Integer, Integer> map = new TreeMap<>();
    private int lastTime = 0;

    public int ping(int t) {
        map.put(t, map.getOrDefault(lastTime, 0) + 1);
        int sum = map.get(t);
        Integer key = map.floorKey(t - 3001);
        if (key != null) {
            sum -= map.get(key);
        }
        lastTime = t;
        return sum;
    }

    public static void main(String[] args) {
        NumberOfRecentCalls numberOfRecentCalls = new NumberOfRecentCalls();
        System.out.println(numberOfRecentCalls.ping(1));
        System.out.println(numberOfRecentCalls.ping(100));
        System.out.println(numberOfRecentCalls.ping(3001));
        System.out.println(numberOfRecentCalls.ping(3002));
    }
}





