class Solution {
public:
    int calPoints(vector<string>& ops) {
    	int scores[1005], index = -1;
    	int rlt = 0;
    	for (int i = 0; i < ops.size(); ++i)
    	{
    		string str = ops[i];
    		if (str == "+")
    		{
    			int score = scores[index - 1] + scores[index];
    			scores[++index] = score;
    			rlt += score;
    		}
    		else if (str == "D") 
    		{
    			int score = scores[index] * 2;
    			scores[++index] = score;
    			rlt += score;
    		}
    		else if (str == "C")
    		{
    			rlt -= scores[index--];
    		}
    		else 
    		{
    			int score = atoi(str.c_str());
    			scores[++index] = score;
    			rlt += score;
    		}
    	}
        return rlt;
    }
};