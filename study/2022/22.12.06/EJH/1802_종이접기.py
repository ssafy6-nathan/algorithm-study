def check_can(p):
    if len(p) == 1:
        return True
    mid = len(p) // 2
    p1 = p[0: mid]
    p2 = p[mid + 1:]

    for i in range(mid):
        if p1[i] == p2[-(i + 1)]:
            return False

    return check_can(p1) and check_can(p2)


T = int(input())

for _ in range(T):
    paper = list(input().strip())

    if check_can(paper):
        print("YES")
    else:
        print("NO")