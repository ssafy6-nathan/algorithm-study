import sys
sys.stdin = open('input.txt')

words = sys.stdin.readline().rstrip()
bomb = list(sys.stdin.readline().rstrip())

stack = []

for word in words:
    stack.append(word)
    if stack[-1] == bomb[-1] and stack[-len(bomb):] == bomb:
        for _ in range(len(bomb)):
            stack.pop()

if stack:
    print("".join(stack))
else:
    print("FRULA")