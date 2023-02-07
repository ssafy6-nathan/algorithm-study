import sys

sys.setrecursionlimit(10 ** 6)  # 재귀허용 깊이 추가


def out(x, y, d, grid, dic):
    # 방향에 따라 x, y 좌표를 업데이트
    nx = x + dic[d][0]
    ny = y + dic[d][1]

    if nx >= len(grid):  # 아래쪽으로 넘어갈 때
        nx = 0
    elif nx < 0:  # 위쪽으로 넘어갈 때
        nx = len(grid) - 1
    if ny >= len(grid[0]):  # 오른쪽으로 넘어갈 때
        ny = 0
    elif ny < 0:  # 왼쪽으로 넘어갈 때
        ny = len(grid[0]) - 1

    return nx, ny


def dfs(state, org, route, grid):
    # 방향: 아래쪽에서, 왼쪽에서, 위쪽에서, 오른쪽에서 빛이 들어옴
    dic = {0: [-1, 0], 1: [0, 1], 2: [1, 0], 3: [0, -1]}
    x = state[0]
    y = state[1]
    d = state[2]
    visited[d][x][y] = 1

    nx, ny = out(x, y, d, grid, dic)  # 좌표 업데이트
    value = grid[nx][ny]

    # 어느 방향에서 온 것인지를 고려한 계산법
    # ex) 현재 value=R이고, 위쪽 노드에서 온 것(d=2)이라면 우회전 즉 d=3이 되어야 함
    if value == 'R':
        d = (d + 5) % 4
    elif value == 'L':
        d = (d + 7) % 4

    # 처음 노드와 비교해서 싸이클일 경우 answer에 싸이클 길이 추가
    if org[0] == nx and org[1] == ny and org[2] == d:
        answer.append(route)
        return

    if not visited[d][nx][ny]:  # 방문하지 않는 노드가 있으면 dfs 재귀반복
        dfs([nx, ny, d], org, route + 1, grid)


def solution(grid):
    global answer, visited
    answer = []

    # visited = n(행 갯수) x m(열 갯수) x d(방향)
    visited = [[[0] * len(grid[0]) for _ in range(len(grid))] for _ in range(4)]

    for i in range(len(grid)):
        for j in range(len(grid[0])):
            for d in range(4):  # 4가지 방향
                dfs([i, j, d], [i, j, d], 1, grid)

    return sorted(answer)
