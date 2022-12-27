N, M = map(int, input().split())

arr = [0 for _ in range(M)]
num = [i + 1 for i in range(N)]


def duplicate_combination(index, start):
    if index == M:
        print(*arr)
        return

    for i in range(start, N):
        arr[index] = num[i]
        duplicate_combination(index + 1, i)


duplicate_combination(0, 0)