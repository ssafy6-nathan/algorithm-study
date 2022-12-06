def solution(a, b, g, s, w, t):
    answer = -1

    start = 0
    end = (a+b) * max(t) * 2
    answer = end

    while start <= end:
        mid = (start + end) // 2
        gold, silver, total = 0, 0, 0

        for i in range(len(t)):
            c = (mid - t[i]) // (2 * t[i]) + 1  # 해당 트럭이 옮기는 회수
            can_take = w[i] * c                 # 최대 옮길수 있는 무게
            gold += min(g[i], can_take)             # 금 옮기는 량
            silver += min(s[i], can_take)           # 은 옮기는 량
            total += min(g[i]+s[i], can_take)       # 합계 옮기는 량

        if gold >= a and silver >= b and total >= a + b:
            answer = min(answer, mid)
            end = mid - 1

        else:
            start = mid + 1

    return answer


print(solution(10, 10, [100], [100], [7], [10]))
print(solution(90, 500, [70, 70, 0], [0, 0, 500], [100, 100, 2], [4, 8, 1]))
