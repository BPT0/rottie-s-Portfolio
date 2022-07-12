#include <iostream >
#include <string >
#include <map >
#include <queue >
#include <algorithm >
using namespace std;
using std::cout;
struct treenode
{
	treenode* left = nullptr;
	treenode* right = nullptr;
	treenode* parent = nullptr;
	size_t treeweight = 0;
	char val = '!';
	string code = " ";
	bool root = false;
	bool leaf = true;
};
class cmp
{
public:
	bool operator() (pair <char, size_t > a, pair <char, size_t > b)
	{
		if (a.first == b.first)
			return a.first < b.first;
		return a.second < b.second;
	}
};
class treecmp
{
public:
	bool operator() (treenode* a, treenode* b)
	{
		return a->treeweight > b->treeweight;
	}
};
class treecmpp
{
public:
	bool operator() (treenode* a, treenode* b)
	{
		return a->treeweight > b->treeweight;
	}
};
int main() {
	string temp;
	size_t weight = 0;
	map<char, size_t > charcontainer;
	cout << "문장을 입력하시오. 종료키는 q" << endl;
	getline(cin, temp);
	if (temp != "q")
	{
		while (!temp.empty())
		{
			weight = 0;
			for (size_t j = temp.find(temp[0]); j < temp.size(); ++j)
			{
				if (temp[j] == temp[0])
					weight++;
			}
			charcontainer.insert(make_pair(temp[0], weight));
			temp.erase(remove(temp.begin(), temp.end(), (char)temp[0]), temp.end());
		}
	}
	size_t qsize = charcontainer.size();
	priority_queue<pair <char, size_t >, vector <pair <char, size_t >>, cmp > pq;
	auto j = charcontainer.begin();
	for (int i = 0; i < qsize; ++i)
	{
		pq.push(*j);
		j++;
	}
	priority_queue<treenode*, vector <treenode*>, treecmp > tpq;
	while (!pq.empty())
	{
		treenode* tp = new treenode;
		tp->val = pq.top().first;
		tp->treeweight = pq.top().second;
		tpq.push(tp);
		pq.pop();
	}
	vector <treenode*> q;
	while (tpq.top()->root == false)
	{
		treenode* t = new treenode;
		t->left = const_cast <treenode*>(tpq.top());
		t->left->parent = t;
		q.push_back(t->left);
		tpq.pop();
		t->right = const_cast <treenode*>(tpq.top());
		t->right->parent = t;
		q.push_back(t->right);
		tpq.pop();
		t->treeweight = t->left->treeweight + t->right->treeweight;
		t->leaf = false;
		if (tpq.empty())
		{
			t->root = true;
			q.push_back(t);
			break;
		}
		else
			tpq.push(t);
	}
	sort(begin(q), end(q), treecmpp());
	while (!q.empty())
	{
		string temp = q.back()->code;
		if (q.back()->val != '!')
		{
			if (q.back()->root)
				q.back()->code + "0";
			else
			{
				treenode* atr = const_cast <treenode*>(q.back());
				while (true)
				{
					if (atr->root)
						break;
					if (atr == atr->parent->left)
					{
						temp += "0";
					}
					else if (atr == atr->parent->right)
					{
						temp += "1";
					}
					atr = atr->parent;
				}
				temp += "0";
			}
			cout << "문자의 값: " << q.back()->val << endl;
			cout << "반복 빈도수: " << q.back()->treeweight << endl;
			cout << "해당 문자의 코드 값: ";
			for (auto i = temp.rbegin(); i != temp.rend(); ++i)
			{
				cout << *i;
			}
			cout << endl;
		}
		q.erase(end(q) - 1);
	}
}
