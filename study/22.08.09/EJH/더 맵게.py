import heapq


def solution(scoville, K):
    answer = 0
    heap = []
    for s in scoville:
        heapq.heappush(heap, s)
    k = heapq.heappop(heap)
    heapq.heappush(heap, k)

    while k < K and len(heap) > 1:
        answer += 1
        s1 = heapq.heappop(heap)
        s2 = heapq.heappop(heap)
        k = s1 + s2 * 2
        heapq.heappush(heap, k)

        k = heapq.heappop(heap)
        heapq.heappush(heap, k)

    if k < K and len(heap) == 1:
        answer = -1
    return answer


print(solution([1, 2, 3, 9, 10, 12], 7))