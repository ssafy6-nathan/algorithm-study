import sys
input = sys.stdin.readline

english = ['a', 'b', 'c', 'd', 'e',
           'f', 'g', 'h', 'i', 'j',
           'k', 'l', 'm', 'n', 'o',
           'p', 'q', 'r', 's', 't',
           'u', 'v', 'w', 'x', 'y',
           'z'
           ]
word = input()
N = int(input())
l = len(word)
arr = {}

for e in english:
    arr[e] = [0 for _ in range(l + 1)]

arr[word[0]][1] += 1

for i in range(1, l - 1):
    arr[word[i]][i + 1] = 1
    for w in english:
        arr[w][i + 1] += arr[w][i]


for i in range(N):
    c, start, end = input().split()
    start = int(start)
    end = int(end)
    if start > 0:
        print(arr[c][end + 1] - arr[c][start])
    else:
        print(arr[c][end + 1])

