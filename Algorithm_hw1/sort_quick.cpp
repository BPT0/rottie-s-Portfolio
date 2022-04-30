#include<iostream>
using namespace std;
void QuickSort(int* list, int left, int right, int& size);
int Partition(int* list, int left, int right);
void SWAP(int& x, int& y, int temp);
void print_list(int* list, int size);
int count_1 = 1;

inline void SWAP(int& x, int& y, int temp) {
	temp = x;
	x = y;
	y = temp;
}

int Partition(int* list, int left, int right)
{
	int pivot = list[left], temp=0;
	int low = left + 1, high = right;

	while (1) {
		while (low < right && list[low] < pivot)
			low++;	
		while (high > left && list[high] >= pivot)
			high--;

		if (low < high)
			SWAP(list[low], list[high], temp);
		else break;
	}
	SWAP(list[left], list[high], temp);
	return high;
}

void QuickSort(int* list, int left, int right, int& size)
{
	// list[]�� left���� right���� ũ�� ��Ƽ�� ���� �ȵ�
	if (left < right) {
		int mid = Partition(list, left, right);
		print_list(list, size);
		QuickSort(list, left, mid - 1, size);
		QuickSort(list, mid + 1, right, size);
	}
}

void print_list(int* list, int size) 
{
	cout << "step" << count_1 << ": ";
	for (int i = 0; i < size; i++) {
		cout << list[i] << ' ';
	}
	count_1++;
	cout << endl;
}

int main() {
	int size = 10;
	cout << "list�� ũ�⸦ �Է��ϼ���: ";
	cin >> size;
	int* list = new int[size];
	cout << "list[" << size << "]�� data�� �Է��ϼ��� :";
	for (int i = 0; i < size; i++)
		cin >> list[i];
	
	QuickSort(list, 0, size-1, size);
	
	print_list(list, size);

	return 0;
}