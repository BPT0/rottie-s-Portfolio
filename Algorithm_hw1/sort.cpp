#include<iostream>
using namespace std;

void BubbleSort(int* list, int n, int& comp);
void insertionSort(int list[], int n, int& comp);
inline void swap(int& x, int& y);
void selectionSort(int list[], int n, int& comp);

int main() {
	int list[4], list_len= sizeof list / sizeof(int);
	int comp = 0;
	cout << "배열 값 입력 : ";
	for (int i = 0; i < list_len; i++) {
		cin>> list[i];
	}

	// 선택 정렬
	/*selectionSort(list, list_len, comp);
	cout << "배열(정렬X)  : ";
	for (int i = 0; i < list_len; i++) {
		cout << list[i] << ' ';
	}
	cout << endl;
	cout << "비교횟수: " << comp;*/

	// 버블 정렬
	/*BubbleSort(list, list_len, comp);
	cout << "배열(정렬O)  : ";
	for (int i = 0; i < list_len; i++) {
		cout << list[i] << ' ';
	}
	cout << endl;
	cout << "비교횟수: "<< comp;*/

	// 삽입 정렬
	insertionSort(list, list_len, comp);
	cout << "배열(정렬O)  : ";
	for (int i = 0; i < list_len; i++) {
		cout << list[i] << ' ';
	}
	cout << endl;
	cout << "비교횟수: " << comp;

	return 0;
}

inline void swap(int& x, int& y) {
	int t = x;
	x = y;
	y = t;
}

void selectionSort(int list[], int n, int& comp) {
	for (int i = 0; i < n - 1; i++) {
		int least = i;
		for (int j = i + 1; j < n; j++) {
			if (list[j] < list[least]) least = j;
		}
		swap(list[i], list[least]);
		comp += i +1 ;
	}
}

void BubbleSort(int* list, int n, int& comp)
{
	int temp=0;
	for (int i = n-1; i>0; i--)
	{
		for (int j = 0; j < i; j++) 
		{
			if (list[j] > list[j + 1]) {
				temp = list[j];
				list[j] = list[j + 1];
				list[j + 1] = temp;
			}
		}
		comp += i;
	}
}

void insertionSort(int* list, int n, int& comp) 
{
	for (int i = 1; i < n; i++) {
		int key = list[i];
		int j;
		for (j = i - 1; j >= 0 && list[j] > key; j--) {
			list[j + 1] = list[j];
		}
		if (list[j + 1] != list[j + 2]) comp += 1;
		else comp += i;
		list[j + 1] = key;
	}
}