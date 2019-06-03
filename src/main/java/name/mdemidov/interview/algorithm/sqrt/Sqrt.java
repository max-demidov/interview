package name.mdemidov.interview.algorithm.sqrt;

/**
 * Implement int sqrt(int x).
 */
public class Sqrt {

    public static void main(String[] args) {
        int input = (int) 400 * 400;
        int output = sqrt(input);
        System.out.println(output);
    }

    public static int sqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }

        // Do Binary Search for floor(sqrt(x))
        int start = 1;
        int end = x;
        int ans = 0;
        while (start <= end) {
            int mid = (start + end) / 2;

            // If x is a perfect square
            if (mid * mid == x) {
                return mid;
            }

            // Since we need floor, we update answer when mid*mid is
            // smaller than x, and move closer to sqrt(x)
            if (mid * mid < x) {
                start = mid + 1;
                ans = mid;
            } else {  // If mid*mid is greater than x
                end = mid - 1;
            }
        }
        return ans;
    }
}
