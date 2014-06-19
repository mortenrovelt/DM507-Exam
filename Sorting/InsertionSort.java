/**
 * Insertion Sort.
 * Based on Cormen, p. 18
 * @author Peter Severin Rasmussen
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] list = generate(10000, "shuffle");
        int[] sorted = sort(list);
        System.out.println(java.util.Arrays.toString(sorted));
        //System.out.println(Arrays.toString(list));
        //SortRecord sc = InsertionSort.sortWithTiming(list);
        //System.out.println(Arrays.toString(sc.list));
        //System.out.println(sc.time);
        //InsertionSort.experiment();
    }

    public static int[] sort(int[] oldList) {
        int n = oldList.length; // Save length
        int[] list = new int[n]; // Copy list
        System.arraycopy(oldList, 0, list, 0, n);
        int element, i;

        // Insertion sort algorithm
        for (int j = 1; j < n; j++) {
            element = list[j];
            i = j - 1;
            while (i >= 0 && list[i] > element) {
                list[i + 1] = list[i];
                i--;
            }
            list[i + 1] = element;
        }

        // Return a list 
        return list;
    }


    /* ====== Testing ======= */

    public static SortRecord sortWithTiming(int[] oldList) {
        int[] list;
        long starttime, endtime, time;

        starttime = System.currentTimeMillis(); // Start time

        list = sort(oldList);

        endtime = System.currentTimeMillis(); // End time
        time = endtime - starttime; // Save elapsed time

        // Return a list and a time in a single package
        return new SortRecord(list, time);
    }

    // Generate list of input
    public static int[] generate(int n, String type) {
        int[] list = new int[n];
        if (type.equals("best")) {
            for (int i = 0; i < n; i++) {
                list[i] = (i + 1);
            }
        } else if (type.equals("worst")) {
            for (int i = n; i > 0; i--) {
                list[n - i] = (i);
            }
        } else if (type.equals("shuffle")) {
            // This ensures that there is 
            // only one of each integer
            java.util.List<Integer> temp = new java.util.ArrayList<Integer>(n);
            for (int i = 0; i < n; i++) {
                temp.add(i + 1);
            }
            java.util.Collections.shuffle(temp);
            for (int i = 0; i < temp.size(); i++) {
                list[i] = temp.get(i);
            }
        } else { // Random
            for (int i = 0; i < n; i++) {
                list[i] = ((int) (Math.random() * n + 1));
            }
        }
        return list;
    }

    // Overload method for random list as default
    public static int[] generate(int n) {
        return generate(n, "random");
    }

    public static void experiment() {
        int i, sum;
        double avg_time;
        SortRecord sc;
        int passes = 3; // Number of times to even out the time
        int[] list;
        int[] bestCases = {50000000, 100000000, 200000000};
        int[] worstCases = {10000, 50000, 100000};

        System.out.println("Running time experiment with best and worst case:");

        // Best case
        for (int n : bestCases) {
            sum = 0;
            for (i = 0; i < passes; i++) {
                list = generate(n, "best");
                sc = sortWithTiming(list);
                sum += sc.time;
            }
            avg_time = (sum / passes);
            System.out.println("Best case with " + n + " elements: " + avg_time + " ms");
            System.out.println("Divided by " + n + " (n): " + ((avg_time * 1.0) / n));
        }

        // Worst case
        for (int n : worstCases) {
            sum = 0;
            for (i = 0; i < passes; i++) {
                list = generate(n, "worst");
                sc = sortWithTiming(list);
                sum += sc.time;
            }
            avg_time = (sum / passes);
            System.out.println("Worst case with " + n + " elements: " + avg_time + " ms");
            System.out.println("Divided by " + n + " (n²): " + ((avg_time * 1.0) / (n * n)));
        }
    }

    public static class SortRecord {

        public int[] list;
        public long time;

        public SortRecord(int[] list, long time) {
            this.list = list;
            this.time = time;
        }
    }
}
