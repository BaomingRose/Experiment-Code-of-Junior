#include <cstdio>
#include <cmath>
#include <iostream>
using namespace std;
#define INIT 512

struct NODE {
	char name;	//����
	float start;	//��ʼλ��
	float end;	//��С
	int flag;	//�Ƿ����ı�־
};

NODE G_SIZE[INIT];		//����
int count;			//���ֳɵĿ���ͳ��
int applyfree;
float numb;
char c;

//�ȶ�������г�ʼ����ʹû�з��������Ϊ 
void init() {
	count = 1;
	G_SIZE[0].name = 'P';
	G_SIZE[0].start = 0;
	G_SIZE[0].end = INIT;
	G_SIZE[0].flag = 1;
}

//������Ĳ������
void insert(int m, float st, float en) {
	int i;
	count++;
	for(i = count; i > m + 1; i--) {
		G_SIZE[i] = G_SIZE[i - 1];
	}

	G_SIZE[m].start = st;
	G_SIZE[m].end = en;
}

//�ƶ����������������ɾ������
void move(int m) {
	int i;
	for(i = m; i < count - 1; i++) {
		G_SIZE[i] = G_SIZE[i + 1]; 
	}
	count--;
}

//������ڿ鶼û�з��䣬��Ҫ�ϲ���һ��
void rremove(int m, float st, float en) {
	if((!G_SIZE[m-1].flag) && (!G_SIZE[m+1].flag)) {
		G_SIZE[m].name = 'P';
		G_SIZE[m].flag = 1;
	}
	if(G_SIZE[m-1].flag) {
		G_SIZE[m - 1].end = G_SIZE[m - 1].end + en;
		move(m);
	}

	if(G_SIZE[m+1].flag) {
		G_SIZE[m].end = G_SIZE[m].end + G_SIZE[m + 1].end ;
		G_SIZE[m].name = 'P';
		G_SIZE[m].flag = 1;
		move(m + 1);
	}
}

//��ӡ���
void show(){
	int i;
	cout << "����    ��ʶ    ��ַ    ����    ״̬" << endl;
	for(i = 0; i < count; i++) {
		if(G_SIZE[i].flag)
			cout << "P         ";
		else
			cout << G_SIZE[i].name << "         ";
		printf("%-5d    %1.0f     %1.0f    ", i, G_SIZE[i].start, G_SIZE[i].end);
		if(G_SIZE[i].flag)
			cout << "δ����" << endl;
		else
			cout << "�ѷ���" << endl;
	}
}

//�Ӽ�����������
void putin() {
	cout << "��������������ͷŵĽ������Ƽ���Դ������" << endl;
	rewind(stdin);
	cin >> c >> applyfree >> numb;
}

int apply() {
	int i = 0;
	int applyflag = 0;
	int freeflag = 0;
	if(applyfree) { 	//���������Դ
		while(!applyflag && i < count) {
			if(G_SIZE[i].end >= numb && G_SIZE[i].flag) {
				if(G_SIZE[i].end == numb) { 
					G_SIZE[i].name = c;
					G_SIZE[i].flag = 0;
				} else {
					insert(i + 1, G_SIZE[i].start + numb, G_SIZE[i].end - numb);   
					G_SIZE[i+1].flag = 1;
					G_SIZE[i+1].name = 'P';
					G_SIZE[i].start = G_SIZE[i].start;
					G_SIZE[i].name = c;
					G_SIZE[i].end = numb;
					G_SIZE[i].flag = 0;
				}
				applyflag = 1;
			}
			i++;
		}
		if(applyflag) {
			cout << "����ɹ���" << endl;
			return 1;
		} else {
			cout << "����ʧ�ܣ�û���㹻��Ŀ��пռ䡣" << endl;
			return 0;
		}
	} else {	//����ͷ���Դ
		while(!freeflag && i < count) {
			if(G_SIZE[i].name == c) {
				if(G_SIZE[i].end == numb) {
					rremove(i, G_SIZE[i].start, G_SIZE[i].end);               
				} else {
					if(G_SIZE[i].end > numb) {
						insert(i + 1, G_SIZE[i].start + numb, G_SIZE[i].end - numb);
						G_SIZE[i+1].name = 'P';
						G_SIZE[i+1].flag = 0;
						G_SIZE[i].end = numb;
						G_SIZE[i].flag = 1;   
						if(G_SIZE[i-1].flag) {
							rremove(i, G_SIZE[i].start, G_SIZE[i].end);
						}
					} else {
						cout << "�ͷ�ʧ�ܣ���Ϊ��ʹ�õ�����С��Ҫ���ͷŵ�������" << endl;
						return 0;
					}
				}
				freeflag = 1;
			}
			i++;
		}
		if(freeflag) {
			cout << "�ͷųɹ���" << endl;
			return 1;
		} else {
			cout << "�ͷ�ʧ�ܣ�δ�ҵ�ƥ��Ľ������ơ�" << endl;
			return 0;
		}
	}
}

int main() {
	init();
	show();
	while(1) {
		putin();
		apply();
		show();
	}
	return 0; 
}

