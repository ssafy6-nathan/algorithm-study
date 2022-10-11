from collections import deque

T = int(input())

for _ in range(T):
    p = input()
    n = int(input())
    arr = deque(input()[1:-1].split(','))

    if n == 0:
        arr = []

    error = False
    flag = True
    for P in p:
        if P == 'R':
            flag = not flag
        else:
            if len(arr) > 0:
                if flag:
                    arr.popleft()
                else:
                    arr.pop()
            else:
                error = True
                break
    if error:
        print("error")
    else:
        if not flag:
            arr.reverse()
        print("[" + ",".join(arr) + "]")