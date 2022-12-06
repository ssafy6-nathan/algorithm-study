def lotto_rank(num):
    x = 6
    if num == 6:
        x = 1
    elif num == 5:
        x = 2
    elif num == 4:
        x = 3
    elif num == 3:
        x = 4
    elif num == 2:
        x = 5
    return x
def solution(lottos, win_nums):
    answer = []
    win_nums = set(win_nums)

    collect_num = 0
    unknown_num = 0
    for l in lottos:
        if l == 0:
            unknown_num += 1
        elif l in win_nums:
            collect_num += 1

    answer.append(lotto_rank(unknown_num + collect_num))
    answer.append(lotto_rank(collect_num))

    return answer


print(solution([44, 1, 0, 0, 31, 25], [31, 10, 45, 1, 6, 19]))
print(solution([0, 0, 0, 0, 0, 0], [38, 19, 20, 40, 15, 25]))
print(solution([45, 4, 35, 20, 3, 9], [20, 9, 3, 45, 4, 35]))