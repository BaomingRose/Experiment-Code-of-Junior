#include<iostream>
#include<string>
using namespace std;

class Student {
private:
	string _testId;
	string _name;
	int _grade;
	static int groupGrade;
public:
	static void getGroupGrade() ;
	
	Student(string testID, string name, int grade) : _testId(testID), _name(name), _grade(grade) {
		groupGrade += _grade;
	}
	
	void showInfo() {
		cout << "学生准考证号: " << _testId << endl << "学生姓名：" << _name << endl << "学生成绩：" << _grade << endl;
	}
	
};

int Student::groupGrade = 0;

void Student::getGroupGrade() {
	cout << "团队成绩：" << groupGrade << endl;
}


int main() {
	Student s1("11111", "qiaobiluo", 2);
	s1.showInfo() ;
	s1.	getGroupGrade();
	Student s2("22222", "caixukun", 1);
	s2.showInfo() ;
	s2.getGroupGrade() ;
	Student s3("33333", "hanmeijuan", 100);
	s3.showInfo() ;
	s3.getGroupGrade() ;
	
	return 0;
}
