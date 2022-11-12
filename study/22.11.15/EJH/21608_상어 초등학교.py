dr = [1, 0, -1, 0]
dc = [0, 1, 0, -1]

N = int(input())

arr = [[0 for _ in range(N)] for _ in range(N)]
students = {}

for i in range(N * N):
    s = list(map(int, input().split()))
    students[s[0]] = set(s[1:])

    c_blank = -1
    c_friend = -1
    c_r = -1
    c_c = -1

    for r in range(N):
        for c in range(N):
            if arr[r][c] != 0:
                continue
            blank = 0
            friend = 0
            for d in range(4):
                nr = r + dr[d]
                nc = c + dc[d]

                if nr < 0 or nc < 0 or nr >= N or nc >= N:
                    continue

                if arr[nr][nc] == 0:
                    blank += 1
                elif arr[nr][nc] in students[s[0]]:
                    friend += 1

            if (c_friend < friend) or (c_friend == friend and c_blank < blank):
                c_friend = friend
                c_blank = blank
                c_r = r
                c_c = c

    arr[c_r][c_c] = s[0]

result = 0
for r in range(N):
    for c in range(N):
        satisfy = 0
        for d in range(4):
            nr = r + dr[d]
            nc = c + dc[d]

            if nr < 0 or nc < 0 or nr >= N or nc >= N:
                continue

            if arr[nr][nc] in students[arr[r][c]]:
                satisfy += 1

        if satisfy == 4:
            satisfy = 1000
        elif satisfy == 3:
            satisfy = 100
        elif satisfy == 2:
            satisfy = 10
        elif satisfy == 1:
            satisfy = 1
        else:
            satisfy = 0
        result += satisfy

print(result)
