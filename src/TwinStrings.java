import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TwinStrings {
    // Complete the twins function below.
    static List<String> twins(List<String> a, List<String> b) {
        List<String> result = new ArrayList<String>();
        for (int i = 0; i < a.size(); i++) {
            List<String> aEven = new ArrayList<String>();
            List<String> aOdd = new ArrayList<String>();
            for (int j = 0; j < a.get(i).length(); j++) {
                if (j % 2 == 0) {
                    aEven.add(String.valueOf(a.get(i).charAt(j)));
                } else {
                    aOdd.add(String.valueOf(a.get(i).charAt(j)));
                }
            }
            Collections.sort(aEven);
            Collections.sort(aOdd);
            List<String> bEven = new ArrayList<String>();
            List<String> bOdd = new ArrayList<String>();
            for (int j = 0; j < b.get(i).length(); j++) {
                if (j % 2 == 0) {
                    bEven.add(String.valueOf(b.get(i).charAt(j)));
                } else {
                    bOdd.add(String.valueOf(b.get(i).charAt(j)));
                }
            }
            Collections.sort(bEven);
            Collections.sort(bOdd);
            result.add(aEven.equals(bEven) && aOdd.equals(bOdd) ?"Yes":"No");
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(String.join(",", twins(Arrays.asList("cdab", "dcba", "abcd"), Arrays.asList("abcd", "abcd", "abcdcd"))));
//        System.out.println(String.join(",", twins(Arrays.asList( "dcba"), Arrays.asList("abcd"))));
    }

}
