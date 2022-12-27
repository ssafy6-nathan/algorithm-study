dir = ((-1, 0), (0, 1), (1, 0), (0, -1))


def game(ar, ac, br, bc, cnt, board):
    if board[ar][ac] == 0:
        return 1, cnt
    winner = []
    loser = []
    flag = False
    for dr, dc in dir:
        nr, nc = ar + dr, ac + dc
        if 0 <= nr < len(board) and 0 <= nc < len(board[0]) and board[nr][nc] == 1:
            flag = True
            temp = [row[:] for row in board]
            temp[ar][ac] = 0
            is_win, turn = game(br, bc, nr, nc, cnt + 1, temp)
            if is_win:
                winner.append(turn)
            else:
                loser.append(turn)
    if flag:
        if winner:
            return 0, min(winner)
        else:
            return 1, max(loser)
    else:
        return 1, cnt


def solution(board, aloc, bloc):
    ar, ac, br, bc = aloc[0], aloc[1], bloc[0], bloc[1]
    answer = game(ar, ac, br, bc, 0, board)[1]
    return answer


print(solution([[1, 1, 1], [1, 1, 1], [1, 1, 1]], [1, 0], [1, 2]))
print(solution([[1, 1, 1], [1, 0, 1], [1, 1, 1]], [1, 0], [1, 2]))
print(solution([[1, 1, 1, 1, 1]], [0, 0], [0, 4]))
print(solution([[1]], [0, 0], [0, 0]))
