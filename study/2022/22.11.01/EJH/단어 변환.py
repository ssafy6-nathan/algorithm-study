import heapq


def check_can_change(w1, w2):
    count = 0
    for i in range(len(w1)):
        if w1[i] != w2[i]:
            count += 1
        if count > 1:
            break
    if count == 1:
        return True
    else:
        return False


def change_word(begin, target, words):
    arr = []
    count_words = {}
    for i in range(len(words)):
        count_words[words[i]] = 0
    result = 0
    heapq.heappush(arr, (0, begin))

    while arr:
        time, word = heapq.heappop(arr)
        if word == target:
            result = time
            break

        for w in words:
            if count_words[w] == 0 and check_can_change(word, w):
                heapq.heappush(arr, (time + 1, w))
                count_words[w] = time + 1

    return result


def solution(begin, target, words):
    answer = change_word(begin, target, words)
    return answer

print(solution("hit",	"cog",	["hot", "dot", "dog", "lot", "log", "cog"]))
print(solution("hit",	"cog",	["hot", "dot", "dog", "lot", "log"]))