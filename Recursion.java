import java.lang.Math;

public class Recursion {
    public static double sqrt(double n, double tolerance) {
        if (n == 0.0) {
            return 0;
        }
        if (n < 0.0) {
            throw new IllegalArgumentException("You can't take the square root of a negative number like " + n + '.');
        }
        return sqrtCompare(n, 1.0, tolerance / 100.0);
    }
    public static double sqrtCompare(double n, double g, double t) {
        if (Math.abs(n - g*g) / n <= t) {
            return g;
        }
        return sqrtCompare(n, (n/g + g) / 2, t);
    }

    public static int fib(int n) {
        return fibber(n, 0, 1);
    }
    public static int fibber(int n, int oneB, int twoB) {
        if (n == 0) {
            return oneB;
        }
        return fibber(n - 1, twoB, oneB + twoB);
    }


    public static void main(String[] args) {
        System.out.println(sqrt(0, 0.000001));
        System.out.println(sqrt(1, 0.000001));
        System.out.println(sqrt(100, 0.000001));
        System.out.println(sqrt(2, 0.000001));
        System.out.println(sqrt(0.25, 0.000001));
        try {
            sqrt(-1, 0.000001);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
        System.out.println(fib(0));
        System.out.println(fib(1));
        System.out.println(fib(2));
        System.out.println(fib(3));
        System.out.println(fib(4));
        System.out.println(fib(5));
        System.out.println(fib(40));
    }
}