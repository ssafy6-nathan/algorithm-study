def solution(numbers):
    answer = 45

    for number in numbers:
        answer -= number
    return answer


print(solution([1,2,3,4,6,7,8,0]))
print(solution([5,8,4,0,6,7,9]))