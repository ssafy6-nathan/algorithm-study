import heapq


def solution(genres, plays):
    answer = []
    sing = {}
    genres_sing = {}
    total_genre = {}
    for g in range(len(genres)):
        if genres[g] not in genres_sing:
            genres_sing[genres[g]] = []
        heapq.heappush(genres_sing[genres[g]], [-plays[g], g])

        if genres[g] not in total_genre:
            total_genre[genres[g]] = 0
        total_genre[genres[g]] += plays[g]

    total_genre = sorted(total_genre.items(), key=lambda x: -x[1])
    print(total_genre)
    print(genres_sing)
    for g, count in total_genre:
        for i in range(2):
            if len(genres_sing[g]) > 0:
                answer.append(heapq.heappop(genres_sing[g])[1])

    return answer


print(solution(["classic", "pop", "classic", "classic", "pop"], [500, 600, 150, 800, 2500]))
