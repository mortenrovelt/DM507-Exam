import java.util.List;
import java.util.ArrayList;

/**
 * Merge sort.
 * Based on Cormen, p. 34
 *
 * @author Peter Severin Rasmussen
 */
public class MergeSort {

    public static void main(String[] args) {
        int n = 100;
        List<Integer> list = new ArrayList<Integer>(n);
        for(int i = 0; i < n/2; i++) {
            list.add(2*i);
        }
        for(int i = 0; i < n/2; i++) {
            list.add(2*i+1);
        }
        
        System.out.println(list);
        sort(list, 0, n-1);
        System.out.println(list);
    }
    
    public static void sort(List<Integer> A, int p, int r) {
        if (p < r) {
            int q = (int) (Math.floor((p+r)/2));
            sort(A, p, q);
            sort(A, q+1, r);
            merge(A, p, q, r);
        }
        
    }
    
    public static void merge(List<Integer> A, int p, int q, int r) {
        int n1 = q - p;
        int n2 = r - q;
        List<Integer> L = new ArrayList<Integer>(n1);
        List<Integer> R = new ArrayList<Integer>(n2);
        for (int i = p; i <= q; i++) {
            L.add(A.get(i));
        }
        for (int j = q+1; j <= r; j++) {
            R.add(A.get(j));
        }
        L.add(Integer.MAX_VALUE);
        R.add(Integer.MAX_VALUE);
        int i = 0;
        int j = 0;
        
        for(int k = p; k < r; k++) {
            if (L.get(i) <= R.get(j)) {
                A.set(k, L.get(i));
                i++;
            } else {
                A.set(k, R.get(j));
                j++;
            }
        }
    }
    
}
