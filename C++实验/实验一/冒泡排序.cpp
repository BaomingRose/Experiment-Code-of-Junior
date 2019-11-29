#include <iostream>
using namespace std;

void BubbleSort(int* src, int n) {
	for (int i = 0; i < n - 1; ++i) {
		for (int j = 0; j < n - i - 1; ++j) {
			if (src[j] > src[j + 1]) {
				int tmp = src[j];
				src[j] = src[j + 1];
				src[j + 1] = tmp; 
			}
		}
	}
} 

int main() {
	int a[] = { 3, 6, 7, 4, 1, 0, 9, 2, 8, 5 };
	int n = sizeof(a) / sizeof(a[0]);
	BubbleSort(a, n);
	for (int i = 0; i < n; ++i) {
		cout << a[i] << ' ';
	}
	return 0;
}
