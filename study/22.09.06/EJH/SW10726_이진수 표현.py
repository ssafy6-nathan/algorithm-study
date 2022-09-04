T = int(input())

for test_case in range(1, T + 1):
    N, M = map(int, input().split())

    ON = True

    for _ in range(N):
        if M % 2 == 0:
            ON = False
            break
        M //= 2
    if ON:
        s = "ON"
    else:
        s = "OFF"
    print("#" + str(test_case) + " " + s)