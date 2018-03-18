package algorithms;

/**
 * Created by AlphaGo on 3/15/2018.
 */
public class KthBiggest {
    public static void main(String[] args) {
        int k = 3;
        int[] array = {23,10,2,-3,5,122,7};
        System.out.println(kthBiggest(array,k));
    }

    public static int kthBiggest(int[] array,int k) {
        int[] a = new int[k];
        for(int i = 0 ; i < k ; i++) {
            a[i] = array[i];
        }
        InsertionSort.insertionSelectDesc(a);
        for(int j = k; j < array.length; j++) {
            if(array[j] > a[k-1]) {
                for(int p = 0; p < k; p++) {
                    if(array[j] > a[p]) {
                        a[p] = array[j];
                        p = k; // we found the insertion position,terminate the iteration.
                    }
                }
            }
        }
        return a[k-1];
    }
}
