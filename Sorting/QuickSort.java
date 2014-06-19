/**
 * Quick sort.
 * Based on Cormen, p. 170
 *
 * @author Peter Severin Rasmussen
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[] {9,7,1,4,8,6,5};
        sort(arr);
        System.out.println(java.util.Arrays.toString(arr));
    }
    
    public static void sort(int[] array, int start, int end) {
        if (end - start <= 1) {
            return;
        }
        int x = partition(array, start, end);
        sort(array, start, x-1);
        sort(array, x+1, end);
    }
    
    public static void sort(int[] array) {
        sort(array, 0, array.length-1);
    }
    
    public static int partition(int[] array, int start, int end, int pivotIndex) {
        int i = start-1, j = start;
        int pivot = array[pivotIndex];
        for (; j <= end; j++) {
            if (array[j] <= pivot) {
                swap(array, i+1, j);
                i++;
            } 
        }
        swap(array, i+1, pivotIndex);
        return i;
    }
    public static int partition(int[] array, int start, int end) {
        int pivot = ((int) Math.random()*(end-start)+start);
        return partition(array, start, end, end);
    }
    
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
}
