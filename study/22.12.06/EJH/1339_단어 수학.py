N = int(input())

A = ord("A")
alpha = [0 for _ in range(26)]

words = []

for _ in range(N):
    w = input()

    count = 1
    for i in range(len(w)):
        alpha[A - ord(w[-(i+1)])] += count
        count *= 10

num = 0

for n in range(9, 0, -1):
    max_index = alpha.index(max(alpha))
    num += alpha[max_index] * n
    alpha[max_index] = 0

print(num)