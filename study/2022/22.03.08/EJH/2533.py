import sys
sys.setrecursionlimit(10**9)
N = int(sys.stdin.readline())

graph = [[] for _ in range(N + 1)]

for _ in range(N - 1):
    u, v = map(int, sys.stdin.readline().split())
    graph[u].append(v)
    graph[v].append(u)

visit = [False for _ in range(N + 1)]
dp = [[0, 0] for _ in range(N + 1)]


def early_adapter(x):
    visit[x] = True
    dp[x][0] = 1  # x가 얼리 어답터인 경우
    dp[x][1] = 0  # x가 얼리 어답터가 아닌 경우

    for y in graph[x]:
        if not visit[y]:
            early_adapter(y)
            dp[x][0] += min(dp[y][0], dp[y][1])  # x가 얼리 어답터인 경우 y는 얼리 어답터일 수도 있고 아닐 수도 있다.
            dp[x][1] += dp[y][0]  # x가 얼리 어답터가 아닌 경우 y는 얼리 어답터이어야만 한다.


early_adapter(1)
print(min(dp[1][0], dp[1][1]))
