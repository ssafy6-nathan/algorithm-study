N = int(input())

answer = []
visited = [False for i in range(10)]


def decrease(num, level):
    answer.append(num)

    peek = num // level
    for i in range(peek + 1, 10):
        decrease(i * level * 10 + num, level * 10)


for i in range(10):
    decrease(i, 1)

answer.sort()

if N < 1023:
    print(answer[N])
else:
    print(-1)

