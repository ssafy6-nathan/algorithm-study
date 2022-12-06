import sys
sys.stdin = open('input.txt')


def check(a):
    if len(a) == 1:
        return 1

    checked = dict()
    for i in range(len(a)):
        if a[i] in checked and i - checked[a[i]] != 1:
            return 0
        else:
            checked[a[i]] = i
    return 1


N = int(input())

cnt = 0
for _ in range(N):
    words = input()
    cnt += check(words)

print(cnt)
