n, m = map(int, input().split())
arr = [0] + list(map(int, input().split()))

for i in range(1, n + 1):
    arr[i] += arr[i - 1]

max_money = 0

for i in range(n - m):
    money = arr[i + m] - arr[i]
    if money > max_money:
        max_money = money

print(max_money)