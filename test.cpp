#include<iostream>
#include<string>
#include<stack>

using namespace std;

int main()
{
	stack<int> first;
	if (first.empty()) 
		printf("empty\n");
	first.push(1);
	printf("%d\n", first.top());
	first.pop();
	if (first.empty()) 
		printf("empty\n");
	printf("%d\n", (int) first.size());
	return 0;
}