class Solution {
public:
	// 用sort排序的复杂度是O(nlogn),由于num的数据范围，可以通过数据打表来避免排序达到复杂度O(n)
    int arrayPairSum(vector<int>& nums) {
    	int sum = 0;
        sort(nums.begin(), nums.end());
        for (int i = 0; i < nums.size(); i += 2)
        {
        	sum += nums[i];
        }
        return sum;
    }
};