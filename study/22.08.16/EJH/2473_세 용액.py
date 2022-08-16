import sys
input = sys.stdin.readline

min_total = float('inf')
min_sol = []

N = int(input())
arr = sorted(list(map(int, input().split())))

for i in range(N-2):
    refer = arr[i]
    l_p = i+1
    r_p = N-1
    while l_p < r_p:
        total = refer + arr[l_p] + arr[r_p]
        if abs(total) < abs(min_total):
            min_sol = [refer, arr[l_p], arr[r_p]]
            min_total = total
        if total < 0:
            l_p += 1
        elif total > 0:
            r_p -= 1
        else:
            print(*min_sol)
            sys.exit()

print(*min_sol)






