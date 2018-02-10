package algorithms;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {23,45,125,67,3,56,7,2,5,8,66};
        Arrays.sort(array);
        Arrays.stream(array).forEach(System.out::println);
        System.out.println();
        int index = binarySearch(array,70);
        System.out.println("item index is " + index);
    }

    private static int  binarySearch(int[] sortedArray,int item) {
        int low = 0;
        int high = sortedArray.length - 1;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(sortedArray[mid] < item) {
                low = mid + 1;
            }
            if(sortedArray[mid] > item) {
                high = mid - 1;
            }
            if(sortedArray[mid] == item) {
                return mid;
            }
        }
        return -1;
    }
}
