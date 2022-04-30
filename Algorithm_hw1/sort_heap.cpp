#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <stdio.h>
#include <string.h>
using namespace std;

void swap(int* data, int a, int b) {
    int temp = data[a];
    data[a] = data[b];
    data[b] = temp;
}

void upSortHeap(int* data, int child, int n) {
    int temp = data[child];

    while (data[child / 2] <= temp) {
        swap(data, child / 2, child);
        child /= 2;
    }
}

void downSortHeap(int* data, int root, int n) {
    int temp = data[root];
    int child = root * 2;
    while (root <= n / 2) {
        if (child < n && data[child] < data[child + 1])
            child++;
        if (temp >= data[child])
            break;
        swap(data, root, child);
        root = child;
        child *= 2;
    }
}

void remove(int* data, int n) {
    int num = data[1];
    data[1] = data[n--];
    downSortHeap(data, 1, n);
    cout << num << ' ';
}

void upHeap(int* data, int n) {
    int heap[100];
    heap[0] = 100;

    for (int i = 1; i <= n; i++) {
        heap[i] = data[i - 1];
    }

    for (int i = n / 2; i >= 1; i--) {
        downSortHeap(heap, i, n);
    }

    cout << "상향식 heap정렬 후 : ";
    for (int i = 1; i <= n; i++)
        cout << heap[i] << ' ';
    cout << '\n';

    cout << "정렬 후 결과 : ";
    for (int i = n; i >= 1; i--) {
        remove(heap, i);
    }
    cout << '\n';
}

void downHeap(int* data, int n) {
    int heap[100];
    heap[0] = 100;

    for (int i = 1; i <= n; i++) {
        heap[i] = data[i - 1];
        if (i >= 2) {
            upSortHeap(heap, i, i);
        }
    }

    cout << "하향식 heap정렬 후:";
    for (int i = 1; i <= n; i++)
        cout << heap[i] << ' ';
    cout << '\n';

    cout << "정렬 후 결과:";
    for (int i = n; i >= 1; i--) {
        remove(heap, i);
    }
    cout << '\n';
}

int main() {
    char str[100], * s;
    int num[100], cnt = 0;

    cout << "정렬할 값을 입력(100개이하):";
    gets_s(str);

    for (s = strtok(str, " "); s; s = strtok(NULL, " "), cnt++)
        if (sscanf(s, "%d", &num[cnt]) < 1)
            break;

    upHeap(num, cnt);
    downHeap(num, cnt);
}