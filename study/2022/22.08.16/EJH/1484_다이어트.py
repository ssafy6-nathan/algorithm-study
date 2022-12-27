G = int(input()) # G는 100,000보다 작거나 같은 자연수이다.

arr = [i for i in range(0, 50001)]

past = 1
now = 1
answer = []
while past < 50001 and now < 50001:
    g = (arr[now] + arr[past]) * (arr[now] - arr[past])

    if g == G:
        answer.append(now)
    if g < G:
        now += 1
        continue
    past += 1

if not answer:
    print(-1)
else:
    for a in answer:
        print(a)
