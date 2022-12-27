# 다익스트라 알고리즘 사용
import heapq
import sys

V, E = map(int, sys.stdin.readline().split())

INF = float('inf')

graph = [[] for _ in range(V + 1)]

for _ in range(E):
    a, b, c = map(int, sys.stdin.readline().split())
    graph[a].append((b, c))
result = INF


def dijkstra(start):
    global result

    if not graph[start]:
        return

    queue = []
    distance = [INF for _ in range(V + 1)]
    visited = [False for _ in range(V + 1)]

    for n_n, n_d in graph[start]:
        distance[n_n] = n_d
        heapq.heappush(queue, (distance[n_n], n_n))

    while queue:
        d, n = heapq.heappop(queue)

        if d != 0 and n == start:
            distance[start] = d
            break
        if visited[n]:
            continue
        visited[n] = True

        for n_n, n_d in graph[n]:
            if visited[n_n]:
                continue
            if distance[n_n] > d + n_d:
                distance[n_n] = d + n_d
                heapq.heappush(queue, (distance[n_n], n_n))

    if result > distance[start]:
        result = distance[start]


for i in range(1, V + 1):
    dijkstra(i)

if result == INF:
    result = -1
print(result)
