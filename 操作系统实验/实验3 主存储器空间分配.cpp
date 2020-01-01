#include <cstdio>
#include <cmath>
#include <iostream>
using namespace std;
#define INIT 512

struct NODE {
	char name;	//名称
	float start;	//起始位置
	float end;	//大小
	int flag;	//是否分配的标志
};

NODE G_SIZE[INIT];		//数组
int count;			//被分成的块数统计
int applyfree;
float numb;
char c;

//先对数组进行初始化，使没有分配的名称为 
void init() {
	count = 1;
	G_SIZE[0].name = 'P';
	G_SIZE[0].start = 0;
	G_SIZE[0].end = INIT;
	G_SIZE[0].flag = 1;
}

//对数组的插入操作
void insert(int m, float st, float en) {
	int i;
	count++;
	for(i = count; i > m + 1; i--) {
		G_SIZE[i] = G_SIZE[i - 1];
	}

	G_SIZE[m].start = st;
	G_SIZE[m].end = en;
}

//移动操作，即对数组的删除操作
void move(int m) {
	int i;
	for(i = m; i < count - 1; i++) {
		G_SIZE[i] = G_SIZE[i + 1]; 
	}
	count--;
}

//如果相邻块都没有分配，则要合并到一起
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

//打印输出
void show(){
	int i;
	cout << "名称    标识    起址    长度    状态" << endl;
	for(i = 0; i < count; i++) {
		if(G_SIZE[i].flag)
			cout << "P         ";
		else
			cout << G_SIZE[i].name << "         ";
		printf("%-5d    %1.0f     %1.0f    ", i, G_SIZE[i].start, G_SIZE[i].end);
		if(G_SIZE[i].flag)
			cout << "未分配" << endl;
		else
			cout << "已分配" << endl;
	}
}

//从键盘输入数据
void putin() {
	cout << "请输入申请或者释放的进程名称及资源数量：" << endl;
	rewind(stdin);
	cin >> c >> applyfree >> numb;
}

int apply() {
	int i = 0;
	int applyflag = 0;
	int freeflag = 0;
	if(applyfree) { 	//提出申请资源
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
			cout << "申请成功！" << endl;
			return 1;
		} else {
			cout << "申请失败！没有足够大的空闲空间。" << endl;
			return 0;
		}
	} else {	//提出释放资源
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
						cout << "释放失败，因为正使用的数量小于要求释放的数量。" << endl;
						return 0;
					}
				}
				freeflag = 1;
			}
			i++;
		}
		if(freeflag) {
			cout << "释放成功！" << endl;
			return 1;
		} else {
			cout << "释放失败！未找到匹配的进程名称。" << endl;
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

