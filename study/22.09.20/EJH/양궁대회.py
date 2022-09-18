from collections import deque


def bfs(n, apache_a):
    res = [-1]
    q = deque()
    q.append((0, 0, [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]))
    score_diff = 0

    while q:
        score_num, arrow_count, lion_a = q.popleft()

        if arrow_count == n:
            apache, lion = 0, 0
            for i in range(11):
                if apache_a[i] == 0 and lion_a[i] == 0:
                    continue
                if lion_a[i] > apache_a[i]:
                    lion += 10 - i
                else:
                    apache += 10 - i

            if lion > apache and score_diff <= lion - apache:
                score_diff = lion - apache
                res = lion_a.copy()

        elif arrow_count > n:
            continue

        elif score_num == 10:
            new_arrow = lion_a.copy()
            new_arrow[10] = n - arrow_count
            q.append((-1, n, new_arrow))

        else:
            new_arrow = lion_a.copy()
            new_arrow[score_num] = apache_a[score_num] + 1
            q.append((score_num + 1, arrow_count + new_arrow[score_num], new_arrow))   # score_num 과녁에 아파치 보다 1발 많이 쏘기
            new_arrow2 = lion_a.copy()
            q.append((score_num + 1, arrow_count, new_arrow2))  # score_num 과녁에 안 쏘기

    return res


def solution(n, info):

    answer = bfs(n, info)

    return answer


print(solution(5, [2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0]))
print(solution(1, [1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]))
print(solution(9, [0, 0, 1, 2, 0, 1, 1, 1, 1, 1, 1]))
print(solution(10, [0, 0, 0, 0, 0, 0, 0, 0, 3, 4, 3]))
