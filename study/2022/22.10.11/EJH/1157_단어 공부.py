word = input()
word = word.upper()

count = [0 for i in range(26)]

a = ord("A")

for w in word:
    count[ord(w) - a] += 1

max_c = max(count)

result = ""

for i in range(26):
    if count[i] == max_c:
        result += chr(i + a)

if len(result) > 1:
    print("?")
else:
    print(result)