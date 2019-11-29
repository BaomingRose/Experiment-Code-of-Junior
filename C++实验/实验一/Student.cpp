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

//ð�� 
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
	cout << "����������" << endl;
}

int main() {
	int grade[5][4];
	student stu[5];
	char Name[5][20];
	cout << "���������ͬѧ��������4�ųɼ���" << endl;
	for (int i = 0; i < 5; ++i) {
		cout << "������ѧ��������" ;
		cin >> Name[i];
		cout << "�����������������ѧ��Ӣ����ݿ⡢C���Գɼ���" << endl;
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
	cout << "�����" << endl;
	PrintStudent(stu, 5);
	
	char tofind[20];
	cout << "��������Ҫ���ҵ�ѧ��������" << endl;
	cin >> tofind;
	cout << endl << "��Ҫ���ҵ�ѧ���ɼ���" << endl;
	findName(stu, 5, tofind);
	
	return 0;
}
