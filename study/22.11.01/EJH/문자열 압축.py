def solution(s):
    min_str = 100000
    for i in range(1, len(s)//2 + 2):
        res = ""
        count = 1
        temp = s[:i]
        for j in range(i, len(s) + i, i):
            if temp == s[j: j + i]:
                count += 1
            else:
                if count == 1:
                    res += temp
                else:
                    res += str(count) + temp
                temp = s[j: j + i]
                count = 1

        min_str = min(min_str, len(res))
    answer = min_str
    return answer


print(solution("aabbaccc"))
print(solution("ababcdcdababcdcd"))
print(solution("abcabcdede"))
print(solution("abcabcabcabcdededededede"))
print(solution("xababcdcdababcdcd"))