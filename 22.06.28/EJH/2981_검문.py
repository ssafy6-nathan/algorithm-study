N = int(input())

arr = [int(input()) for _ in range(N)]

arr.sort()

re_arr = [arr[i] - arr[i - 1] for i in range(1, N)]


def find_gcd(a, b):
    while b > 0:
        a, b = b, a % b
    return a


gcd = re_arr[0]
for i in range(1, N - 1):
    gcd = find_gcd(gcd, re_arr[i])

answer = []

for n in range(2, gcd + 1):
    if gcd % n == 0:
        answer.append(n)

print(*answer)
