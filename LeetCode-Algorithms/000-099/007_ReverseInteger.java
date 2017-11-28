/**
 * Created by lanourain on 2014/10/21.
 */

/**
 * Reverse digits of an integer.
 *
 * Example1: x = 123, return 321 Example2: x = -123, return -321
 *
 * Have you thought about this? Here are some good questions to ask before
 * coding. Bonus points for you if you have already thought through this!
 *
 * If the integer's last digit is 0, what should the output be? ie, cases such
 * as 10, 100.
 *
 * Did you notice that the reversed integer might overflow? Assume the input is
 * a 32-bit integer, then the reverse of 1000000003 overflows. How should you
 * handle such cases?
 *
 * Throw an exception? Good, but what if throwing an exception is not an option?
 * You would then have to re-design the function (ie, add an extra parameter).
 */

/**
 * think about overflow, when x = 2199999999, Reverse x = 9999999921, overflow, so I return 0, when overflow;
 */

public class ReverseInteger {
    public int reverse(int x) {
        long result = 0;
        while (x != 0) {
            result = result * 10 + x % 10;
            x /= 10;
        }
        if (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) result = 0;
        return (int)result;
    }
}
