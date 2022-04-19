from collections import deque

F, S, G, U, D = map(int, input().split())


visited = [False for _ in range(F+1)]
visited[0] = True


def bfs():
    stairs = deque()
    stairs.append((S, 0))
    visited[S] = True
    while stairs:
        stair, count = stairs.popleft() 
        if stair == G:
            return count

        if stair + U <= F and not visited[stair + U]:
            visited[stair + U] = True
            stairs.append((stair + U, count + 1))
        if stair - D >= 1 and not visited[stair - D]:
            visited[stair - D] = True
            stairs.append((stair - D, count + 1))

    return "use the stairs"

print(bfs())



