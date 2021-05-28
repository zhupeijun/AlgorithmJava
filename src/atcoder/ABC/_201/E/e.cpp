#include <iostream>
#include <vector>

using namespace std;

typedef long long ll;

struct Node {
    int v;
    ll w;

    Node(int v, ll w) : v(v), w(w) { }
};

const int MAX = 200005;
const int MOD = 1000000007;

vector< vector<Node> > g;
ll ans;
int v0[MAX];
int v1[MAX];

void dfs(int u, int fa, ll k) {
    v0[u] = v1[u] = 0;
    ll cnt = 0;
    int m = (int)g[u].size();
    for (int i = 0; i < m; ++i) {
        Node node = g[u][i];
        int v = node.v;
        long w = node.w;

        if (v == fa) continue;
        dfs(v, u, k);
        int x0, x1;
        if (w&k) {
            x0 = v1[v];
            x1 = v0[v]+1;
        } else {
            x0 = v0[v]+1;
            x1 = v1[v];
        }
        cnt = cnt + 1LL*x0*x1;
        v0[u] += x0;
        v1[u] += x1;
    }
    cnt = ((1LL*v0[u]*v1[u] - cnt)%MOD + MOD)%MOD;
    ans = (ans + ((k%MOD)*((cnt+v1[u])%MOD)))%MOD;
}

int main() {
    int N;
    scanf("%d", &N);

    for (int i = 0; i < N; ++i) {
        g.push_back(vector<Node>());
    }

    for (int i = 1; i < N; ++i) {
        int u, v;
        ll w;
        scanf("%d %d %lld", &u, &v, &w);
        --u; --v;
        g[u].push_back(Node(v,w));
        g[v].push_back(Node(u,w));
    }
    
    ans = 0;
    for (int i = 0; i < 60; ++i) {
        ll k = 1LL<<i;
        dfs(0, -1, k);
    }
    printf("%lld\n", ans);
    return 0;
}
