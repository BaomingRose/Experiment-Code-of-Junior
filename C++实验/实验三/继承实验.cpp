#include <iostream>
#include <string>
using namespace std;

class Building {
private:
	string address;
	int building_num;
public:
	Building(string Address, int num) : address(Address), building_num(num) {}
	
	string getAddress() {
		return address;
	}
	
	int getBuilding_num() {
		return building_num;
	}
};

class House : public Building {
private:
	float Area;
	int house_num;
public:
	House(string Address, int num, float area, int House_num) : Building(Address, num), Area(area), house_num(House_num) {}
	
	float getArea() {
		return Area;
	}
	
	int getHouse_num() {
		return house_num;
	}
};

class Office : public Building {
private: 
	string office_name;
	string phone;
public:
	Office(string Address, int num, string Office_name, string Phone) : Building(Address, num), office_name(Office_name), phone(Phone) {}
	
	string getOffice_name() {
		return office_name;
	}
	
	string getPhone() {
		return phone;
	}
	
};

int main() {
	House h1("玉洁路", 2, 30000.0, 604);
	Office o1("玉洁路", 2, "计算机房", "10000000000");
	cout << h1.getAddress() << " " << h1.getBuilding_num() << " " << h1.getArea() << " " << h1.getHouse_num() << endl;
	cout << o1.getAddress() << " " << o1.getBuilding_num()  << " " << o1.getOffice_name() << " " << o1.getPhone() << endl;
	
	return 0;	
}


