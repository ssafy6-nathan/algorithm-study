from collections import deque

dr = [1, 0, -1, 0]
dc = [0, 1, 0, -1]


def check_len(place, visited, r, c):
    queue = deque()
    queue.append((r, c, 0))
    visited[r][c] = True
    while queue:
        r, c, l = queue.popleft()
        for d in range(4):
            nr = r + dr[d]
            nc = c + dc[d]

            if nr < 0 or nr >= 5 or nc < 0 or nc >= 5:
                continue
            if not visited[nr][nc]:
                visited[nr][nc] = True
                if place[nr][nc] == 'P':
                    return False
                elif place[nr][nc] == 'O' and l < 1:
                    queue.append((nr, nc, l + 1))
    return True


def solution(places):
    answer = []
    for place in places:
        flag = True
        visited = [[False for _ in range(5)] for _ in range(5)]
        for r in range(5):
            for c in range(5):
                if place[r][c] == 'P':
                    if not check_len(place, visited, r, c):
                        flag = False
                        break
            if not flag:
                break
        if flag:
            answer.append(1)
        else:
            answer.append(0)
    return answer


print(solution([["POOOP",
                 "OXXOX",
                 "OPXPX",
                 "OOXOX",
                 "POXXP"],

                ["POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"],
                ["PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"],
                ["OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"],
                ["PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"]]))