#if 0
#include <iostream>
#include <vector>
#include <string>
#include <ctime>
using namespace std;

class Data {
private:
	int n;
	int m;
	vector<vector<int>> max;		//最大数矩阵，N个进程需要M的最大数量
	vector<int> resource;		//可利用资源向量
	vector<vector<int>> distribution;	//分配资源矩阵
	vector<vector<int>> needResource;	//需求资源矩阵

public:
	Data(int N = 0, int M = 0) : n(N), m(M){
		max.resize(n);
		for (auto& v : max) {
			v.resize(m, 0);
		}
		resource.resize(m);
		distribution.resize(n);
		for (auto& v : distribution) {
			v.resize(m, 0);
		}
		needResource.resize(n);
		for (auto& v : needResource) {
			v.resize(m, 0);
		}
	}
	
	int getN() {
		return n;
	}

	int getM() {
		return m;
	}

	vector<vector<int>> getMax() {
		return max;
	}

	void setMax(vector<vector<int>> Max) {
		max = Max;
	}

	vector<int> getResource() {
		return resource;
	}

	void setResource(vector<int> Resource) {
		resource = Resource;
	}

	vector<vector<int>> getDistribution() {
		return distribution;
	}

	void setDistribution(vector<vector<int>> Distribution) {
		distribution = Distribution;
	}

	vector<vector<int>> getNeedResource() {
		return needResource;
	}

	void setNeedResource(vector<vector<int>> NeedResource) {
		needResource = NeedResource;
	}

	void print() const {
		cout << "max:" << endl;
		for (auto i : max) {
			for (auto j : i) {
				cout << j << " ";
			}
			cout << endl;
		}
		cout << "resource" << endl;
		for (auto i : resource) {
			cout << i << ' ';
		}
		cout << endl;
		cout << "distribution" << endl;
		for (auto i : distribution) {
			for (auto j : i) {
				cout << j << " ";
			}
			cout << endl;
		}
		cout << "needResource" << endl;
		for (auto i : needResource) {
			for (auto j : i) {
				cout << j << ' ';
			}
			cout << endl;
		}
	}
};

bool isSecure(int k, Data& d) {
	vector<int> work = d.getResource();
	vector<vector<int>> need = d.getNeedResource();
	vector<vector<int>> distribution = d.getDistribution();

	vector<bool> end(d.getN(), false);
	for (int i = 0; i < end.size(); ++i) {
		if (i == k) {
			end[i] = true;
		}
	}

	for (int j = 0; j < end.size(); ++j) {
		for (int i = 0; i < end.size(); ++i) {
			if (i == k) {
				continue;
			}
			if (end[i] == false) {
				bool record = true;
				for (int j = 0; j < work.size(); ++j) {
					//需要大于已有资源
					//直接退出
					if (work[j] < need[i][j]) {
						record = false;
						break;
					}
				}
				//进程都可以申请资源
				if (record) {
					end[i] = true;
					//释放资源
					for (int j = 0; j < work.size(); ++j) {
						work[j] += distribution[i][j];
					}
				}
			}
		}
	}
	for (auto b : end) {
		if (!b) {
			return false;
		}
	}
	return true;
}

bool banker(Data &d, int i, vector<int> request) {
	vector<vector<int>> need = d.getNeedResource();
	vector<int> resource = d.getResource();
	vector<vector<int>> distribution = d.getDistribution();

	for (int j = 0; j < request.size(); ++j) {
		//请求小于所需
		if (need[i][j] >= request[j]) {
			//资源大于请求
			if (resource[j] >= request[j]) {
				resource[j] -= request[j];
				distribution[i][j] += request[j];
				need[i][j] -= request[j];
				d.setDistribution(distribution);
				d.setResource(resource);
				d.setNeedResource(need);
				
				//不安全，撤销分配
				if (!isSecure(i, d)) {
					resource[j] += request[j];
					distribution[i][j] -= request[j];
					need[i][j] += request[j];
					d.setDistribution(distribution);
					d.setResource(resource);
					d.setNeedResource(need);
					cout << "状态不安全，无法匹配" << endl;
					return false;
				}
			} else {
				cout << "需等待" << endl;
				return false;
			}
		} else {//请求大于所需
			cout << "不能在分配资源" << endl;
			return false;
		}
	}
	cout << "分配成功" << endl;
	return true;
}

int main() {
	srand(NULL)=iuy7tre31`1q2e4rt6u8	cout << "系统资源数：" << endl;
	int m, n;
	cin >> m;
	cout << "系统总进程数：" << endl;
	cin >> n;

	Data d(n, m);

	vector<int> resource(m, 0);
//	cout << "不同资源数：" << endl;
	//string s1;
	//getline(cin, s1);

	for (int i = 0; i < resource.size(); ++i) {
		resource[i] = rand() % 10;
	}
	d.setResource(resource);
		
	vector<vector<int>> distribution(n);
	for (int i = 0; i < n; ++i) {
		distribution[i].resize(m);
		for (int j = 0; j < m; ++j) {
			distribution[i][j] = rand() % 10;
		}
	}
	d.setDistribution(distribution);

	vector<vector<int>> need(n);
	for (int i = 0; i < n; ++i) {
		need[i].resize(m);
		for (int j = 0; j < m; ++j) {
			need[i][j] = rand() % 10;
		}
	}
	d.setNeedResource(need);

	vector<vector<int>> max(n);
	for (int i = 0; i < n; ++i) {
		max[i].resize(m);
		for (int j = 0; j < m; ++j) {
			max[i][j] = distribution[i][j] + need[i][j];
		}
	}
	d.setMax(max);

	cout << "进程数：" << endl;
	int r;
	cin >> r;
	
	vector<int> request(m);
	cout << "请输入request数组:" << endl;
	for (int i = 0; i < request.size(); ++i) {
		cin >> request[i];
	}
	d.print();
	cout << "request" << endl;
	for (auto i : request) {
		cout << i << " ";
	}
	cout << endl;

	banker(d, r, request);


	return 0;
}
#endif
