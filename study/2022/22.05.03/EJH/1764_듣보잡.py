import heapq

N, M = map(int, input().split())

de = set()

debo = []

for _ in range(N):
    de.add(input())

for _ in range(M):
    s = input()
    if s in de:
        heapq.heappush(debo, s)

print(len(debo))
while debo:
    print(heapq.heappop(debo))


