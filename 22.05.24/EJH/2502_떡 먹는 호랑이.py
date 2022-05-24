D, K = map(int, input().split())

ac = 1
bc = 1

for _ in range(4, D + 1):
    ac, bc = bc, ac + bc

print(ac, bc)
a = 1
b = 1

while True:
    tmp = K - ac * a

    if tmp % bc == 0:
        b = tmp // bc
        break

    a += 1

print(a)
print(b)