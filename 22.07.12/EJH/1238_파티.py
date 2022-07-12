import heapq
import sys

input = sys.stdin.readline


N, M, X = map(int, input().split())

arr = [[] for _ in range(N + 1)]
re_arr = [[] for _ in range(N + 1)]
for _ in range(M):
    s, e, t = map(int, input().split())
    arr[s].append((e, t))
    re_arr[e].append((s, t))


def dijkstra(start, village):
    q = []
    distance = [100000000 for _ in range(N + 1)]

    heapq.heappush(q, (start, 0))
    distance[start] = 0

    while q:
        town, time = heapq.heappop(q)

        if distance[town] < time:
            continue

        for n_town, n_time in village[town]:
            c_time = time + n_time
            if distance[n_town] > c_time:
                distance[n_town] = c_time
                heapq.heappush(q, (n_town, c_time))

    return distance


back = dijkstra(X, arr)
go = dijkstra(X, re_arr)
answer = [0] * (N + 1)
for s in range(1, N + 1):
    answer[s] = go[s] + back[s]


print(max(answer))