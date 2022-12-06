
while True:
    sentence = input()

    if sentence == ".":
        break

    check = True
    stack = []
    for s in sentence:
        if s == '[' or s == '(':
            stack.append(s)

        elif s == ']' or s == ')':
            if len(stack) > 0:
                temp_s = stack.pop()
                if s == ']':
                    if temp_s != '[':
                        check = False
                        break
                elif s == ')':
                    if temp_s != '(':
                        check = False
                        break
            else:
                check = False
                break
    if len(stack) > 0:
        check = False
        
    if check:
        print("yes")
    else:
        print("no")