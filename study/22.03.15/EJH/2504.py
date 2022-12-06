# (()[[]])([])
# ((+)*2 [[+]*3]*3)*2 ([+] * 3) * 2
# 밖의 괄호 부터 곱 해주고 () [] 처럼 연속인 경우에 더한다.

from collections import deque

string = input()

barcket = deque()
score = 0
tmp = 1
before_s = ''   # 직전 괄호 체크
for s in string:
    if s == '(':
        tmp *= 2
        barcket.append(s)
    elif s == '[':
        tmp *= 3
        barcket.append(s)
    elif s == ')':
        if not barcket or barcket.pop() != '(':
            score = 0
            break
        elif before_s == '(':   # 직전 괄호가 맞을 때 점수 계산
            score += tmp
        tmp //= 2

    elif s == ']':
        if not barcket or barcket.pop() != '[':
            score = 0
            break
        elif before_s == '[':   # 직전 괄호가 맞을 때 점수 계산
            score += tmp
        tmp //= 3
    before_s = s

if barcket:
    score = 0
print(score)