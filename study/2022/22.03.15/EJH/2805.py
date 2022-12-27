import sys
N, M = map(int, sys.stdin.readline().split())
trees = list(map(int, sys.stdin.readline().split()))

start = 1
end = max(trees)

while start <= end:
    cut = (start + end) // 2

    total = 0   # 잘린 나무 통합
    for tree in trees:
        if tree > cut:
            total += tree - cut

    # 이분 탐색
    if total >= M:
        start = cut + 1
    else:
        end = cut - 1
print(end)
