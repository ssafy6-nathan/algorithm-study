N = int(input())
M = int(input())

arr = list(map(int, input().split()))

arr.sort()
start = 0
end = N-1

count = 0
while end > start:
    if arr[start] + arr[end] == M:
        start += 1
        end -= 1
        count += 1
    elif arr[start] + arr[end] < M:
        start += 1
    else:
        end -= 1

print(count)