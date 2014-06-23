/* 
 * Edit this to your needs 
 * Default is problem 1c from june 09
 */
public class Example {
    public static void main(String[] args) {
        // Choose size
        HashTable hashtable = new HashTable(16);

        // Choose probing
        // Change to LINEAR for linear probing (only c1 is needed)
        // Change to DOUBLE for double hashing (need h1 and h2 to be set same way hprime is)
        hashtable.probing = HashTable.QUADRATIC; 

        // Change auxillary hash function, h'(k)
        hashtable.hprime = new HashTable.HashFunction() {
            public int compute(int k) {
                return k % 16;
            }
        };

        // Set constants
        hashtable.c1 = 0.5;
        hashtable.c2 = 0.5;

        // Fill in existing values
        hashtable.table[0] = 32;
        hashtable.table[4] = 20;
        hashtable.table[7] = 23;
        hashtable.table[8] = 7;
        hashtable.table[10] = 39;

        // Print the hash table before insertion
        System.out.println(hashtable);

        // Insert element
        hashtable.insert(71);

        // Print the hash table after insertion
        System.out.println(hashtable);
    }
}

