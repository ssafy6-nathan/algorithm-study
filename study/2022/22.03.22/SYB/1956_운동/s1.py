import sys
sys.stdin = open('input.txt')

'''
플로이드 워셜 알고리즘
- 모든 정점에 관한 최단 경로를 구하는 알고리즘

i → j 로 가는 경로
1) i → j. 바로 가거나
2) i → k → j. k를 거쳐서 가거나
둘 중에 최소값으로 계속 갱신한다.

[알고리즘 구현]
1. 3중 반복문 수행
2. 거쳐가는 정점 k를 첫번째 반복문으로 한다.
3. 3중 반복문이 종료되고 나서, arr[i][i] 값이 i → i 로 돌아오는 경로 중 최소값 
'''


V, E = map(int, input().split())

INF = sys.maxsize
arr = [[INF] * V for _ in range(V)]

for _ in range(E):
    a, b, c = map(int, input().split())
    arr[a-1][b-1] = c

for k in range(V):
    for i in range(V):
        for j in range(V):
            arr[i][j] = min(arr[i][j], arr[i][k] + arr[k][j])

ans = INF
for i in range(V):
    ans = min(ans, arr[i][i])

if ans == INF:
    print(-1)
else:
    print(ans)
