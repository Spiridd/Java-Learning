import java.util.Arrays;

/**
 * Created by dimon on 05.07.17.
 */
public class Merge {
    public static void main(String[] args) {
        int[] a1 = {6};
        int[] a2 = {1, 3, 5};
        int[] a3 = mergeArrays(a1, a2);
        System.out.println(Arrays.toString(a1));
        System.out.println(Arrays.toString(a2));
        System.out.println(Arrays.toString(a3));
    }

    public static int[] mergeArrays(int[] a1, int[] a2) {
        int a1_length = a1.length;
        int a2_length = a2.length;
        int result_length = a1_length + a2_length;
        int[] result = new int[result_length];
        int i = 0;
        int j = 0;
        while( i + j < result_length ) {
            if( i < a1_length ) {
                if( j < a2_length ) {
                    if( a1[i] <= a2[j] ) {
                        result[i+j] = a1[i++];
                    } else {
                        result[i+j] = a2[j++];
                    }
                } else {
                    result[i+j] = a1[i++];
                }
            } else {
                result[i+j] = a2[j++];
            }
        }
        return result;
    }
}
