N = int(input())
arr = [-1000000000]+list(map(int, input().split()))+[1000000000]

index = 0
upper = 0

answer = 0

for i in range(2, len(arr)):
    if arr[i] < arr[i-1]:
        upper += 1
        index = i


if upper == 0:
    answer = N
elif upper == 1:
    if arr[index - 1] <= arr[index + 1]:
        answer += 1
    if arr[index - 2] <= arr[index]:
        answer += 1

print(answer)