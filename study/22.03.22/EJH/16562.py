import sys
N, M, k = map(int, sys.stdin.readline().split())

costs = [0]+list(map(int, sys.stdin.readline().split()))

friends = [i for i in range(N + 1)]


def find(x):
    if friends[x] != x:
        if costs[friends[x]] > costs[x]:
            costs[friends[x]] = costs[x]
        else:
            costs[x] = costs[friends[x]]
        friends[x] = find(friends[x])

    return friends[x]


def union(a, b):
    a = find(a)
    b = find(b)
    if costs[a] > costs[b]:
        costs[a] = costs[b]
    else:
        costs[b] = costs[a]

    if a < b:
        friends[b] = a
    else:
        friends[a] = b


for _ in range(M):
    v, w = map(int, sys.stdin.readline().split())
    union(v, w)

for i in range(1, N + 1):
    find(i)

friends_parent = set(friends[1:])
friends_parent = list(friends_parent)

tmp = set()
all_cost = 0
for i in range(1,N+1):
    a = find(i)
    if a in tmp:
        continue
    else:
        tmp.add(a)
        all_cost += costs[a]


if k < all_cost:
    print("Oh no")
else:
    print(all_cost)
