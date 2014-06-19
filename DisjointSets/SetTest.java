public class SetTest {
    public static void main(String[] args) {
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
        TreeDisjointSet<Integer> ds = new TreeDisjointSet<Integer>();

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
        //ds.union(three, two);

        System.out.println(ds.findSet(one) == ds.findSet(three));

        System.out.println(ds.findSet(one));

        System.out.println(ds);
    }
}
