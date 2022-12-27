import heapq
dr = [0, 0, 1, -1]
dc = [1, -1, 0, 0]

M, N = map(int, input().split())
arr = []

for i in range(M):
    arr.append(list(map(int, input().split())))

dp = [[0 for _ in range(N)] for _ in range(M)]
dp[0][0] = 1

q = []
heapq.heappush(q, (-arr[0][0], 0, 0))
while q:
    h, i, j = heapq.heappop(q)
    for d in range(4):
        nr = i + dr[d]
        nc = j + dc[d]

        if nr < 0 or nc < 0 or nr >= M or nc >= N:
            continue
        if arr[i][j] > arr[nr][nc]:
            if dp[nr][nc] == 0:
                heapq.heappush(q, (-arr[nr][nc], nr, nc))
            dp[nr][nc] += dp[i][j]

print(dp[M - 1][N - 1])