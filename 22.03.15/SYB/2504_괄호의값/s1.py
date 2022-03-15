import sys
from collections import deque

sys.stdin = open('input.txt')

brackets = input()
q = deque()
ans = 0
tmp = 1

for i in range(len(brackets)):
    if brackets[i] == '(':
        tmp *= 2
        q.append(brackets[i])

    elif brackets[i] == '[':
        tmp *= 3
        q.append(brackets[i])

    elif brackets[i] == ')':
        if not q or q[-1] == '[' :
            ans = 0
            break
        if brackets[i-1] == '(':
            ans += tmp
        q.pop()
        tmp //= 2

    else:
        if not q or q[-1] == '(':
            ans = 0
            break
        if brackets[i-1] == '[':
            ans += tmp
        q.pop()
        tmp //= 3

if q:
    print(0)
else:
    print(ans)