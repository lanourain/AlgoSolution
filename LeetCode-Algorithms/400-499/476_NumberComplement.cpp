class Solution {
public:
    int findComplement(int num) {
        int rlt = 0, bit = 1;

        while (num) {
        	rlt += bit * ((num % 2) ^ 1);
        	num /= 2;
        	bit *= 2;
        }
        return rlt;
    }
};