def check_id(user, banned):
    if len(user) == len(banned):
        for i in range(len(banned)):
            if banned[i] != '*':
                if user[i] != banned[i]:
                    return False
        return True
    return False


groups = []


def dfs(user_id, banned_id, cnt, visited, group):
    global groups
    if cnt == len(banned_id):
        if group not in groups:
            groups.append(group.copy())

        return

    for i in range(len(user_id)):
        if not visited[i] and check_id(user_id[i], banned_id[cnt]):
            visited[i] = True
            group.add(user_id[i])
            dfs(user_id, banned_id, cnt + 1, visited, group)
            group.remove(user_id[i])
            visited[i] = False


def solution(user_id, banned_id):
    global groups
    groups = []
    visited = [False for _ in range(len(user_id))]
    dfs(user_id, banned_id, 0, visited, set())
    answer = len(groups)
    return answer


print(solution(["frodo", "fradi", "crodo", "abc123", "frodoc"],	["fr*d*", "abc1**"]))
print(solution(["frodo", "fradi", "crodo", "abc123", "frodoc"],	["*rodo", "*rodo", "******"]))
print(solution(["frodo", "fradi", "crodo", "abc123", "frodoc"],	["fr*d*", "*rodo", "******", "******"]))