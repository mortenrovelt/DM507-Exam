import java.util.Scanner;

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
        System.out.println("T(n) = a T(n/b) + θ(n^k (log n)^i)");
        System.out.println("(See Format.png for prettier equation)");
        System.out.println();


        Scanner sc = new Scanner(System.in);

        System.out.print("a: ");
        int a = sc.nextInt();

        System.out.print("b: ");
        int b = sc.nextInt();

        System.out.print("k: ");
        float k = sc.nextFloat();

        System.out.print("i: ");
        int i = sc.nextInt();

        double p = Math.log(a) / Math.log(b);

        System.out.println();
        System.out.println("Result: ");

        String result = null;
        if (nearlyEqual(p, k)) {
            result = formatPolyLog(k, i+1);
        } else if (p < k) {
            result = formatPolyLog(k, i);
        } else if (p > k) {
            if (nearlyEqual(Math.round(p), p)) {
                result = formatPolyLog(Math.round(p), 0);
            } else {
                result = "n^log_" + b + "(" + a + ")";
            }
        }

        if (result == null) {
            System.out.println("Error! Try the Javascript version in the Other folder");
            return;
        }

        System.out.println("T(n) in θ(" + result + ")");

    }


    public static String formatPolyLog(float k, int i) {
        StringBuilder sb = new StringBuilder();

        if (k == 0 && i == 0) {
            sb.append("1");
        } else if (k == 0.5) {
            sb.append("sqrt(n)"); 
        } else if (k == 1) {
            sb.append("n");
        } else if (k > 1) {
            sb.append("n^" + k);
        }

        if (i != 0) {
            if (!sb.toString().equals("")) {
                sb.append(" ");
            }
            if (i == 1) {
                sb.append("log n");
            } else {
                sb.append("(log n)^" + i);
            }
        }

        return sb.toString();
    }

    public static boolean nearlyEqual(double a, double b) {
        return nearlyEqual(a, b, 0.000);
    }

    public static boolean nearlyEqual(double a, double b, double epsilon) {
        final double absA = Math.abs(a);
        final double absB = Math.abs(b);
        final double diff = Math.abs(a - b);

        if (a == b) { // shortcut, handles infinities
            return true;
        } else if (a == 0 || b == 0 || diff < Float.MIN_NORMAL) {
            // a or b is zero or both are extremely close to it
            // relative error is less meaningful here
            return diff < (epsilon * Float.MIN_NORMAL);
        } else { // use relative error
            return diff / (absA + absB) < epsilon;
        }
    }
}
