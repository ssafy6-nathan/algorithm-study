# 행렬 테두리

def solution(rows, columns, queries):
    answer = []

    arr = [[0 for _ in range(columns+1)] for _ in range(rows+1)]

    t = 1
    for r in range(1,rows+1):
        for c in range(1, columns + 1):
            arr[r][c] = t
            t += 1

    for r1, c1, r2, c2 in queries:
        tmp = arr[r1][c1]
        min_num = tmp

        #  →
        # ↑ ↓
        #  ←

        for i in range(r1, r2): # 위로 ↑
            num = arr[i+1][c1]
            arr[i][c1] = num
            min_num = min(min_num, num)

        for i in range(c1, c2):  # 왼쪽으로 ←
            num = arr[r2][i + 1]
            arr[r2][i] = num
            min_num = min(min_num, num)

        for i in range(r2, r1, -1):  # 아래로 ↓
            num = arr[i - 1][c2]
            arr[i][c2] = num
            min_num = min(min_num, num)

        for i in range(c2, c1, -1):  # 오른쪽으로 →
            num = arr[r1][i - 1]
            arr[r1][i] = num
            min_num = min(min_num, num)
        arr[r1][c1+1] = tmp
        answer.append(min_num)


    return answer



print(solution(6,6,	[[2,2,5,4],[3,3,6,6],[5,1,6,3]]))
print(solution(3,3,	[[1,1,2,2],[1,2,2,3],[2,1,3,2],[2,2,3,3]]))
print(solution(100,97,		[[1,1,100,97]]))