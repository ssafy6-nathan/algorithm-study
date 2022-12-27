import sys
sys.stdin = open('input.txt')

origin_dna = input()
infected_dna = input()

checked = [0] * min(len(origin_dna), len(infected_dna))

for i in range(len(checked)):
    if origin_dna[i] == infected_dna[i]:
        checked[i] = 1
    else:
        break

for i in range(len(checked)):
    if origin_dna[len(origin_dna) - i - 1] == infected_dna[len(infected_dna) - i -1]:
        checked[len(checked) - i - 1] = 1
    else:
        break

used_word_cnt = 0
for i in range(len(checked)):
    if checked[i]:
        used_word_cnt += 1

print(max(len(infected_dna) - used_word_cnt, 0))