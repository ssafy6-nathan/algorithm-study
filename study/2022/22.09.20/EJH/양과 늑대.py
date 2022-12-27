max_sheep = 0


def dfs(visited, info, graph, route, sheep, wolf):
    global max_sheep
    if max_sheep < sheep:
        max_sheep = sheep

    for r in route:
        if not visited[r]:
            visited[r] = True
            if info[r] == 1:
                if sheep > wolf + 1:
                    dfs(visited, info, graph, route.union(graph[r]), sheep, wolf + 1)
            else:
                dfs(visited, info, graph, route.union(graph[r]), sheep + 1, wolf)
            visited[r] = False


def solution(info, edges):
    global max_sheep
    max_sheep = 0
    answer = 0
    graph = {}
    for i in range(len(info)):
        graph[i] = set()

    for edge in edges:
        x, y = edge
        graph[x].add(y)

    visited = [False for _ in range(len(info))]
    visited[0] = True
    route = graph[0]
    dfs(visited, info, graph, route, 1, 0)
    answer = max_sheep
    return answer


print(solution([0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1],
               [[0, 1], [1, 2], [1, 4], [0, 8], [8, 7], [9, 10], [9, 11], [4, 3], [6, 5], [4, 6], [8, 9]]))
print(solution([0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0],
               [[0, 1], [0, 2], [1, 3], [1, 4], [2, 5], [2, 6], [3, 7], [4, 8], [6, 9], [9, 10]]))
