N = int(input())

stars = [['*'] * N for _ in range(N)]
cnt = 0
n = N
while n != 1:
    n = int(n / 3)
    cnt += 1


for k in range(cnt):
    index = [i for i in range(N) if (i // 3 ** k) % 3 == 1]
    for i in index:
        for j in index:
            stars[i][j] = ' '

for i in range(N):
    stars[i] = "".join(stars[i])

print('\n'.join(stars))
