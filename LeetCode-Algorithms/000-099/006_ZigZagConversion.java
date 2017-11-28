/**
 * Created by lanourain on 2015/1/7.
 */

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */
public class ZigZagConversion {
    // solution - 1
    public String convert(String s, int nRows) {
        StringBuffer result = new StringBuffer();
        if (nRows <= 1) return s;
        int m = nRows * 2 - 2;
        int len = s.length();
        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < len; j++) {
                if (j % m != i && j % m != (m - i)) continue;
                result.append(s.charAt(j));
            }
        }
        return result.toString();
    }
}
