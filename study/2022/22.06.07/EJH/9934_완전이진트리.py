K = int(input())
arr = list(map(int, input().split()))
tree = [[] for _ in range(K)]


def make_tree(arr, level):
    mid = len(arr) // 2
    tree[level].append(arr[mid])

    if len(arr) <= 1:
        return

    make_tree(arr[:mid], level + 1)
    make_tree(arr[mid + 1:], level + 1)


make_tree(arr, 0)
for i in range(K):
    print(*tree[i])