class Solution {
public:
	bool judgeCircle(string moves) {
		int x = 0, y = 0;
		for (int i = 0; i < moves.size(); ++i)
		{
			switch (moves[i]) {
				case 'U':{x -= 1; break; }
				case 'D':{x += 1; break; }
				case 'R':{y += 1; break; }
				case 'L':{y -= 1; break; }
			}
		}
		return x == 0 && y == 0;
	}
};