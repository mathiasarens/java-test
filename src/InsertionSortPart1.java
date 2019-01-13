import java.util.Arrays;
import java.util.stream.Collectors;

public class InsertionSortPart1 {
    // Complete the insertionSort1 function below.
    static void insertionSort1(int n, int[] arr) {
        int i = n-1;
        final int unsortedValue = arr[i];
        while (i > 0 && arr[i-1] > unsortedValue) {
            arr[i] = arr[i-1];
            System.out.println(Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
            i--;
        }
        arr[i] = unsortedValue;
        System.out.println(Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
    }

    public static void main(String[] args) {
        insertionSort1(5, new int[]{2,4,6,8,3});
    }
}
