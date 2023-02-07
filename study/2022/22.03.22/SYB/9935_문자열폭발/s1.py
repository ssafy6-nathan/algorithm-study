import sys
sys.stdin = open('input.txt')

words = sys.stdin.readline().rstrip()
bomb = sys.stdin.readline().rstrip()

while True:
    if bomb in words:
        words = words.replace(bomb, '')
    else:
        break

if words:
    print(words)
else:
    print("FRULA")
