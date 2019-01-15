import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

public class MissingNumbers {

    // Complete the missingNumbers function below.
    static int[] missingNumbers(int[] arr, int[] brr) {
        final TreeMap<Integer, Integer> numMap = new TreeMap<>();
        Arrays.stream(brr).forEach(num->numMap.merge(num, 1, Integer::sum));
        for (int num: arr) {
            numMap.merge(num, -1, Integer::sum);
            if (numMap.get(num) <= 0) {
                numMap.remove(num);
            }
        }
        return numMap.keySet().stream().mapToInt(Integer::intValue).toArray();
    }

    // The array items can be unordered in the new list
    static int[] missingNumbers_Wrong(int[] arr, int[] brr) {
        int differenceMax = brr.length - arr.length;
        int i = 0;
        int j = 0;
        final Set<Integer> differenceList = new HashSet<>();
        int differenceCount = 0;
        while (differenceCount < differenceMax && j < brr.length) {
            if (i < arr.length && arr[i] == brr[j]) {
                i++;
                j++;
            } else {
                differenceCount++;
                differenceList.add(brr[j]);
                j++;
            }
        }
        return differenceList.stream().mapToInt(Integer::intValue).sorted().toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.equals(missingNumbers(new int[]{203,204,205,206,207,208,203,204,205,206}, new int[]{203,204,204,205,206,207,205,208,203,206,205,206,204}), new int[] {204,205,206}));
        System.out.println(Arrays.equals(missingNumbers(new int[]{203,204,205,206,207,208,203,204,205,206}, new int[]{203,204,210,204,205,206,207,205,208,203,206,205,206,204}), new int[] {204,205,206,210}));
        System.out.println(Arrays.equals(missingNumbers(new int[]{203,204,205,206,207,208,203,204,205,206}, new int[]{203,204,205,206,207,208,203,204,205,206}), new int[] {}));
        System.out.println(Arrays.equals(missingNumbers(new int[]{11,4,11,7,13,4,12,11,10,14}, new int[]{11,4,11,7,3,7,10,13,4,8,12,11,10,14,12}), new int[] {3,7,8,10,12}));
        System.out.println(Arrays.equals(missingNumbers(new int[]{11}, new int[]{11,4,11}), new int[] {4,11}));
        System.out.println(Arrays.equals(missingNumbers(new int[]{11}, new int[]{11,4,11,1}), new int[] {1,4,11}));
        System.out.println(Arrays.equals(missingNumbers(new int[]{}, new int[]{11,4,11,1}), new int[] {1,4,11}));
        System.out.println(Arrays.equals(missingNumbers(new int[]{11}, new int[]{12,11}), new int[] {12}));
    }
}
