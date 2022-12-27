N, M = map(int, input().split())
arr = list(map(int, input().split()))

start = 0
end = 0
max_ham = 0

ham = 0
while end < N:
    ham += arr[end]
    end += 1

    if ham > M:
        while ham > M:
            ham -= arr[start]
            start += 1

    elif ham == M:
        max_ham = M
        break

    if max_ham < ham:
        max_ham = ham

print(max_ham)