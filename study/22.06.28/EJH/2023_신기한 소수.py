def is_prime(num):
    if num < 2:
        return False
    for i in range(2, int(num**0.5)+1):
        if num % i == 0:
            return False
    return True


N = int(input())


def dfs(num, count):
    if count == N:
        print(num)
        return

    for i in range(10):
        next_num = num * 10 + i

        if is_prime(next_num):
            dfs(next_num, count + 1)


dfs(2, 1)
dfs(3, 1)
dfs(5, 1)
dfs(7, 1)


