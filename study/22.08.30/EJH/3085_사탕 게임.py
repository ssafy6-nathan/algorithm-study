N = int(input())

arr = [list(input().strip()) for _ in range(N)]


def candy_change():
    max_count = 0

    for r in range(N):
        for c in range(N):
            if r < N - 1:
                arr[r][c], arr[r + 1][c] = arr[r + 1][c], arr[r][c]

                count = eat_candy(arr)

                if max_count < count:
                    max_count = count

                arr[r][c], arr[r + 1][c] = arr[r + 1][c], arr[r][c]

            if c < N - 1:
                arr[r][c], arr[r][c + 1] = arr[r][c + 1], arr[r][c]

                count = eat_candy(arr)

                if max_count < count:
                    max_count = count

                arr[r][c], arr[r][c + 1] = arr[r][c + 1], arr[r][c]
    return max_count


def eat_candy(candy_arr):
    max_count = 0

    for r in range(N):
        count = 1
        for c in range(1, N):
            if candy_arr[r][c] == candy_arr[r][c - 1]:
                count += 1
            else:
                count = 1

            if max_count < count:
                max_count = count

    for c in range(N):
        count = 1
        for r in range(1, N):
            if candy_arr[r][c] == candy_arr[r - 1][c]:
                count += 1
            else:
                count = 1

            if max_count < count:
                max_count = count

    return max_count


print(candy_change())