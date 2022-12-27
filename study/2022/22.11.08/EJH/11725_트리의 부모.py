from collections import deque
import sys

input = sys.stdin.readline

N = int(input())
nodes = [0 for _ in range(N + 1)]
tree = [[] for _ in range(N + 1)]
q = deque()

for i in range(N - 1):
    p, c = map(int, input().split())
    tree[p].append(c)
    tree[c].append(p)


que=deque([1])

while que:
    x=que.popleft()
    for i in tree[x]:
        if nodes[i] == 0:
            nodes[i] = x
            que.append(i)

for i in range(2, N + 1):
    print(nodes[i])