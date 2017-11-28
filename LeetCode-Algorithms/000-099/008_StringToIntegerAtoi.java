/**
 * Created by lanourain on 2014/10/21.
 */

/**
 * Implement atoi to convert a string to an integer.
 *
 * Hint:
 *
 * Carefully consider all possible input cases. If you want a challenge,
 * please do not see below and ask yourself what are the possible input cases.
 *
 * Notes:
 *
 * It is intended for this problem to be specified vaguely (ie, no given
 * input specs). You are responsible to gather all the input requirements up front.
 *
 * Requirements for atoi: The function first discards as many whitespace
 * characters as necessary until the first non-whitespace character is found.
 * Then, starting from this character, takes an optional initial plus or minus
 * sign followed by as many numerical digits as possible, and interprets them as
 * a numerical value.
 *
 * The string can contain additional characters after those that form the
 * integral number, which are ignored and have no effect on the behavior of this
 * function.
 *
 * If the first sequence of non-whitespace characters in str is not a valid
 * integral number, or if no such sequence exists because either str is empty or
 * it contains only whitespace characters, no conversion is performed.
 *
 * If no valid conversion could be performed, a zero value is returned. If the
 * correct value is out of the range of representable values, INT_MAX
 * (2147483647) or INT_MIN (-2147483648) is returned.
 */

public class StringToIntegerAtoi {
    public int atoi(String str) {
        long result = 0;
        int isPositive = 0;
        int len = str.length();
        int index = 0;
        if (str.equals("")) return 0;
        for (; index < len && str.charAt(index) == ' '; index++) ;
        if (judgeIsAddAndSub(str.charAt(index))) {
            isPositive = (str.charAt(index++) == '+' ? 1 : -1);
        }
        while (index < len && Character.isDigit(str.charAt(index))) {
            result = result * 10 + str.charAt(index++) - '0';
        }
        result *= (isPositive == 0 ? 1 : isPositive);
        return limitMaxAndMin(result);
    }

    public boolean judgeIsAddAndSub(char ch) {
        return ch == '-' || ch == '+';
    }

    public int limitMaxAndMin(long result) {
        if (result > Integer.MAX_VALUE) result = Integer.MAX_VALUE;
        if (result < Integer.MIN_VALUE) result = Integer.MIN_VALUE;
        return (int)result;
    }
}
