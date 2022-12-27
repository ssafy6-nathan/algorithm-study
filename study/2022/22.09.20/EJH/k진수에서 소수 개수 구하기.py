import math


def change_num(n, k):
    num = 0
    s = 1
    P = []
    while n > 0:
        num += (n % k) * s
        if n % k == 0:
            if num != 0:
                P.append(num)
            s = 1
            num = 0
        else:
            s *= 10
        n //= k

    if num != 0:
        P.append(num)

    return P


def check_prime(n):
    if n == 1:
        return False
    for i in range(2, int(math.sqrt(n)) + 1):
        if n % i == 0:
            return False
    return True


def solution(n, k):
    answer = 0

    P = change_num(n, k)

    for p in P:
        if check_prime(p):
            answer += 1
    return answer


print(solution(437674,	3))
print(solution(110011,	10))