N = int(input())
arr = list(input().strip())

alpha_check = [0 for _ in range(27)]

l_point = 0
r_point = 0
max_count = 0
count = 0


def count_alpha():
    check = 0
    for i in range(len(alpha_check)):
        if alpha_check[i] > 0:
            check += 1

    if check <= N:
        return False
    else:
        return True


while l_point <= r_point < len(arr):
    alpha_check[ord(arr[r_point]) - ord('a')] += 1
    count += 1

    while count_alpha():
        alpha_check[ord(arr[l_point]) - ord('a')] -= 1
        count -= 1
        l_point += 1

    r_point += 1

    if max_count < count:
        max_count = count



print(max_count)