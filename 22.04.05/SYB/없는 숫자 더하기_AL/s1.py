def solution(numbers):
    answer = 0

    numbers_list = [i for i in range(1, 10)]
    answer += sum(numbers_list)

    for number in numbers:
        answer -= number

    return answer

print(solution([1, 2, 3, 4, 6, 7, 8, 0]))
print(solution([5, 8, 4, 0, 6, 7, 9]))