import java.util.List;
import java.util.LinkedList;

public class Vertex {
    public List<Edge> adj;
    public int p, d, f;

    public Vertex() {
        this.adj = new LinkedList<Edge>();
    }
}
