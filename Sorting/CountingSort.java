/**
 * Counting sort.
 * Based on Cormen, p. 195
 *
 * @author Peter Severin Rasmussen
 */
public class CountingSort {
    public static void main(String args[]) {
        int[] input = new int[] {1,2,3,45};
        int[] output = sort(input);
        System.out.println(java.util.Arrays.toString(output));
    }
    
    public static int[] sort(int[] a, int k) {
        int[] b = new int[a.length]; // Result
        int[] c = new int[k];        // Helper
        // Count number of occurrences
        for(int j = 0; j < a.length; j++) {
            c[a[j]]++;
        }
        // Accumulate
        for(int i = 1; i < k; i++) {
            c[i] += c[i-1];
        }
        // Sort by lookup
        for(int j = a.length-1; j >= 0; j--) {
            b[c[a[j]]-1] = a[j];
            c[a[j]]--;
        }
        return b;
    }
    
    public static int findMax(int[] list) {
        int max = -1;
        for(int i = 0; i < list.length; i++) {
            if (list[i] > max) {
                max = list[i];
            }
        }
        return max;
    }
    
    // Overload method that finds max
    public static int[] sort(int[] list) {
        return sort(list, findMax(list)+1);
    }
}
