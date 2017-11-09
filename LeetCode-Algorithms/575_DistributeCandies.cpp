class Solution {
public:
    int distributeCandies(vector<int>& candies) {

        int vis[200006];
        for (int i = 0; i < 200006; ++i)
        {
        	vis[i] = 0;
        }
        int kinds = 0;
        int size = candies.size();
        for (int i = 0; i < candies.size(); ++i)
        {
        	kinds += (vis[candies[i] + 100000] == 0);
        	vis[candies[i] + 100000] = 1;
        }
        return kinds < (size / 2) ? kinds : (size / 2);
    }
};