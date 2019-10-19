package name.mdemidov.interview.leetcode.task204;

import java.util.ArrayList;
import java.util.List;

/**
 * Count the number of prime numbers less than a non-negative number, n.
 *
 * Example:
 *
 * Input: 10
 * Output: 4
 *
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 */
public class Solution {

    private List<Integer> primes;

    public static void main(String[] args) {
        System.out.println(new Solution().countPrimes(3));
        System.out.println(new Solution().countPrimes(10));
        System.out.println(new Solution().countPrimes(499979));
    }

    public int countPrimes(int n) {
        if (n < 3) {
            return 0;
        } else {
            primes = new ArrayList<>();
            primes.add(2);
        }
        for (int i = primes.get(primes.size() - 1) + 1; i < n; i += 2) {
            boolean isPrime = true;
            for (int prime : primes) {
                if (prime > Math.sqrt(n)) {
                    break;
                }
                if (i % prime < 1) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primes.add(i);
            }
        }
        return primes.size();
    }

}
