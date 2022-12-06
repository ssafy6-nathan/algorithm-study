import sys
sys.stdin = open('input.txt')

N = int(input())
A = list(map(int, input().split()))
B = list(map(int, input().split()))

ans = 0

A.sort()
for i in range(N):
    a = A[i]
    b = B.pop(B.index(max(B)))

    ans += a * b

print(ans)