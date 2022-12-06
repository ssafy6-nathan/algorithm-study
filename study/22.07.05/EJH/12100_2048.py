from copy import deepcopy


def move_left(arr):
    N = len(arr)
    for i in range(N):
        while 0 in arr[i]:                  # 한쪽 으로 밀기 (0 제거)
            arr[i].remove(0)
        new_arr = []
        sum_check = False
        while arr[i]:
            n = arr[i].pop(0)
            if len(new_arr) > 0 and new_arr[-1] == n and not sum_check:             # 같은 숫자 합치기 + 이미 합쳐진 것 체크
                new_arr[-1] = n * 2
                sum_check = True
            else:
                new_arr.append(n)
                sum_check = False
        arr[i] = new_arr
        arr[i] = arr[i] + [0] * (N - len(arr[i]))                                       # 0 채우기

    return arr


def move_right(arr):
    N = len(arr)
    for i in range(N):
        while 0 in arr[i]:
            arr[i].remove(0)
        new_arr = []
        sum_check = False
        while arr[i]:
            n = arr[i].pop()                                                                # left 랑 좌우 반대
            if len(new_arr) > 0 and new_arr[-1] == n and not sum_check:
                new_arr[-1] = n * 2
                sum_check = True
            else:
                new_arr.append(n)
                sum_check = False
        new_arr.reverse()                                                                    # left 랑 좌우 반대라 뒤집어 줌
        arr[i] = new_arr
        arr[i] = [0] * (N - len(arr[i])) + arr[i]                                            # 0 채우기 left 반대로 채우기

    return arr


def move_up(arr):
    arr = list(map(list, zip(*arr)))                                                        # 배열 뒤집에서 나머지는 left와 같음
    N = len(arr)
    for i in range(N):
        while 0 in arr[i]:
            arr[i].remove(0)
        new_arr = []
        sum_check = False
        while arr[i]:
            n = arr[i].pop(0)
            if len(new_arr) > 0 and new_arr[-1] == n and not sum_check:
                    new_arr[-1] = n * 2
                    sum_check = True
            else:
                new_arr.append(n)
                sum_check = False
        arr[i] = new_arr
        arr[i] = arr[i] + [0] * (N - len(arr[i]))

    arr = list(map(list, zip(*arr)))
    return arr


def move_down(arr):                                                         # 배열 뒤집에서 나머지는 right와 같음
    arr = list(map(list, zip(*arr)))
    N = len(arr)
    for i in range(N):
        while 0 in arr[i]:
            arr[i].remove(0)
        new_arr = []
        sum_check = False
        while arr[i]:
            n = arr[i].pop()
            if len(new_arr) > 0 and new_arr[-1] == n and not sum_check:
                new_arr[-1] = n * 2
                sum_check = True
            else:
                new_arr.append(n)
                sum_check = False
        new_arr.reverse()
        arr[i] = new_arr
        arr[i] = [0] * (N - len(arr[i])) + arr[i]

    arr = list(map(list, zip(*arr)))
    return arr


def move(arr, n):
    new_arr = []

    if n == 0:
        new_arr = move_up(arr)
    elif n == 1:
        new_arr = move_down(arr)
    elif n == 2:
        new_arr = move_left(arr)
    elif n == 3:
        new_arr = move_right(arr)

    return new_arr


def dfs(count, arr, N, p):
    global result
    if count == 5:

        for i in range(N):
            result = max(result, max(arr[i]))

        return

    for i in range(4):
        new_arr = move(deepcopy(arr), i)
        dfs(count + 1, new_arr, N, p + [i])


N = int(input())

arr = [list(map(int, input().split())) for _ in range(N)]

result = 0
dfs(0, arr, N, [])
print(result)



