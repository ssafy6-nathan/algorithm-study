import sys
import heapq

N = int(sys.stdin.readline())

arr = [[*map(int, sys.stdin.readline().split())] for _ in range(N)]
arr.sort()

room = []
heapq.heappush(room, arr[0][1])

for i in range(1, N):
    if arr[i][0] >= room[0]:
        heapq.heappop(room)
        heapq.heappush(room, arr[i][1])
    else:
        heapq.heappush(room, arr[i][1])

print(len(room))
