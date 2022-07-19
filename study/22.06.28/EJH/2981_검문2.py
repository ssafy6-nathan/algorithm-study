import math
N = int(input())

arr = [int(input()) for _ in range(N)]

arr.sort()

re_arr = [arr[i] - arr[i - 1] for i in range(1, N)]

gcd = re_arr[0]
for i in range(1, N - 1):
    gcd = math.gcd(gcd, re_arr[i])

answer = set()

for n in range(2, int(gcd**0.5) + 1):
    if gcd % n == 0:
        if n in answer:
            break
        answer.add(n)
        answer.add(gcd // n)
answer.add(gcd)
print(*sorted(list(answer)))
