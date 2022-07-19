arr = [False, False] + [True] * (123456 * 2)

for i in range(2, 10000):         # 에라토스테네스의 체
    if arr[i]:
        for j in range(i * 2, 123456 * 2 + 1, i):
            arr[j] = False


while True:
    n = int(input())
    count = 0
    if n == 0:
        break

    for i in range(n + 1, 2 * n +1):
        if arr[i]:
            count += 1
    print(count)
