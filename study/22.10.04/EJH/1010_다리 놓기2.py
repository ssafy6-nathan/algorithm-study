# 조합 공식으로 푸는법
import math

T = int(input())

for _ in range(T):
    N, M = map(int, input().split())
    dp = [[0 for _ in range(M + 1)] for _ in range(N + 1)]

    bridge = math.factorial(M) // (math.factorial(N) * math.factorial(M - N))
    print(bridge)
