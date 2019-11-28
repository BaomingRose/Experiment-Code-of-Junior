#include<iostream>
#include<vector>
#include<algorithm>
#include<string>
#include<cstdio>
using namespace std;

struct s_pcb {
	string name;
	int run_time;
	int priority_num;
	char status = 'R';

	static int run_sum;

	static void change_run_sum() {
		--run_sum;
	}

	s_pcb(string na, int num, int time) : name(na), run_time(time), priority_num(num) {
		run_sum += time;
	}
};

bool cmp(const s_pcb& p1, const s_pcb& p2) {
	return p1.priority_num > p2.priority_num;
}

int s_pcb::run_sum = 0;

void print(const vector<s_pcb>& pv) {
	cout << "进程名  " << "运行时间  " << "优先级  " << "状态" << endl;
	for (int i = 0; i < pv.size(); ++i) {
		printf("%-8s %-10d %-6d %c\n", pv[i].name.c_str(), pv[i].run_time, pv[i].priority_num, pv[i].status);
	}
	cout << endl;
}

int main() {
	vector<s_pcb> pv;
	s_pcb p1("p1", rand() % 10 + 1, rand() % 10);
	s_pcb p2("p2", rand() % 10 + 1, rand() % 10);
	s_pcb p3("p3", rand() % 10 + 1, rand() % 10);
	s_pcb p4("p4", rand() % 10 + 1, rand() % 10);
	s_pcb p5("p5", rand() % 10 + 1, rand() % 10);
	pv.push_back(p1);
	pv.push_back(p2);
	pv.push_back(p3);
	pv.push_back(p4);
	pv.push_back(p5);
	sort(pv.begin(), pv.end(), cmp);

	int i = 0;
	while (s_pcb::run_sum > 0 && i < pv.size()) {
		if (pv[i].run_time > 0) {
			--pv[i].priority_num;
			--pv[i].run_time;
			s_pcb::change_run_sum();
			if (pv[i].run_time == 0) {
				pv[i].status = 'E';
			}
		} else if (pv[i].run_time == 0) {
			++i;
			continue;
		}
		sort(pv.begin(), pv.end(), cmp);
		print(pv);
	}

	return 0;
}