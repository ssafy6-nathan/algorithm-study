arr = [False, False] + [True] * 10000

for i in range(2, 100):         # 에라토스테네스의 체
    if arr[i]:
        for j in range(i * 2, 10001, i):
            arr[j] = False

n = int(input())


for _ in range(n):
    num = int(input())  # num 은 짝수
    half = num // 2     # 반으로 나눈뒤 1씩 증감

    for i in range(half):
        if arr[half - i] and arr[half + i]:     # 증감 된 두 수가 모두 소수이면 출력
            print(half - i, half + i)
            break
