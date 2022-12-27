N = int(input())


def moo(end, count, N):
    mid = (end - count) // 2

    if N <= mid:
        return moo(mid, count - 1, N)
    elif N > mid + count:
        return moo(mid, count - 1, N - mid - count)
    else:
        if N - mid - 1 == 0:
            return "m"
        else:
            return "o"


end, count = 3, 3   # m o o

while N > end:
    count += 1
    end = end*2 + count

print(moo(end, count, N))

