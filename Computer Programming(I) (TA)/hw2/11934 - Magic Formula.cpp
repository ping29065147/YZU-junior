#include <iostream>

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
	int a, b, c, d, L;

	while (cin >> a >> b >> c >> d >> L, a + b + c + d + L != 0)
	{
		int cnt = 0;
		for (int i = 0; i <= L; ++i) if ((a * i * i + b * i + c) % d == 0) ++cnt;
		cout << cnt << "\n";
	}
}