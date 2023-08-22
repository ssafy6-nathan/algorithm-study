M, N = map(int, input().split())
board = []
count = []

for _ in range(M):
    board.append(input())

for a in range(M - 7):
    for b in range(N - 7):
        W = 0
        B = 0
        for i in range(a, a+8):
            for j in range(b, b+8):
                if (i+j) % 2 == 0:
                    if board[i][j] != 'W':
                        W += 1
                    if board[i][j] != 'B':
                        B += 1
                else:
                    if board[i][j] != 'B':
                        W += 1
                    if board[i][j] != 'W':
                        B += 1
        count.append(min(W, B))
print(min(count))