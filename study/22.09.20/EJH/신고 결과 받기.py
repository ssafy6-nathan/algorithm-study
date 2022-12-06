def solution(id_list, report, k):
    answer = []
    user = {}
    singo = {}

    for id in id_list:
        user[id] = set()
        singo[id] = set()

    for r in report:
        u, s = r.split()
        singo[s].add(u)
        user[u].add(s)

    for u in user:
        count = 0
        for s in user[u]:
            if len(singo[s]) >= k:
                count += 1
        answer.append(count)

    return answer


print(solution(["muzi", "frodo", "apeach", "neo"],	["muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"],	2))
print(solution(["con", "ryan"],	["ryan con", "ryan con", "ryan con", "ryan con"],	3))