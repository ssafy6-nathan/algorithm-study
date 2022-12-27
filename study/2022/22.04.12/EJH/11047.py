N, K = map(int, input().split())

coins = []
for i in range(N):
    coin = int(input())
    coins.append(coin)

count = 0
while coins:
    coin = coins.pop()
    c = K // coin
    count += K // coin
    K -= coin * c

    if K == 0:
        break

print(count)
