import sys

input = sys.stdin.readline

N, Q = map(int, input().split())

occupation = set()

chick = [0 for _ in range(Q)]

for i in range(Q):
    node = int(input())
    n = node
    while n > 0:
        if n in occupation:
            chick[i] = n
        n //= 2
    if chick[i] == 0:
        occupation.add(node)

for i in range(Q):
    print(chick[i])