#include <iostream>
#include <cstring>
using namespace std;

class MyString {
private:
	char* str;
public:
	MyString(const char* s = "") : str(new char[strlen(s) + 1]){
		strcpy(str, s);
	}
	
	~MyString() {
		if (str) {
			delete[] str;
			str = NULL;
		}
	}
	
	MyString(const MyString& s) : str(new char[strlen(s.str) + 1]){
		strcpy(str, s.str);
	}
	
	MyString& operator=(const MyString& s) {
		if (str) {
			delete[] str;
			str = new char[strlen(s.str) + 1];
			strcpy(str, s.str);
		}
		return *this;
	}
	
	friend ostream& operator<<(ostream& os, const MyString& s);
	friend MyString operator+(const MyString& s1, const MyString& s2);
	
	
};

ostream& operator<<(ostream& os, const MyString& s) {
	//for (int i = 0; i < strlen(s.str); ++i) {
		os << s.str;
		return os;
	//}
}

MyString operator+(const MyString& s1, const MyString& s2) {
	MyString res;
	delete[] res.str;
	res.str = new char[strlen(s1.str) + strlen(s2.str) + 1];
	strcpy(res.str, s1.str);
	strcat(res.str, s2.str);
	return res;
}

void testMyString() {
	MyString s("Baoming ");
	cout << s << endl;
	MyString s2("Rose");
	cout << s2 << endl;
	MyString s3;
	s3 = s + s2;
	cout << s3 << endl;
}

int main() {
	testMyString();
	return 0;
}
