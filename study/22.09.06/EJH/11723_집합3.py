import sys
input = sys.stdin.readline

N = int(input())

S = 0


def cal(s):
    global S
    command = s.split()

    if len(command) == 1:
        if command[0] == 'all':
            S = S | ~(2 ** 20)
        else:
            S = 0

        return

    m = command[0]
    n = int(command[1])

    if m == "add":
        S = S | (1 << (n - 1))
    elif m == "remove":
        S = S & ~ (1 << (n - 1))
    elif m == "check":
        if S & (1 << (n - 1)) > 0:
            print(1)
        else:
            print(0)
    elif m == "toggle":
        S = S ^ (1 << (n - 1))


for i in range(N):
    cal(input())