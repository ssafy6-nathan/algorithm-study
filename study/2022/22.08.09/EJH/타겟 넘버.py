count = 0


def dfs(n, result, numbers, target):
    global count
    if n == len(numbers):
        if result == target:
            count += 1
        return
    dfs(n + 1, result + numbers[n], numbers, target)
    dfs(n + 1, result - numbers[n], numbers, target)


def solution(numbers, target):
    answer = 0
    global count
    count = 0
    dfs(0, 0, numbers, target)
    answer = count
    return answer



print(solution([1, 1, 1, 1, 1], 3))
print(solution([4, 1, 2, 1], 4))