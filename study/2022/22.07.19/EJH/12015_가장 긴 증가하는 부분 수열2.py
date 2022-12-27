import sys

input = sys.stdin.readline

N = int(input())
arr = [0] + list(map(int, input().split()))
dp = [0] * (N + 1)
dp_l = 0


def binary_search(arr, num , l):

    start = 1
    end = l - 1
    while start <= end:
        mid = (start + end) // 2
        if arr[mid - 1] < num <= arr[mid]:
            return mid
        elif arr[mid] < num:
            start = mid + 1
        else:
            end = mid - 1

    return -1


for i in range(1, N + 1):

    index = binary_search(dp, arr[i], dp_l + 1)
    if index == -1:
        dp[dp_l + 1] = arr[i]
        dp_l += 1
    else:
        dp[index] = arr[i]

print(dp_l)