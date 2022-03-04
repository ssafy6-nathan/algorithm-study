before_DNA = input()
after_DNA = input()

b_DNA_len = len(before_DNA)
a_DNA_len = len(after_DNA)

min_len = min(a_DNA_len, b_DNA_len)
start_virus = 0
end_virus = 0

for i in range(min_len):
    if before_DNA[i] == after_DNA[i]:
        start_virus += 1
    else:
        break

for j in range(min_len):
    if before_DNA[b_DNA_len - j-1] == after_DNA[a_DNA_len - j-1]:
        end_virus += 1
    else:
        break

end_virus = a_DNA_len - end_virus
ans = max(end_virus-start_virus, 0)

print(max(ans, a_DNA_len - b_DNA_len))