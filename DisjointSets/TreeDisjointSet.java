import java.util.Map;
import java.util.Map.Entry;
import java.util.HashMap;

public class TreeDisjointSet<E> {
    public static boolean pathCompression = false;
    
    private Map<E, TreeSetNode<E>> sets = new HashMap<E, TreeSetNode<E>>(); 

    public void makeSet(E element) {
        TreeSetNode<E> node = new TreeSetNode<E>(element);
        this.sets.put(element, node); 
    }

    public TreeSetNode<E> findSet(E element) {
        TreeSetNode<E> node = this.sets.get(element); 
        while (node != node.parent) {
            node = node.parent;
        }
        return node;
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
        StringBuilder sb = new StringBuilder();
        for (Entry<E, TreeSetNode<E>> entry : this.sets.entrySet()) {
            sb.append(entry.getKey() + ": " + entry.getValue() + "\n");
        }
        return sb.toString();
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
}
