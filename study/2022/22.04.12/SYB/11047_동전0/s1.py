import sys
sys.stdin = open('input.txt')

N, K = map(int, input().split())

moneys = [int(input()) for _ in range(N)]

cnt = 0
i = N - 1

while K != 0:
    if K < moneys[i]:
        i -= 1
    else:
        cnt += K // moneys[i]
        K = K % moneys[i]

print(cnt)
