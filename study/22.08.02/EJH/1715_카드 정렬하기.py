import heapq
import sys

input = sys.stdin.readline


N = int(input())
cards = []
for _ in range(N):
    heapq.heappush(cards, int(input()))


answer = 0

while len(cards) > 1:
    cards1 = heapq.heappop(cards)
    cards2 = heapq.heappop(cards)
    answer += cards1 + cards2
    heapq.heappush(cards, cards1 + cards2)

print(answer)
