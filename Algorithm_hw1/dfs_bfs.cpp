#include <iostream>
#include <vector>
#include <queue>
using namespace std;

bool visited[26], visited_[26];
vector<char> graph[26];

vector<char> list_dfs, list_bfs;

void dfs(char x)
{
	int num = x - 65;
	visited[num] = true;
	list_dfs.push_back(x);
	for (int i = 0; i < list_dfs.size(); i++)
		cout << list_dfs[i] << " ";
	cout << endl;
	for (int i = 0; i < graph[num].size(); i++)
	{
		char y = graph[num][i];
		int num_two = y - 65;
		if (!visited[num_two])
			dfs(y);
	}
}

void bfs(char start) {
	int num = start - 65;
	queue<char> q;
	q.push(start);
	visited_[num] = true;


	while (!q.empty()) {
		char x = q.front();
		int num_two = x - 65;
		q.pop();
		list_bfs.push_back(x);
		for (int i = 0; i < list_bfs.size(); i++)
			cout << list_bfs[i] << " ";
		cout << endl;
		for (int i = 0; i < graph[num_two].size(); i++) {
			char y = graph[num_two][i];
			int num_three = y - 65;
			if (!visited_[num_three]) {
				q.push(y);
				visited_[num_three] = true;
			}
		}
	}
}

int main(void)
{
	int ver, edge;
	char start = '1';
	cout << "===그래프 입력===" << endl;
	cout << "Edge 개수를입력하시오: ";
	cin >> edge;
	// 입력 edge : AC AB BE BD CG CF
	cout << "Graph Edge를입력하시오: ";
	for (int i = 0; i < edge; i++) {
		char c1, c2;
		int x, y;
		cin >> c1 >> c2;
		if (start == '1')
			start = c1;
		x = c1 - 65;
		y = c2 - 65;
		graph[x].push_back(c2);
		graph[y].push_back(c1);
	}
	cout << "===연결리스트===" << endl;
	for (int i = 0; i < 26; i++) {
		int count = 0;
		for (int j = 0; j < graph[i].size(); j++) {
			if (count == 0) {
				count++;
				char name = i + 65;
				cout << name << "와연결된점: ";
			}
			cout << graph[i][j] << " ";
			if (j + 1 == graph[i].size())
				cout << endl;
		}
	}
	cout << "DFS계산결과" << endl;
	dfs(start);
	cout << "BFS계산결과" << endl;
	bfs(start);
}
