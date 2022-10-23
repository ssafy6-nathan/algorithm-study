def solution(s):
    answer = True
    num = set()
    for i in range(0, 10):
        num.add(str(i))
    if len(s) == 4 or len(s) == 6:
        for word in s:
            if word not in num:
                answer = False
                break
    else:
        answer = False
    return answer

print(solution("a234"))
print(solution("1234"))