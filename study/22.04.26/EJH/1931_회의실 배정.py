import heapq
import sys
N = int(sys.stdin.readline())

heap = []

for _ in range(N):
    start_t, end_t = map(int, sys.stdin.readline().split())
    heapq.heappush(heap, (end_t, start_t))

end_t, start_t = heapq.heappop(heap)
last_t = end_t
count = 1

while heap:
    end_t, start_t = heapq.heappop(heap)

    if start_t >= last_t:
        last_t = end_t
        count += 1

print(count)