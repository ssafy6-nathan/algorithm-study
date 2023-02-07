import sys
input = sys.stdin.readline

N, M = map(int, input().split())

train = [0 for i in range(N + 1)]


for _ in range(M):
    comand = list(map(int, input().split()))

    if comand[0] == 1:
        train[comand[1]] = train[comand[1]] | (1 << comand[2] - 1)
    elif comand[0] == 2:
        train[comand[1]] = train[comand[1]] & ~(1 << comand[2] - 1)
    elif comand[0] == 3:
        train[comand[1]] = train[comand[1]] << 1
        train[comand[1]] = train[comand[1]] & ~(2 ** 20)
    elif comand[0] == 4:
        train[comand[1]] = train[comand[1]] >> 1

go = []
count = 0
for i in range(1, N + 1):
    if train[i] not in go:
        count += 1
        go.append(train[i])

print(count)