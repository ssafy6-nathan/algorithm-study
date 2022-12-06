def solution(rows, columns, queries):
    answer = []

    mat = [[0] * columns for _ in range(rows)]

    for i in range(rows):
        for j in range(columns):
            mat[i][j] = ((i) * columns) + (j+1)

    def rotate(x_1, y_1, x_2, y_2, start_val):
        min_val = 9876543210
        for a in range(y_1+1, y_2+1):
            min_val = min(min_val, start_val)
            mat[x_1][a], start_val = start_val, mat[x_1][a]

        for b in range(x_1+1, x_2+1):
            min_val = min(min_val, start_val)
            mat[b][y_2], start_val = start_val, mat[b][y_2]

        for c in range(y_2-1, y_1-1, -1):
            min_val = min(min_val, start_val)
            mat[x_2][c], start_val = start_val, mat[x_2][c]

        for d in range(x_2-1, x_1-1, -1):
            min_val = min(min_val, start_val)
            mat[d][y_1], start_val = start_val, mat[d][y_1]

        return min_val

    for query in queries:
        x1, y1, x2, y2 = query
        before = mat[x1-1][y1-1]
        answer.append(rotate(x1-1, y1-1, x2-1, y2-1, before))

    return answer

print(solution(6, 6, [[2, 2, 5, 4], [3, 3, 6, 6], [5, 1, 6, 3]]))