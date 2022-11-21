while True:
    key = int(input())
    if key == 0:
        break
    words = input()
    max_cnt = 0
    cnt = 0
    button = {}

    start = 0
    end = 0

    while end < len(words):
        if words[end] in button:
            button[words[end]] += 1
        else:
            button[words[end]] = 1
        cnt += 1
        end += 1

        if len(button) > key:
            while len(button) > key:
                if button[words[start]] == 1:
                    del button[words[start]]
                else:
                    button[words[start]] -= 1
                cnt -= 1
                start += 1

        if max_cnt < cnt:
            max_cnt = cnt

    print(max_cnt)