count = [0, 0, 0]


def check_paper(arr, start_r, start_c, size):
    check = False
    num = arr[start_r][start_c]
    for r in range(size):
        for c in range(size):
            if arr[start_r + r][start_c + c] != num:
                check = True
                break

    if check:
        n_size = size // 3
        for i in range(3):
            for j in range(3):
                check_paper(arr, start_r + n_size * i, start_c + n_size * j, n_size)
    else:
        count[num + 1] += 1





N = int(input())

arr = [list(map(int, input().split()))for _ in range(N)]

check_paper(arr, 0, 0, N)

for a in count:
    print(a)