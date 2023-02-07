import sys
sys.stdin = open('input.txt')

N, M = map(int, input().split())

trees = list(map(int, input().split()))

left, right = 0, max(trees)

while left <= right:
    mid = (left + right) // 2
    total = 0

    for tree in trees:
        if tree >= mid:
            total += tree - mid

    if total >= M:
        left = mid + 1
    else:
        right = mid - 1

print(right)