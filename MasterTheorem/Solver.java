/**
 * Master Theorem Solver.
 * Based on http://nayuki.eigenstate.org/page/master-theorem-solver-javascript
 * 
 * @author Peter Severin Rasmussen
 */
public class Solver {
    public static void main(String[] args) {
        System.out.println("Master Theorem Solver");
        System.out.println();
        System.out.println("Solves recurrence relations on the form");
        System.out.println("T(n) = a T(n/b) + O(n^k (log n)^i)");
        System.out.println("(See Format.png for prettier equation)");
        System.out.println();
    }
}
