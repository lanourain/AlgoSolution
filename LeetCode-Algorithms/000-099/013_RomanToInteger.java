/**
 * Created by lanourain on 2014/10/28.
 */

/**
 * Given a roman numeral, convert it to an integer.
 *
 * Input is guaranteed to be within the range from 1 to 3999.
 */

public class RomanToInteger {

    //方法一
    public int romanToInt(String s) {
        int result = 0, len = s.length();
        int[] roman = new int[30];
        for (int index = 0; index < len; index++) {
            if (index + 1 < len && getDigit(s.charAt(index)) < getDigit(s.charAt(index + 1))) {
                result -= getDigit(s.charAt(index));
            } else {
                result += getDigit(s.charAt(index));
            }
        }
        return result;
    }

    private int getDigit(char ch) {
        switch (ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }

    //方法二
    public int romanToInt(String s) {
        int result = 0;
        for (int index = s.length() - 1; index >= 0; index--) {
            switch (s.charAt(index)) {
                case 'I':
                    result += (result >= 5 ? -1 : 1);
                    break;
                case 'V':
                    result += 5;
                    break;
                case 'X':
                    result += (result >= 50 ? -10 : 10);
                    break;
                case 'L':
                    result += 50;
                    break;
                case 'C':
                    result += (result >= 500 ? -100 : 100);
                    break;
                case 'D':
                    result += 500;
                    break;
                case 'M':
                    result += (result >= 5000 ? -1000 : 1000);
                    break;
            }
        }
        return result;
    }
}
