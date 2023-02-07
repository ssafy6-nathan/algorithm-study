n = int(input())
m = int(input())

graph = [ [] for _ in range(n + 1)]

for _ in range(m):
    start, end, cost = map(int, input().split())
    graph[start].append((end, cost))

go, arrive = map(int, input().split())


def find_route(go, arrive):
    cost = 0
    city = [float('inf') for _ in range(n + 1)]
    visited = [False for _ in range(n + 1)]
    route = [[] for _ in range(n + 1)]
    route[go] = [go]
    visited[go] = True
    city[go] = 0
    next = go
    while True:
        for i in range(len(graph[next])):
            end, cost = graph[next][i]
            if city[end] > city[next] + cost:
                city[end] = city[next] + cost
                route[end] = route[next] + [end]


        index = 0
        i_cost = float('inf')
        for i in range(1, n + 1):
            if visited[i]:
                continue
            if i_cost > city[i]:
                index = i
                i_cost = city[i]

        visited[index] = True
        next = index

        if next == arrive:
            break

    return city[arrive], route[arrive]


cost, route = find_route(go, arrive)

print(cost)
print(len(route))
print(*route)