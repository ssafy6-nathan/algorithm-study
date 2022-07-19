def solution(lottos, win_nums):
    answer = []

    cnt = 0
    zero_cnt = 0
    for lotto in lottos:
        if lotto in win_nums:
            cnt += 1

        if lotto == 0:
            zero_cnt += 1

    mx_cnt = cnt + zero_cnt
    mn_cnt = cnt

    def rank(N):
        if N == 6:
            return 1
        elif N == 5:
            return 2
        elif N == 4:
            return 3
        elif N == 3:
            return 4
        elif N == 2:
            return 5
        else:
            return 6

    answer.append(rank(mx_cnt))
    answer.append(rank(mn_cnt))

    return answer

print(solution(	[44, 1, 0, 0, 31, 25], [31, 10, 45, 1, 6, 19]))