import Java.Math;

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
        return fibber(n, 0, sum);
    }
    public static int fibber(int n, int place, int sum) {
        if (place == n) {
            return sum;
        }
        return fibber(n, place + 1, sum + place);
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
    }
}