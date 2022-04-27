#include<iostream>
using namespace std;
// void SWAP(int& x, int& y, int temp);
void print_list(int* list, int size);

void print_list(int* list, int size)
{
	for (int i = 1; i < size; i++) {
		cout << list[i] << ' ';
	}
	cout << endl;
}

//inline void SWAP(int* x, int& y, int temp) {
//	temp = x;
//	x = y;
//	y = temp;
//}

class PQ
{
private:
	int* a;
	int N;
public:
	PQ(int max)
	{
		a = new int[max]; N = 0;
	}
	~PQ()
	{
		delete a;
	}

	void upheap(int k)
	{
		int v;
		v = a[k]; a[0] = INT_MAX;
		while (a[k / 2] <= v)
		{
			a[k] = a[k / 2]; k = k / 2;
		}
		a[k] = v;
	}

	void insert(int v)
	{
		a[++N] = v; 
		upheap(N);
	}
	int remove()
	{
		int j, max = 1;
		for (j = 2; j <= N; j++)
			if (a[j] > a[max]) max = j;
		// SWAP(a, max, N);
		return a[N--];
	}
};


void heapsort(int a[], int N)
{
	int i; PQ heap(N);
	for (i = 1; i <= N; i++) heap.insert(a[i]);   // N * insert() //
	cout << "������ heap:";
	print_list(a, 10);

	cout << "������ heap:";
	for (i = N; i >= 1; i--) a[i] = heap.remove();   // N * remove() //
}

int main() {
	int size = 10;
	/*cout << "list�� ũ�⸦ �Է��ϼ���: ";
	cin >> size;
	int* list = new int[size];
	cout << "list[" << size << "]�� data�� �Է��ϼ��� :";
	for (int i = 0; i < size; i++)
		cin >> list[i];*/

	int list[] = {NULL,4,6,1,7,8,9,2,3,5,2};

	heapsort(list, 10);

	print_list(list, size);

	return 0;
}