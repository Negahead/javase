package algorithms;

/**
 * Created by AlphaGo on 3/12/2018.
 */
public class ShellSort {
    public static void main(String[] args) {

    }
    private static void shellSort(int[] array) {
        for(int gap = array.length / 2; gap < array.length; gap++) {
            for(int i = gap; i < array.length; i++) {
                int temp = array[i];
                int j;
                for(int j = i; j >= gap && (temp-array[j - gap] < 0); j -= gap) {
                    array[j] = array[j - gap];
                }
                array[j] = temp;
            }
        }
    }
}
