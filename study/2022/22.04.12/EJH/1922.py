import heapq

N = int(input())
M = int(input())

parents = [i for i in range(0, N + 1)]
heap = []
for _ in range(M):
    n1, n2, weight = map(int, input().split())
    heapq.heappush(heap, (weight, n1, n2))


def find(a):
    if a == parents[a]:
        return a
    parents[a] = find(parents[a])
    return parents[a]


def union(a, b):
    aRoot = find(a)
    bRoot = find(b)
    if aRoot == bRoot:
        return False
    parents[bRoot] = aRoot
    return True


count = 0
weight = 0

while heap:
    w, n1, n2 = heapq.heappop(heap)

    if union(n1, n2):
        weight += w
        count += 1

    if count == N - 1:
        break

print(weight)
