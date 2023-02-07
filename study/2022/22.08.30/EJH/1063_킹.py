king, stone, N = input().split()
N = int(N)

k = list(map(int, [ord(king[0]) - ord('A') + 1, king[1]]))
s = list(map(int, [ord(stone[0]) - ord('A') + 1, stone[1]]))

move = {
    'R': [1, 0],
    'L': [-1, 0],
    'B': [0, -1],
    'T': [0, 1],
    'RT': [1, 1],
    'LT': [-1, 1],
    'RB': [1, -1],
    'LB': [-1, -1]
}

for _ in range(int(N)):
    m = input()
    nx = k[0] + move[m][0]
    ny = k[1] + move[m][1]
    if 0 < nx <= 8 and 0 < ny <= 8:
        if nx == s[0] and ny == s[1]:
            sx = s[0] + move[m][0]
            sy = s[1] + move[m][1]
            if 0 < sx <= 8 and 0 < sy <= 8:
                k = [nx, ny]
                s = [sx, sy]
        else:
            k = [nx, ny]


print(chr(k[0] + ord('A') - 1) + str(k[1]))
print(chr(s[0] + ord('A') - 1) + str(s[1]))