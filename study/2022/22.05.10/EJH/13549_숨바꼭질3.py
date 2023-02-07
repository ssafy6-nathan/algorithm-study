from collections import deque

N, K = map(int, input().split())


q = deque()
visited = [False] * 100001
dp = [0] * 100001
q.append(N)
visited[N] = True
answer = 100000
while q:
    X = q.popleft()

    if X * 2 <= 100000 and not visited[X * 2]:
        visited[X * 2] = True
        dp[X * 2] = dp[X]
        q.appendleft(X * 2)

    if X - 1 >= 0 and not visited[X - 1]:
        visited[X - 1] = True
        dp[X - 1] = dp[X] + 1
        q.append(X - 1)

    if X + 1 <= 100000 and not visited[X + 1]:
        visited[X + 1] = True
        dp[X + 1] = dp[X] + 1
        q.append(X + 1)

print(dp[K])
