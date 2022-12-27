N, M = map(int, input().split())

arr = [0 for _ in range(M)]
num = [i + 1 for i in range(N)]
visited = [False for _ in range(N)]


def permutation(index):
    if index == M:
        print(*arr)
        return

    for i in range(N):
        if not visited[i]:
            visited[i] = True
            arr[index] = num[i]
            permutation(index + 1)
            visited[i] = False


permutation(0)