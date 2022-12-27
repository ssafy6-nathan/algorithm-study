N, M = map(int, input().split())

arr = list(map(int, input().split()))

arr_m = []
arr_p = []

for a in arr:
    if a < 0:
        arr_m.append(-a)
    else:
        arr_p.append(a)

arr_m.sort()
arr_p.sort()

move = 0

if len(arr_m) > 0:
    book_index = len(arr_m) % M
    if book_index == 0:
        book_index = M
    while True:
        move += (arr_m[book_index - 1])

        if book_index >= len(arr_m):
            break
        else:
            move += (arr_m[book_index - 1])
            book_index += M

if len(arr_p) > 0:
    book_index = len(arr_p) % M
    if book_index == 0:
        book_index = M
    while True:
        move += (arr_p[book_index - 1])
        if book_index >= len(arr_p):
            break
        else:
            move += (arr_p[book_index - 1])
            book_index += M
if len(arr_m) > 0 and len(arr_p) > 0:
    move += min(arr_m[-1], arr_p[-1])
print(move)