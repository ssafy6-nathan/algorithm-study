dr = [1, 0, -1, 0]
dc = [0, 1, 0, -1]
count = 0

members = set()


def dfs(Y, S, arr, visited, member):
    global count
    if Y > 3:
        return
    if Y + S == 7:
        member.sort()

        members.add(tuple(member))
        return

    for m in member:
        r = m[0]
        c = m[1]
        for d in range(4):
            nr = r + dr[d]
            nc = c + dc[d]

            if nr < 0 or nc < 0 or nr >= 5 or nc >= 5:
                continue

            if not visited[nr][nc]:
                visited[nr][nc] = True
                if arr[nr][nc] == 'Y':
                    dfs(Y + 1, S, arr, visited,  member + [(nr, nc)])
                else:
                    dfs(Y, S + 1, arr, visited, member + [(nr, nc)])
                visited[nr][nc] = False


arr = [list(input().strip()) for _ in range(5)]


count = 0

for r in range(5):
    for c in range(5):
        visited = [[False for _ in range(5)] for _ in range(5)]
        visited[r][c] = True
        if arr[r][c] == 'Y':
            dfs(1, 0, arr, visited,  [(r, c)])
        else:
            dfs(0, 1, arr, visited,  [(r, c)])

print(len(members))