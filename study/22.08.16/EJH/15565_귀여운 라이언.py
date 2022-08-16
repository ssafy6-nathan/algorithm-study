N, K = map(int, input().split())
arr = list(map(int, input().split()))

n = N + 1

end = 0
count = 0
for start in range(N):
    while count < K and end < N:
        if arr[end] == 1:
            count += 1
        end += 1
    if count == K and n > end - start:
        n = end - start
    if arr[start] == 1:
        count -= 1


if n == N + 1:
    n = -1
print(n)

