def solution(s):
    min_count = 100000
    for i in range(1, len(s)//2 + 2):
        count = len(s)
        one = 1
        for j in range(0, len(s), i):
            if s[j: j + i] != s[j + i: j + i + i]:
                if one != 1:
                    count += len(str(one))
                one = 1
            else:
                count -= i
                one += 1
        min_count = min(min_count, count)
    answer = min_count
    return answer


print(solution("aabbaccc"))
print(solution("ababcdcdababcdcd"))
print(solution("abcabcdede"))
print(solution("abcabcabcabcdededededede"))
print(solution("xababcdcdababcdcd"))