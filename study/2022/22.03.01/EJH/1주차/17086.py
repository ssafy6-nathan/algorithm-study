N, M = map(int, input().split())

dxy = [(-1, -1,),
       (-1, 0,),
       (-1, 1,),
       (0, 1,),
       (1, 1,),
       (1, 0,),
       (1, -1,),
       (0, -1,)]

global safe_dist


def bfs():
    global safe_dist
    while shark:
        x, y = shark.pop(0)
        for (dx, dy) in dxy:
            nx = x + dx
            ny = y + dy
            if 0 <= nx < N and 0 <= ny < M:
                if arr[nx][ny] == 0:
                    shark.append((nx, ny))
                    safe_dist = arr[nx][ny] = arr[x][y] + 1

    return


# 시작
# 초기화
arr = []
shark = []
safe_dist = 0

# 입력
for i in range(N):
    temp = list(map(int, input().split()))
    for j in range(M):
        if temp[j] == 1:
            shark.append((i, j))
    arr.append(temp)

# 계산
bfs()

# 출력
print(safe_dist - 1)
