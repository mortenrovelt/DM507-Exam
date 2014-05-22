import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

/*
 * Adjacency list graph
 */
public class Graph {
    public List<Vertex> vertices;

    public Graph() {
        this.vertices = new ArrayList<Vertex>();
    }

    public int addVertex() {
        Vertex v = new Vertex();
        this.vertices.add(v);
        return this.vertices.size() - 1;
    }

    public void addVertices(int n) {
        for(int i = 0; i < n; i++) {
            this.addVertex();
        }
    }

    public void incident(int i1, int i2) {
        verticesExist(i1, i2);
        
        Vertex v1 = this.vertices.get(i1);
        Vertex v2 = this.vertices.get(i2);

        incident(v1, v2);
    }

    public void incident(Vertex v1, Vertex v2) {
        incidentDirect(v1, v2);
        incidentDirect(v2, v1);
    }

    public void incidentDirect(int i1, int i2) {
        verticesExist(i1, i2);

        Vertex v1 = this.vertices.get(i1);
        Vertex v2 = this.vertices.get(i2);

        incidentDirect(v1, v2);
    }

    public void incidentDirect(Vertex v1, Vertex v2) {
        if (!this.isAdjacent(v1, v2)) {
            Edge e1 = new Edge(v2);
            v1.adj.add(e1);
        }
    }

    public boolean isAdjacent(int i1, int i2) {
        verticesExist(i1, i2);

        Vertex v1 = this.vertices.get(i1);
        Vertex v2 = this.vertices.get(i2);

        return isAdjacent(v1, v2);
    }

    public boolean isAdjacent(Vertex v1, Vertex v2) {
        for (Edge e : v1.adj) {
            if (e.vertex == v2) return true; 
        }
        return false;
    }

    public void vertexExists(int v) {
        if (v < 0 || v >= this.vertices.size()) {
            System.out.println("v (" + v + ") does not exist");
            // throw IllegalArgumentException();
        }
    }

    public void verticesExist(int v1, int v2) {
        int n = this.vertices.size();
        if (v1 < 0 || v1 >= n) {
            System.out.println("v1 (" + v1 + ") does not exist");
        }
        if (v2 < 0 || v2 >= n) {
            System.out.println("v2 (" + v2 + ") does not exist");
        }
        if (v1 < 0 || v1 >= n || v2 < 0 || v2 >= n) {
            //throw IllegalArgumentException();
        }
    }
}
