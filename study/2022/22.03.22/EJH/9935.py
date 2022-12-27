string = list(input().rstrip())
bomb = list(input().rstrip())

stack = []

for s in string:
    stack.append(s)
    if len(stack) >= len(bomb):
        if stack[-len(bomb):] == bomb:
            for _ in range(len(bomb)):
                stack.pop()
if len(stack) == 0:
    print("FRULA")
else:
    print("".join(stack))