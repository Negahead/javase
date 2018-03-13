package algorithms;

import java.util.Arrays;

/**
 * Created by AlphaGo on 3/12/2018.
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] list = {100,9};
        mergeSort(list);
        for (int p = 0; p < list.length; p++) {
            System.out.println(list[p]);
        }
    }

    private static void mergeSort(int[] array) {
        if (array.length > 1) {
            int mid = array.length / 2;
            int[] leftHalf = Arrays.copyOfRange(array, 0, mid); // 0:inclusive,mid:exclusive
            int[] rightHalf = Arrays.copyOfRange(array, mid, array.length);

            mergeSort(leftHalf);
            mergeSort(rightHalf);

            int i = 0;
            int j = 0;
            int k = 0;
            while (i < leftHalf.length && j < rightHalf.length) {
                if (leftHalf[i] < rightHalf[j]) {
                    array[k] = leftHalf[i];
                    i = i + 1;
                } else {
                    array[k] = rightHalf[j];
                    j = j + 1;
                }
                k = k + 1;
            }
            while (i < leftHalf.length) {
                array[k] = leftHalf[i];
                i = i + 1;
                k = k + 1;
            }
            while (j < rightHalf.length) {
                array[k] = rightHalf[j];
                j = j + 1;
                k = k + 1;
            }
        }
    }
}
