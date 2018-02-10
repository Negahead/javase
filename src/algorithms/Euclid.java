package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Euclid {
    public static void main(String[] args) {
        System.out.println(euclid(1680,640));
        int[] a = {1,2,3,4,5};
        int[] b = Arrays.copyOfRange(a,0,2);
        Arrays.stream(b).forEach(System.out::println);
        System.out.println(iterSum(a));
        ArrayList<Integer> c = new ArrayList<>();
        System.out.println("=============================");
        c.add(12);
        c.add(23);
        c.add(2);
        c.add(56);
        c.add(67);
        c.add(89);

        List<Integer> re = quickSort(c);
        re.forEach(System.out::println);
    }

    private static int euclid(int m,int n) {
        int r = m % n;
        if (r == 0) {
            return n;
        }
        return euclid(n, r);
    }

    private static int iterSum(int[] array) {
        if(array.length == 0) {
            return 0;
        }
        return array[0] + iterSum(Arrays.copyOfRange(array,1,array.length));
    }

    private static List<Integer> quickSort(List<Integer> array) {
        if(array.size() < 2) {
            return array;
        }
        int pivot = array.get(0);
        List<Integer> less = part(array,pivot,-1);
        List<Integer> more = part(array,pivot,1);

        quickSort(less).add(pivot);
        less.addAll(quickSort(more));
        return less;
    }

    private static List<Integer> part(List<Integer> array,int pivot,int flag) {
        List<Integer> result = new ArrayList<>();
        if(flag < 0) {
            for(int i = 0; i < array.size() ; i++) {
                if(array.get(i) < pivot) {
                    result.add(array.get(i));
                }
            }
        }
        if(flag > 0) {
            for(int i = 0; i < array.size() ; i++) {
                if(array.get(i) > pivot) {
                    result.add(array.get(i));
                }
            }
        }
        return result;
    }
}
