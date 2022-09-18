def solution(board, skill):
    answer = 0
    N = len(board)
    M = len(board[0])
    imos = [[0 for _ in range(M + 1)] for _ in range(N + 1)]
    for s in skill:
        t, r1, c1, r2, c2, degree = s
        if t == 1:
            degree *= -1

        imos[r1][c1] += degree
        imos[r1][c2 + 1] -= degree
        imos[r2 + 1][c1] -= degree
        imos[r2 + 1][c2 + 1] += degree

    for r in range(N + 1):
        for c in range(1, M + 1):
            imos[r][c] += imos[r][c - 1]

    for c in range(M + 1):
        for r in range(1, N + 1):
            imos[r][c] += imos[r - 1][c]

    for r in range(N):
        for c in range(M):
            if board[r][c] + imos[r][c] > 0:
                answer += 1

    return answer


print(solution([[5, 5, 5, 5, 5], [5, 5, 5, 5, 5], [5, 5, 5, 5, 5], [5, 5, 5, 5, 5]],
               [[1, 0, 0, 3, 4, 4], [1, 2, 0, 2, 3, 2], [2, 1, 0, 3, 1, 2], [1, 0, 1, 3, 3, 1]]))
print(solution([[1, 2, 3], [4, 5, 6], [7, 8, 9]], [[1, 1, 1, 2, 2, 4], [1, 0, 0, 1, 1, 2], [2, 2, 0, 2, 0, 100]]))
