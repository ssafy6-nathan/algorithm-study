N = int(input())
arr = list(map(int, input().split()))

arr.sort()
start = 0
end = N-1
min_total = float('inf')
min_s = 0
min_e = 0
while start < end:
    m = arr[start] + arr[end]

    if abs(m) < abs(min_total):
        min_total = m
        min_s = arr[start]
        min_e = arr[end]
    if m == 0:
        break

    elif m < 0:
        start += 1
    else:
        end -= 1

print(min_s, min_e)