class Solution {
public:
    int hammingDistance(int x, int y) {
        int rlt = 0;
        x = x ^ y;

        while (x != 0)
        {
        	rlt += x % 2;
        	x /= 2;
        }
        return rlt;
    }
};