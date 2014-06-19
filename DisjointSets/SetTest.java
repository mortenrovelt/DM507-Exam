/**
 * Disjoint Sets.
 * Based on Cormen, p. 561
 *
 * @author Peter Severin Rasmussen
 */
public class SetTest {
    public static void main(String[] args) {
        linkedListTest();
        treeTest();
    }

    public static void linkedListTest() {
        LinkedListDisjointSet<Character> ds = new LinkedListDisjointSet<Character>();

        Character a = new Character('a');
        Character b = new Character('b');
        Character c = new Character('c');
        Character d = new Character('d');

        ds.makeSet(a);
        ds.makeSet(b);
        ds.makeSet(c);
        ds.makeSet(d);

        ds.union(b, a);
        ds.union(d, c);
        ds.union(c, b);

        System.out.println(ds.findSet(a) == ds.findSet(c));

        System.out.println(ds.findSet(d));

        System.out.println(ds);
    }

    public static void treeTest() {
        TreeDisjointSet<Character> ds = new TreeDisjointSet<Character>();

        Character a = new Character('a');
        Character b = new Character('b');
        Character c = new Character('c');
        Character d = new Character('d');

        ds.makeSet(a);
        ds.makeSet(b);
        ds.makeSet(c);
        ds.makeSet(d);

        ds.union(b, a);
        ds.union(d, c);
        ds.union(c, b);

        System.out.println(ds.findSet(a) == ds.findSet(c));

        System.out.println(ds.findSet(d));

        System.out.println(ds);
    }
}
