#include<iostream>
#include<cstdlib>
#include<cstdio>
#include<cmath>
using namespace std;

const double PI = 4 * atan(1);

class Pool {
private:
	double R;
	double asileSolePrice;
	double fenceSolePrice;
	double asileWidth;
public:
	Pool(double r, double a = 20.0, double f = 35.0, double w = 3.0) {
		R = r;
		asileSolePrice = a;
		fenceSolePrice = f;
		asileWidth = w;
	}

	double priceOfAsile() {
		double S = PI * pow((R + 3), 2) - PI * pow(R, 2);
		return S * asileSolePrice;
	}

	double priceOfFence() {
		double C = 2 * PI * R;
		return C * fenceSolePrice;
	}
};

int main() {
	//cout << PI << endl;
	double r;
	while (1) {
		cout << "输入半径R:" << endl;
		cin >> r;
		Pool pool(r);
		cout << "过道造价：" << endl;
		cout << pool.priceOfAsile() << endl;
		cout << "栅栏造价：" << endl;
		cout << pool.priceOfFence() << endl;
	}
	return 0;
}
