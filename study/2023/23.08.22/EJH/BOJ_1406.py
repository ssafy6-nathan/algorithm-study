from collections import deque
left = deque(input())
right = deque()

M = int(input())

for _ in range(M):
    command = list(input().split())
    if command[0] == 'L' and left:
        right.appendleft(left.pop())
    elif command[0] == 'D' and right:
        left.append(right.popleft())
    elif command[0] == 'B' and left:
        left.pop()
    elif command[0] == 'P':
        left.append(command[1])

answer = left + right
print(''.join(answer))