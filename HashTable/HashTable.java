/**
 * Hash Table.
 * Using open addressing with linear and quadratic probing
 * @author Peter Severin Rasmussen
 */
public class HashTable {
    public static final boolean verbose = true;
    public static final int LINEAR = 1;
    public static final int QUADRATIC = 2;
    public static final int DOUBLE = 3;

    public int probing = LINEAR;

    public int[] table;
    private int size = 0;

    // Constants
    public double c1 = Double.NEGATIVE_INFINITY;
    public double c2 = Double.NEGATIVE_INFINITY;

    // Auxiliary hash functions
    public HashFunction hprime = null;
    public HashFunction h1 = null; 
    public HashFunction h2 = null;

    public HashTable(int[] table) {
        this.table = table;
    }

    public HashTable(int size) {
        this(new int[size]);
    }

    public void set(int index, int key) {
        this.table[index] = key;
    }

    public int get(int index) {
        return this.table[index];
    }

    public void insert(int key) {
        // If assertion fails, stop
        if (!assertion()) {
            System.out.println("Cannot complete insertion");
            return;
        }

        int i = 0;
        int m = this.table.length;

        while (i < m) {
            if (verbose) {
                System.out.println("Trying i = " + i);
            }
            int index = h(key, i);
            if (verbose) {
                System.out.println("Results in index: " + index);
            }
            if (this.table[index] == 0) {
                if (verbose) {
                    System.out.println("Inserting " + key + " into table at index " + index);
                }
                this.table[index] = key;
                break;
            } else {
                if (verbose) {
                    System.out.println("This index is not free");
                }
                i++;
            }
        }
    }

    private int h(int k, int i) {
        int m = this.table.length; 
        if (this.probing == LINEAR) {
            return ((int) Math.round(this.hprime.compute(k) + this.c1 * i)) % m;
        } else if (this.probing == QUADRATIC) {
            return ((int) Math.round(this.hprime.compute(k) + this.c1 * i + this.c2 * (i * i))) % m;
        } else if (this.probing == DOUBLE) {
            return (this.h1.compute(k) + i * this.h2.compute(k)) % m;
        } else {
            return -1;
        }
    }

    // Assert that everything is set correctly
    public boolean assertion() {
        boolean valid = true;
        if (this.probing == LINEAR) {
            if (this.hprime == null) {
                System.out.println("h' not set");
                valid = false;
            }
            if (this.c1 == Double.NEGATIVE_INFINITY) {
                System.out.println("c1 not set");
                valid = false;
            }
        } else if (this.probing == QUADRATIC) {
            if (this.hprime == null) {
                System.out.println("h' not set");
                valid = false;
            }
            if (this.c1 == Double.NEGATIVE_INFINITY) {
                System.out.println("c1 not set");
                valid = false;
            }
            if (this.c2 == Double.NEGATIVE_INFINITY) {
                System.out.println("c2 not set");
                valid = false;
            }
        } else if (this.probing == DOUBLE) {
            if (this.h1 == null) {
                System.out.println("h1 not set");
                valid = false;
            }
            if (this.h2 == null) {
                System.out.println("h2 not set");
                valid = false;
            }
        } else {
            System.out.println("No probing option selected");
            valid = false;
        }
        return valid;
    }

    public interface HashFunction {
        public int compute(int k);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        int spacing = 2;

        for (int i = 0; i < this.table.length; i++) {
            int key = this.get(i);
            int len = Math.max(String.valueOf(i).length() + spacing, String.valueOf(key).length() + spacing);
            sb.append(String.format("%"+len+"d", i));
        }
        sb.append(System.getProperty("line.separator"));
        for (int i = 0; i < this.table.length; i++) {
            int key = this.get(i);
            int len = Math.max(String.valueOf(i).length() + spacing, String.valueOf(key).length() + spacing);
            sb.append(String.format("%"+len+"d", key));
        }
        return sb.toString();
    }
}
