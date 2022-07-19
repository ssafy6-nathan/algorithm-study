word = input()

count = 0
for i in range(len(word)):
    if word[i:] == word[i:][::-1]:
        count = i
        break

print(len(word) + count)