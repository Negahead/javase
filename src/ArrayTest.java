public class ArrayTest {
    public static void main(String[] args) {
        String[] s = "2,9,6,4,3".split(",");
        int arr1[] = {0,1,2,3,4,5};
        int arr2[] = {5,6,7,8,9,10,11};

        System.arraycopy(arr1,1,arr2,2,5);
        for(int i = 0; i < arr2.length; i++) {
            System.out.println(arr2[i]);
        }
    }
}
