import sys
sys.stdin = open('input.txt')

N, M = map(int, sys.stdin.readline().split())

person_dict = {}

for _ in range(N):
    person = sys.stdin.readline().rstrip()
    person_dict[person] = 1

ans = []

for _ in range(M):
    person = sys.stdin.readline().rstrip()

    if person in person_dict.keys():
        ans.append(person)

ans.sort()

print(len(ans))
print('\n'.join(ans))