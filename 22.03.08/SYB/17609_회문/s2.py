import sys
sys.stdin = open('input.txt')


def pseudo_check(check_words, start, end):
    while start < end:
        if check_words[start] == check_words[end]:
            start += 1
            end -= 1
        else:
            return False
    return True


def palindrome_check(check_words, start, end):
    while start < end:
        if check_words[start] == check_words[end]:
            start += 1
            end -= 1
        else:
            pseudo1 = pseudo_check(check_words, start+1, end)
            pseudo2 = pseudo_check(check_words, start, end-1)

            if pseudo1 or pseudo2:
                return 1
            else:
                return 2
    return 0


T = int(input())
for _ in range(T):
    words = sys.stdin.readline().rstrip()
    ans = palindrome_check(words, 0, len(words)-1)
    print(ans)