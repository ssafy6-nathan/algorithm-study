import sys
sys.stdin = open('input.txt')

### 시간 초과


def palilndrome_check(checking_words):
    if checking_words == checking_words[::-1]:
        return 0

    for i in range(len(checking_words)):
        copy_words = checking_words[:]
        del copy_words[i]
        if copy_words == copy_words[::-1]:
            return 1

    return 2

T = int(input())
for tc in range(1, T+1):
    words = list(sys.stdin.readline().rstrip())
    ans = palilndrome_check(words)
    print(ans)