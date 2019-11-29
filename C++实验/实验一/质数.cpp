#include <iostream>
#include <cmath>
using namespace std;

bool isPrime(int n) {
	int tmp = sqrt(n);
	for (int i = 2; i <= tmp; ++i) {
		if (n % i == 0) {
			return false;
		}
	}
	return true;
}

int main() {
	for (int i = 1; i <= 100; ++i) {
		if (isPrime(i)) {
			cout << i << " ";
		}
	}
	return 0;
}
