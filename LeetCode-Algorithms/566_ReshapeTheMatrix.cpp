class Solution {
public:
	vector<vector<int>> matrixReshape(vector<vector<int>>& nums, int r, int c) {
		int n = nums.size(), m = nums[0].size();
		if (n * m != r * c) 
			return nums;
		vector<vector<int>> rlt;
		int index = 0, ri = 0;
		for (int ni = 0; ni < nums.size(); ++ni)
		{
			for (int mj = 0; mj < nums[ni].size(); ++mj)
			{
				if (index == 0)
				{
					vector<int> v;
					rlt.push_back(v);
				}
				rlt[ri].push_back(nums[ni][mj]);
				ri += (index + 1) / c;
				index = (index + 1) % c;
			}
		}
		return rlt;
	}
};