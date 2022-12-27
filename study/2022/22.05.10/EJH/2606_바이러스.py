from collections import deque

N = int(input())
V = int(input())

visited = [False for _ in range(N+1)]
com = {i: [] for i in range(1, N + 1)}
for _ in range(V):
    n1, n2 = map(int, input().split())
    com[n1].append(n2)
    com[n2].append(n1)

qu = deque()
qu.append(1)
visited[1] = True
while qu:
    n = qu.popleft()

    for nn in com[n]:
        if not visited[nn]:
            visited[nn] = True
            qu.append(nn)

print(visited.count(True)-1)