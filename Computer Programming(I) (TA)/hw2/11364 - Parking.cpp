#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

static auto fast_io = []
{
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	return 0;
}();

int main()
{
	int T, N, a;
	
	cin >> T;
	while (T--)
	{
		vector<int> V;

		cin >> N;
		while (N--) cin >> a, V.emplace_back(a);
		sort(V.begin(), V.end());

		cout << (V[V.size() - 1] - V[0]) * 2 << "\n";
	}
}