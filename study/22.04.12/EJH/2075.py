import heapq

N = int(input())

heap = []

for i in range(N):
    nums = list(map(int, input().split()))
    if i == 0:
        for num in nums:
            heapq.heappush(heap, num)
    else:
        for num in nums:
            if num > heap[0]:
                heapq.heappop(heap)
                heapq.heappush(heap, num)

print(heapq.heappop(heap))
