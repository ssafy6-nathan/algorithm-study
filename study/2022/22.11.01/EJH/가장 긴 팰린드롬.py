def solution(s):
    answer = 0
    end = len(s)
    for i in range(end, 0, -1):
        flag = False
        for j in range(0, end - (i - 1)):
            if s[j:j + i] == s[j:j + i][::-1]:
                flag = True
                break
        if flag:
            answer = i
            break

    return answer


print(solution("abcdcba"))
print(solution("abacde"))