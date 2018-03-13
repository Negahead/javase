package algorithms;

import java.util.Date;
import java.util.Random;

public class InsertionSort {
    public static void main(String[] args) {
        Random random = new Random((new Date()).getTime());
        int[] ints = new int[10000000];
        for(int i = 0 ; i < ints.length; i++) {
            ints[i] = random.nextInt();
        }
        System.out.println("10000000 ints generated");
        insertionSelect(ints);
        for(int k = 0; k < ints.length; k++) {
            System.out.println(ints[k]);
        }
    }

    private static void insertionSelect(int[] array) {
        int j;
        for(int p = 1; p < array.length; p++) {
            int temp = array[p];
            for(j=p; j>0 && (temp-array[j-1] < 0); j--) {
                array[j] = array[j-1];
            }
            array[j] = temp;
        }
    }
}


