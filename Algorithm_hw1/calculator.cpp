#include<iostream>
#include<string>
using namespace std;

class Stack_char {
private:
	char* stack;
	int p;
public:
	Stack_char(int max = 100) {
		stack = new char[max];
		p = 0;
	}
	~Stack_char() { delete stack; }
	inline void push(char v) { stack[p++] = v; }
	inline char pop() { return stack[--p]; }
	inline int empty() { return !p; }
};

class Stack_int {
private:
	int* stack;
	int p;
public:
	Stack_int(int max = 100) {
		stack = new int[max];
		p = 0;
	}
	~Stack_int() { delete stack; }
	inline void push(int v) { stack[p++] = v; }
	inline int pop() { return stack[--p]; }
	inline int empty() { return !p; }
};

int main1() {
	// 1. 중위표기식 -> 후위표기식
	int ret;
	string m_fml, l_fml;
	char c; 
	Stack_char save(50);
	Stack_int acc(50);
	// -1. 후휘표기식으로 변환한 값을 string 에 저장한다
	cout << "중위 표기식을 입력하세요: ";
	getline(cin, m_fml);
	int j = 0;
	while (j < m_fml.length())
	{	
		if (m_fml[j] == ' ') {
			j++;
			continue;
		}
		while (m_fml[j] >='0'&& m_fml[j] <='9')
		{
			cout << m_fml[j];
			l_fml.append(1, m_fml[j]);
			j++;
		}
		if (m_fml[j] != ')' && m_fml[j] != '+') {
			cout << ' ';
			l_fml.append(1, ' ');
		}
		if (m_fml[j] == ')') {
			l_fml.append(1, save.pop());
		}
		if (m_fml[j] == '+') save.push(m_fml[j]);
		if (m_fml[j] == '-') save.push(m_fml[j]);
		if (m_fml[j] == '*') save.push(m_fml[j]);
		if (m_fml[j] == '/') save.push(m_fml[j]);
		j++;
	}
	cout << endl;
	cout << l_fml << endl;

	// 2.저장한 후위표기식을 연산하여 결과값을 표시한다
	int i = 0;
	while (i<l_fml.length()) {
		ret = 0;
		if (l_fml[i] == ' ') {
			i++;
			continue;
		}
		while (l_fml[i] >= '0' && l_fml[i] <= '9') {
			ret = 10 * ret + (l_fml[i] - '0');
			i++;
		}
		if (l_fml[i] == '+') ret = acc.pop() + acc.pop();
		if (l_fml[i] == '-') ret = acc.pop() - acc.pop();
		if (l_fml[i] == '*') ret = acc.pop() * acc.pop();
		if (l_fml[i] == '/') ret = acc.pop() / acc.pop();
		acc.push(ret);
		i++;
	}
	cout << acc.pop() << endl;

	return 0;
}