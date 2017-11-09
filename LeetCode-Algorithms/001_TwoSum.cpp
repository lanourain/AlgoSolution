class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int, int> umap;
        vector<int> rlt;
        for (int i = 0; i < nums.size(); ++i)
        {
        	int other = target - nums[i];
        	if (umap.find(other) != umap.end())
        	{
        		rlt.push_back(umap[other]);
        		rlt.push_back(i);
        		return rlt;
        	}
        	else 
        	{
        		umap[nums[i]] = i;
        	}
        }
    }
};