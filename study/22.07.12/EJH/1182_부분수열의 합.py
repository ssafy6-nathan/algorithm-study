answer = 0


def dfs(count , N, S, arr, start, sub_arr):
    global answer

    if count != 0 and sum(sub_arr) == S:
        answer += 1
    if count == N:
        return

    for i in range(start, N):
        dfs(count + 1, N, S, arr, i + 1, sub_arr + [arr[i]])


N, S = map(int, input().split())

arr = list(map(int, input().split()))

dfs(0 , N, S, arr, 0, [])

print(answer)