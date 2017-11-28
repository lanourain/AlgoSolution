/**
 * Created by lanourain on 2014/10/27.
 */

/**
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 *
 * 1 is read off as "one 1" or 11. 11 is read off as "two 1s" or 21. 21 is read
 * off as "one 2, then one 1" or 1211.
 *
 * Given an integer n, generate the nth sequence.
 *
 * Note: The sequence of integers will be represented as a string.
 */

public class CountAndSay {
    public String countAndSay(int n) {
        StringBuilder preStr = new StringBuilder("1");
        StringBuilder curStr;
        int sum;
        for (int index = 2; index <= n; index++) {
            curStr = new StringBuilder("");
            int preLen = preStr.length();
            for (int i = 0; i < preLen; i++) {
                sum = 1;
                while ((i + 1 < preLen) && preStr.charAt(i) == preStr.charAt(i + 1)) {
                    sum++;
                    i++;
                }
                curStr.append("" + sum + preStr.charAt(i));
            }
            preStr = curStr;
        }
        return preStr.toString();
    }
}
