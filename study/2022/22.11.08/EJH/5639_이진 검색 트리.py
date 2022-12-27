import sys
sys.setrecursionlimit(10 ** 6)
input = sys.stdin.readline

preorder = []

while True:
    try:
        preorder.append(int(input()))
    except:
        break


def postorder(start, end):
    if start >= end:
        return

    if preorder[end - 1] <= preorder[start]:
        postorder(start + 1, end)
        print(preorder[start])
        return

    mid = 0
    for i in range(start + 1, end):
        if preorder[start] < preorder[i]:
            mid = i
            break

    postorder(start + 1, mid)
    postorder(mid, end)
    print(preorder[start])


postorder(0, len(preorder))