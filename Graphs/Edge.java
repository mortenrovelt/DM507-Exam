public class Edge {
    public int w = 1;
    public Vertex vertex;

    public Edge(Vertex v) {
        this.vertex = v;
    }

    public Edge(Vertex v, int w) {
        this(v);
        this.w = w;
    }
}
