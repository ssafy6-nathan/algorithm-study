N = int(input())
M = list(map(int,input().split()))
add, sub, mul, div = (map(int,input().split()))


max_c = -float('inf')
min_c = float('inf')

def col(num, add, sub, mul, div, i):
    global max_c
    global min_c
    if i==N:
        max_c = max(max_c,num)
        min_c = min(min_c,num)
        return
    else:
        if add:
            col(num+M[i], add-1, sub, mul, div, i+1)
        if sub:
            col(num-M[i], add, sub-1, mul, div, i+1)
        if mul:
            col(num*M[i], add, sub, mul-1, div, i+1)
        if div:
            col(int(num/M[i]), add, sub, mul, div-1, i+1)

col(M[0], add, sub, mul, div, 1)

print(max_c)
print(min_c)
