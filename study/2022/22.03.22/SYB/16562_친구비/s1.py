import sys
sys.stdin = open('input.txt')

# 재귀 limit 변경
sys.setrecursionlimit(10 ** 9)


# 입력받은 값 x와 친구인 친구들 목록을 반환하는 함수
def check(x, friends_list):
    global arr, visited, ans

    visited[x] = 1

    for i in arr[x]:
        if not visited[i]:
            friends_list.append(i)
            check(i, friends_list)

    return friends_list


N, M, k = map(int, input().split())

costs = [0] + list(map(int, input().split()))

# 인접 리스트
arr = [[] for _ in range(N+1)]
for _ in range(M):
    v, w = map(int, input().split())
    # 양방향
    arr[v].append(w)
    arr[w].append(v)

visited = [0] * (N+1)
ans = []

# 1부터 N까지 순회
for i in range(1, N+1):
    if not visited[i]:
        # check 함수를 통해 친구들 목록 생성
        friends = check(i, [i])

        min_cost = 9876543210

        # 친구들을 한명씩 확인하면서 친구비가 가장 작은 값을 찾아서 ans에 추가
        for friend in friends:
            if min_cost > costs[friend]:
                min_cost = costs[friend]
        ans.append(min_cost)

# ans의 총합이 k보다 작으면 ans 총합 출력
if sum(ans) <= k:
    print(sum(ans))

# 총합이 k보다 크면 Oh ho 출력
else:
    print("Oh no")
