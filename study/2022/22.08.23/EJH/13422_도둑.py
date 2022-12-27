T = int(input())

for _ in range(T):
    N, M, K = map(int, input().split())
    arr = list(map(int, input().split()))

    if N == M:
        if sum(arr) < K:
            print(1)
        else:
            print(0)
        continue

    arr += arr[0:M - 1]

    l_point = 0
    r_point = 0
    count = 0
    money = 0

    for _ in range(M):
        money += arr[r_point]
        r_point += 1
    if money < K:
        count += 1

    while l_point <= r_point < len(arr):
        money -= arr[l_point]
        money += arr[r_point]
        l_point += 1
        r_point += 1

        if money < K:
            count += 1

    print(count)