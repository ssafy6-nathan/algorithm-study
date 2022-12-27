import sys
input = sys.stdin.readline

N = int(input())

S = [False for i in range(21)]


def cal(s):
    global S
    command = s.split()

    if len(command) == 1:
        if command[0] == 'all':
            S = [True for i in range(21)]
        else:
            S = [False for i in range(21)]

        return

    m = command[0]
    n = int(command[1])

    if m == "add":
        S[n] = True
    elif m == "remove":
        S[n] = False
    elif m == "check":
        if S[n]:
            print(1)
        else:
            print(0)
    elif m == "toggle":
        S[n] = not S[n]


for i in range(N):
    cal(input())