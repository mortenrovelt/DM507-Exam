public class Main {
    public static void main(String[] args) {
        // For testing

        Graph g = new Graph();
        g.addVertices(5);
        g.incident(0, 1);
        g.incident(0, 2);
        g.incident(1, 2);
        g.incident(1, 3);
        g.incident(2, 3);
        g.incident(2, 4);
        g.incident(3, 4);

        System.out.println(g.isAdjacent(2, 0));

        
    }
}
