#include<iostream>
#include<cstdio>
#include<cstring>
using namespace std;

struct student {
	char name[20];
	int Math;
	int English;
	int Database;
	int C_program;
};

//冒泡 
void SortMath(student* stu, int n) {
	for (int i = 0; i < n - 1; ++i) {
		for (int j = 0; j < n - i -1; ++j) {
			if (stu[j].Math < stu[j + 1].Math) {
				student tmp = stu[j];
				stu[j] = stu[j + 1];
				stu[j + 1] = tmp;
			}
		}
	}
}

void PrintStudent(student* stu, int n) {
	for (int i = 0; i < n; ++i) {
		printf("%-15s %3d %3d %3d %3d\n", stu[i].name, stu[i].Math, stu[i].English, stu[i].Database, stu[i].C_program);
	}
}

void findName(student* stu, int n, char* tofind) {
	for (int i = 0; i < n; ++i) {
		if (strcmp(stu[i].name, tofind) == 0) {
			printf("%-15s %3d %3d %3d %3d\n", stu[i].name, stu[i].Math, stu[i].English, stu[i].Database, stu[i].C_program);
			return;
		} 		
	}
	cout << "该生不存在" << endl;
}

int main() {
	int grade[5][4];
	student stu[5];
	char Name[5][20];
	cout << "请输入五个同学的姓名及4门成绩：" << endl;
	for (int i = 0; i < 5; ++i) {
		cout << "请输入学生姓名：" ;
		cin >> Name[i];
		cout << "请依次输入该生的数学、英语、数据库、C语言成绩：" << endl;
		for (int j = 0; j < 4; ++j) {
			cin >> grade[i][j];
		}	
	}
	
	for (int i = 0; i < 5; ++i) {
		student s;
		strcpy(s.name, Name[i]);
		s.Math = grade[i][0];
		s.English = grade[i][1];
		s.Database = grade[i][2];
		s.C_program = grade[i][3];
		stu[i] = s;
		/*cout << stu[i].name << " " << stu[i].Math << " " << 
			stu[i].English << " " << stu[i].Database << " " << stu[i].C_program << endl;*/
	}
	cout << endl;
	PrintStudent(stu, 5);
	cout << endl;
	SortMath(stu, 5);
	cout << "排序后：" << endl;
	PrintStudent(stu, 5);
	
	char tofind[20];
	cout << "请输入你要查找的学生姓名：" << endl;
	cin >> tofind;
	cout << endl << "你要查找的学生成绩：" << endl;
	findName(stu, 5, tofind);
	
	return 0;
}
