n, m = map(int, input().split())

leaf = 0

if m == 2:
    leaf = 1

for i in range(1, n):
    if leaf < m:
        print(0, i)
        leaf += 1
    else:
        print(i-1, i)