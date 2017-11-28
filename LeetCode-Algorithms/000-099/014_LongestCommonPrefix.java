/**
 * Created by lanourain on 2014/10/29.
 */

/**
 * Write a function to find the longest common prefix string amongst an array of
 * strings.
 */

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        String result = "";
        int size = strs.length, len;
        int i, j;
        if (size == 0) return result;
        if (size == 1) return strs[0];
        for (i = 0; i < strs[0].length(); i++) {
            for (j = 1; j < size; j++) {
                len = strs[j].length();
                if (i >= len) break;
                if (strs[j].charAt(i) != strs[j - 1].charAt(i)) break;
            }
            if (j < size) break;
            result += strs[0].charAt(i);
        }
        return result;
    }
}
