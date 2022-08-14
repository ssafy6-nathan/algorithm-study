import sys
input = sys.stdin.readline

min_total = float('inf')
min_sol = []

N = int(input())
arr = sorted(list(map(int, input().split())))

for i in range(N-2):
    start = i+1
    end = N-1
    while start < end:
        total = abs(arr[i] + arr[start] + arr[end])
        if total < min_total:
            min_sol = [arr[i], arr[start], arr[end]]
            min_total = total
        if total < 0:
            start += 1
        elif total > 0:
            end -= 1
        else:
            print(*min_sol)
            sys.exit()

print(*min_sol)






