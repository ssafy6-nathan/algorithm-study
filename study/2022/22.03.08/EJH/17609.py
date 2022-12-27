def check_palindrome(str, start, end, pseudo):
    if pseudo == 2:
        return 2
    while start < end:
        if str[start] != str[end]:
            if pseudo == 0:
                a = check_palindrome(str, start + 1, end, pseudo + 1)
                b = check_palindrome(str, start, end - 1, pseudo + 1)
                return min(a, b)
            else:
                return 2
        else:
            start += 1
            end -= 1
    return pseudo


T = int(input())

for t in range(T):
    str = input()

    print(check_palindrome(str, 0, len(str) - 1, 0))
