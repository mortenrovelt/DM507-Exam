import java.util.Map;
import java.util.Map.Entry;
import java.util.HashMap;

public class LinkedListDisjointSet<E> {
    public static boolean orientation = false;

    private Map<E, LinkedListSetNode<E>> sets = new HashMap<E, LinkedListSetNode<E>>(); 

    public void makeSet(E element) {
        LinkedListSet<E> set = new LinkedListSet<E>(element);
        this.sets.put(element, set.head); 
    }

    public LinkedListSet<E> findSet(E element) {
        LinkedListSetNode<E> setNode = this.sets.get(element);
        return setNode.id;
    }

    public void union(E x, E y) {
        LinkedListSet<E> xSet = this.findSet(x);
        LinkedListSet<E> ySet = this.findSet(y);
        if (xSet == ySet) return;
        xSet.union(ySet);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Entry<E, LinkedListSetNode<E>> entry : this.sets.entrySet()) {
            sb.append(entry.getKey() + ": " + entry.getValue().id + "\n");
        }
        return sb.toString();
    }
}

class LinkedListSet<E> {

    public LinkedListSetNode<E> head;
    public LinkedListSetNode<E> tail;
    public int size = 0;

    public LinkedListSet(E data) {
        LinkedListSetNode<E> node = new LinkedListSetNode<E>(data);
        this.head = node;
        this.tail = node;
        node.id = this;
        node.next = null;
        this.size++;
    }

    public void union(LinkedListSet<E> other) {
        if (this.size > other.size) {
            this.merge(this, other);
        } else if (this.size < other.size) {
            this.merge(other, this);
        } else { // this.size == other.size
            if (LinkedListDisjointSet.orientation) {
                this.merge(this, other);
            } else {
                this.merge(other, this);
            }
        }
    }

    // Append t to s
    private void merge(LinkedListSet<E> s, LinkedListSet<E> t) {
        s.tail.next = t.head;
        s.tail = t.tail;
        LinkedListSetNode<E> node = t.head;
        while (node != null) {
            node.id = s;
            node = node.next;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        LinkedListSetNode<E> node = this.head;
        while (node != null) {
            sb.append(node.toString());
            node = node.next;
            if (node != null) {
                sb.append(" -> ");
            }
        }
        return sb.toString();
    }
}

class LinkedListSetNode<E> {
    public E data;
    public LinkedListSet<E> id;
    public LinkedListSetNode<E> next;

    public LinkedListSetNode(E data) {
        this.data = data;
        this.id = null;
        this.next = null;
    }

    public String toString() {
        return this.data.toString();
    }
}
