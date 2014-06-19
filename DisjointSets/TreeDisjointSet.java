import java.util.Map;
import java.util.Map.Entry;
import java.util.HashMap;

public class TreeDisjointSet<E> {
    public static boolean pathCompression = true;
    
    private Map<E, TreeSetNode<E>> sets = new HashMap<E, TreeSetNode<E>>(); 

    public void makeSet(E element) {
        TreeSetNode<E> node = new TreeSetNode<E>(element);
        this.sets.put(element, node); 
    }

    public TreeSetNode<E> findSet(E element) {
        TreeSetNode<E> node = this.sets.get(element); 
        if (pathCompression) { // From Cormen, p. 571
            if (node != node.parent) {
                node.parent = this.findSet(node.parent.data);
            }
            return node.parent;
        } else {
            while (node != node.parent) {
                node = node.parent;
            }
            return node;
        }
    }

    public void union(E x, E y) {
        TreeSetNode<E> xSet = this.findSet(x);
        TreeSetNode<E> ySet = this.findSet(y);
        if (xSet == ySet) return;
        if (xSet.rank > ySet.rank) {
            ySet.parent = xSet;
        } else {
            xSet.parent = ySet;
            if (xSet.rank == ySet.rank) {
                ySet.rank++;
            }
        }
    }

    public String toString() {
        String nl = System.getProperty("line.separator");
        StringBuilder sb = new StringBuilder();
        sb.append("digraph TreeDisjointSet {" + nl);
        for (Entry<E, TreeSetNode<E>> entry : this.sets.entrySet()) {
            TreeSetNode<E> node = entry.getValue();
            sb.append("    " + node.parent.data + " -> " + node.data + " [dir=\"back\"]" + ";" + nl);
        }
        sb.append("}");
        return sb.toString();
    }

    public void draw() {
        System.out.println(this.toString());
    }
}

class TreeSetNode<E> {
    public TreeSetNode<E> parent;
    public int rank;
    public E data;

    public TreeSetNode(E data) {
        this.data = data;
        this.parent = this;
        this.rank = 0;
    }

    public String toString() {
        return this.data.toString();
    }
}
