#include <iostream>
#include <cmath>
using namespace std;

const double PI = atan(1);

class Circle {
protected:
	double radius;
	
public:
	Circle(double r) : radius(r) {}
	
	virtual double area() {
		return PI * pow(radius, 2);
	}
	
	virtual double volume() {
		return 0.0;
	}
};

class Sphere : public Circle {
public:
	Sphere(double r) : Circle(r) {}
	
	double area() {
		return 4 * PI * pow(radius, 2);
	}
	
	double volume() {
		return PI * pow(radius, 3);
	}
};

class Column : public Circle {
private:
	double height;
public:
	Column(double r, double h) : Circle(r), height(h) {}
	
	double area() {
		return 2 * PI * radius * height + 2 * PI * pow(radius, 2);
	}
	
	double volume() {
		return 2 * PI * pow(radius, 2) * height;
	}
};

void print(Circle* c) {
	cout << "面积：" << c->area() << endl << "体积：" << c->volume() << endl;
}

int main() {
	Circle* ptrS = new Sphere(10);
	Circle* ptrC = new Column(10, 3);
	
	print(ptrS);
	print(ptrC);
	
	return 0;	
}

