import sys
input = sys.stdin.readline

N = int(input())
S = set()


def cal(s):
    global S
    command = s.split()

    if len(command) == 1:
        if command[0] == 'all':
            S = set([i for i in range(1, 21)])
        else:
            S = set()

        return

    m = command[0]
    n = int(command[1])

    if m == "add":
        S.add(n)
    elif m == "remove":
        S.discard(n)
    elif m == "check":
        if n in S:
            print(1)
        else:
            print(0)
    elif m == "toggle":
        if n in S:
            S.discard(n)
        else:
            S.add(n)


for _ in range(N):
    cal(input())