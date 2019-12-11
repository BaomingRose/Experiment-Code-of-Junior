#include <iostream>
#include <fstream>
using namespace std;

int main() {
	ofstream of("test.txt");
	string s("hello world");
	of << s << endl << "oh" << endl << "my" << endl << "baby" << endl << "!!!" << endl;
	of.close();
		
	fstream outfile;
	outfile.open("test.txt", ios::app);
	outfile << "hehe" << endl << "haha" << endl;
	outfile.close();
	
	return 0;
}
