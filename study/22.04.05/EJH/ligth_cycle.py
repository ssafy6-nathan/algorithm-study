dr = [1, 0, -1, 0]
dc = [0, -1, 0, 1]


def check_cycle(R, C, r, c, d, grid, visited):
    start_r, start_c, start_d = r, c, d
    count = 0
    visited[r][c][d] = True

    while 1:
        r = (r + dr[d]) % R
        c = (c + dc[d]) % C
        count += 1

        if grid[r][c] == 'R':
            d = (d + 1) % 4
        elif grid[r][c] == 'L':
            d = (d - 1) % 4

        if visited[r][c][d]:
            if (r, c, d) == (start_r, start_c, start_d):
                return count
            else:
                return 0

        visited[r][c][d] = True


def solution(grid):
    answer = []
    R = len(grid)
    C = len(grid[0])

    visited = [[[False] * 4 for _ in range(C)] for _ in range(R)]

    for r in range(R):
        for c in range(C):
            for d in range(4):
                if not visited[r][c][d]:
                    cycle = check_cycle(R, C, r, c, d, grid, visited)
                    if cycle > 0:
                        answer.append(cycle)
    answer.sort()
    return answer


print(solution(["SL", "LR"]))
print(solution(["S"]))
print(solution(["R", "R"]))
