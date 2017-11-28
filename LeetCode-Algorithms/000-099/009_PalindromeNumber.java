/**
 * Created by lanourain on 2014/10/23.
 */

/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 *
 * Some hints: Could negative integers be palindromes? (ie, -1)
 *
 * If you are thinking of converting the integer to string, note the restriction
 * of using extra space.
 *
 * You could also try reversing an integer. However, if you have solved the
 * problem "Reverse Integer", you know that the reversed integer might overflow.
 * How would you handle such case?
 *
 * There is a more generic way of solving this problem.
 */

public class PalindromeNumber {

    public boolean isPalindrome_1(int x) {
        if (x < 0) {
            return false;
        }
        StringBuilder str = new StringBuilder("" + x);
        int len = str.length();
        for (int index = 0; index < (len >> 1); index++) {
            if (str.charAt(index) != str.charAt(len - 1 - index)) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome_2(int x) {
        if (x < 0) return false;
        long a = x, b = 0;
        while (x > 0) {
            b = b * 10 + x % 10;
            x /= 10;
        }
        return a == b;
    }
}
