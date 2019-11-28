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
	vector<vector<int>> max;		//���������N��������ҪM���������
	vector<int> resource;		//��������Դ����
	vector<vector<int>> distribution;	//������Դ����
	vector<vector<int>> needResource;	//������Դ����

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
					//��Ҫ����������Դ
					//ֱ���˳�
					if (work[j] < need[i][j]) {
						record = false;
						break;
					}
				}
				//���̶�����������Դ
				if (record) {
					end[i] = true;
					//�ͷ���Դ
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
		//����С������
		if (need[i][j] >= request[j]) {
			//��Դ��������
			if (resource[j] >= request[j]) {
				resource[j] -= request[j];
				distribution[i][j] += request[j];
				need[i][j] -= request[j];
				d.setDistribution(distribution);
				d.setResource(resource);
				d.setNeedResource(need);
				
				//����ȫ����������
				if (!isSecure(i, d)) {
					resource[j] += request[j];
					distribution[i][j] -= request[j];
					need[i][j] += request[j];
					d.setDistribution(distribution);
					d.setResource(resource);
					d.setNeedResource(need);
					cout << "״̬����ȫ���޷�ƥ��" << endl;
					return false;
				}
			} else {
				cout << "��ȴ�" << endl;
				return false;
			}
		} else {//�����������
			cout << "�����ڷ�����Դ" << endl;
			return false;
		}
	}
	cout << "����ɹ�" << endl;
	return true;
}

int main() {
	srand(NULL)=iuy7tre31`1q2e4rt6u8	cout << "ϵͳ��Դ����" << endl;
	int m, n;
	cin >> m;
	cout << "ϵͳ�ܽ�������" << endl;
	cin >> n;

	Data d(n, m);

	vector<int> resource(m, 0);
//	cout << "��ͬ��Դ����" << endl;
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

	cout << "��������" << endl;
	int r;
	cin >> r;
	
	vector<int> request(m);
	cout << "������request����:" << endl;
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
