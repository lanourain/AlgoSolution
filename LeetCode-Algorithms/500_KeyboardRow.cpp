class Solution {
public:
	vector<string> findWords(vector<string>& words) {
		string key[3] = {"QWERTYUIOPqwertyuiop", "ASDFGHJKLasdfghjkl", "ZXCVBNMzxcvbnm"};
		vector<string> v;
		for (int i = 0; i < words.size(); ++i)
		{
			int keyindex = -1;
			for (int j = 0; j < words[i].size(); ++j)
			{
				int k = 0;
				for ( ; k < 3; ++k)
				{
					size_t find = key[k].find(words[i][j]);
					if (find != string::npos)
						break;
				}
				
				if(keyindex != k) 
				{
					if (keyindex == -1) 
					{
						keyindex = k;
					}
					else {
						keyindex = -1;
						break;
					}
					
				}
			}
			if (keyindex != -1)
				v.push_back(words[i]);
		}
		return v;

	}
};