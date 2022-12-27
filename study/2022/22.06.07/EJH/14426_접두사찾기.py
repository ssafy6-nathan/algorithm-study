import sys
input = sys.stdin.readline

N, M = map(int, input().split())

word = [input().strip() for _ in range(N)]
pre = [input().strip() for _ in range(M)]

word.sort()
pre.sort()

count = 0
s = 0


for p in pre:
    for i in range(s, N):
        if p == word[i][:len(p)]:
            count += 1
            s = i
            break

print(count)