N = int(input())

arr = [list(map(int, input().split())) for _ in range(N)]
build_time = [0 for _ in range(N)]

count = 0

while count < N:
    for i in range(N):
        if build_time[i] != 0:
            continue

        check = True
        time = 0
        for j in arr[i][1:-1]:
            if build_time[j - 1] == 0:
                check = False
                break
            else:
                if time < build_time[j - 1]:
                    time = build_time[j - 1]
        if check:
            count += 1
            build_time[i] = time + arr[i][0]

for b in build_time:
    print(b)

