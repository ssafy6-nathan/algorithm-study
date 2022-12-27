import sys
input = sys.stdin.readline

N, M , B = map(int, input().split())
filed = []

min_block = float('inf')
max_block = 0

for i in range(N):
    blocks = list(map(int, input().split()))
    min_block = min(min(blocks), min_block)
    max_block = max(max(blocks), max_block)
    filed.append(blocks)

min_time = float('inf')
height = 0
for b in range(min_block, max_block + 1):
    time = 0
    h = 0
    need_block = 0
    for r in range(N):
        for c in range(M):
            block = b - filed[r][c]
            need_block += block

            if block > 0:
                time += block
            elif block < 0:
                time += -block * 2
    if need_block > B:
        continue
    if min_time >= time:
        min_time = time
        height = b

print(min_time, height)