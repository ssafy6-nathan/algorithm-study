from collections import deque
import sys
input = sys.stdin.readline

dr = [1, -1, 0, 0]
dc = [0, 0, 1, -1]


def melt(arr, N, M):
    new_arr = [[0 for _ in range(M)] for _ in range(N)]
    total_count = 0
    for r in range(N):
        for c in range(M):
            if arr[r][c] != 0:
                count = 0
                for d in range(4):
                    nr = r + dr[d]
                    nc = c + dc[d]

                    if arr[nr][nc] == 0:
                        count += 1
                if arr[r][c] < count:
                    total_count += arr[r][c]
                    new_arr[r][c] = 0
                else:
                    total_count += count
                    new_arr[r][c] = arr[r][c] - count

    return new_arr, total_count


def bfs(arr, r, c, N, M):
    visited = [[False for _ in range(M)] for _ in range(N)]
    q = deque()
    q.append((r, c))
    visited[r][c] = True
    total_count = arr[r][c]

    while q:
        r, c = q.popleft()

        for d in range(4):
            nr = r + dr[d]
            nc = c + dc[d]

            if arr[nr][nc] != 0 and not visited[nr][nc]:
                visited[nr][nc] = True
                total_count += arr[nr][nc]
                q.append((nr, nc))

    return total_count


N, M = map(int, input().split())

arr = [list(map(int, input().split())) for _ in range(N)]


total_h = 0
time = 0


for i in range(N):
    total_h += sum(arr[i])

while total_h > 0:
    time += 1
    arr, melt_h = melt(arr, N, M)
    total_h -= melt_h

    check_break = False
    for r in range(N):
        for c in range(M):
            if arr[r][c] != 0:
                count_h = bfs(arr, r, c, N, M)
                check_break = True
                break
        if check_break:
            break

    if total_h != count_h:
        break

if total_h == 0:
    print(0)
else:
    print(time)

