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
        LinkedListDisjointSet<Integer> ds = new LinkedListDisjointSet<Integer>();

        Integer one = new Integer(1);
        Integer two = new Integer(2);
        Integer three = new Integer(3);
        Integer four = new Integer(4);

        ds.makeSet(one);
        ds.makeSet(two);
        ds.makeSet(three);
        ds.makeSet(four);

        ds.union(two, one);
        ds.union(four, three);
        ds.union(three, two);

        System.out.println(ds.findSet(one) == ds.findSet(three));

        System.out.println(ds.findSet(one));

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
