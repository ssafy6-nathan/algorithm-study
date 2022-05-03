N = int(input())

count = 0

for _ in range(N):
    word = input()

    check_set = set()
    check = True
    last_w = word[0]
    check_set.add(last_w)

    for w in word:
        if w != last_w:
            if w in check_set:
                check = False
                break
            last_w = w
            check_set.add(last_w)

    if check:
        count += 1

print(count)
