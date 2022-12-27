N, K = map(int, input().split())
arr = list(map(int, input().split()))

num_check = [0 for _ in range(100001)]

l_point = 0
r_point = 0
max_count = 0
count = 0
while l_point <= r_point < len(arr):
    num_check[arr[r_point]] += 1
    count += 1

    while num_check[arr[r_point]] > K:
        num_check[arr[l_point]] -= 1
        count -= 1
        l_point += 1

    r_point += 1

    if max_count < count:
        max_count = count


print(max_count)
