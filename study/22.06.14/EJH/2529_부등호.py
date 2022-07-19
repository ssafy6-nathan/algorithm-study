min_result = ""
max_result = ""


def dfs(cnt, end, arr, visited, result):
    global min_result, max_result
    if cnt == end:
        if len(min_result) == 0:
            min_result = result
        max_result = result
        return

    for i in range(10):
        if cnt == 0:
            visited[i] = True
            dfs(cnt + 1, end, arr, visited, result + str(i))
            visited[i] = False
        elif not visited[i]:
            if (arr[cnt - 1] == "<" and result[cnt - 1] < str(i)) or (arr[cnt - 1] == ">" and result[cnt - 1] > str(i)):
                visited[i] = True
                dfs(cnt + 1, end, arr, visited, result + str(i))
                visited[i] = False


k = int(input())
arr = list(input().split())
visited = [False for _ in range(10)]

dfs(0, k+1, arr, visited, "")

print(max_result)
print(min_result)