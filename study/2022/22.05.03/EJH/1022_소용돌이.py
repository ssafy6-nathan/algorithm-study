import sys


def getValue(r, c):
    n = max(abs(r), abs(c))
    last = 2 * n + 1
    last = last ** 2
    if r == n:  # 아래 변
        return last - (n - c)
    elif c == -n:  # 왼쪽 변
        return last - (2 * n) - (n - r)
    elif r == -n:  # 윗 변
        return last - (4 * n) - (n + c)
    else:  # 오른쪽 변
        return last - (6 * n) - (n + r)


r1, c1, r2, c2 = map(int, input().split())

max_len = 0
for y in range(r1, r2 + 1):
    for x in range(c1, c2 + 1):
        max_len = max(max_len, len(str(getValue(y, x))))

output = []
for r in range(r1, r2 + 1):
    for c in range(c1, c2 + 1):
        output.append(f'{getValue(r, c): >{max_len}}')
        output.append(' ')
    output[-1] = '\n'
output[-1] = ''
sys.stdout.write(''.join(output))
