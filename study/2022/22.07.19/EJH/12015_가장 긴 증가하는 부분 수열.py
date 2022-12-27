N = int(input())
arr = [0] + list(map(int, input().split()))

count = 0


def dfs(n, start, index):
    global count
    if n > count:
        count = n

    for i in range(start, N):
        if index == -1:
            dfs(n + 1, i + 1, i)
        else:
            if arr[index] < arr[i]:
                dfs(n + 1, i + 1, i)


dfs(0, 0, -1)

print(count)