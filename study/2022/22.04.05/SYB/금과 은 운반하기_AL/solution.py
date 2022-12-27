def solution(a, b, g, s, w, t):
    answer = float('inf')
    start = 0
    end = 10 ** 9 * 10 ** 5 * 4 - 10 ** 5

    while start <= end:
        mid = (start + end) // 2
        gM, gm, sM, sm = 0, 0, 0, 0

        for i in range(len(t)):
            c = (mid - t[i]) // (2 * t[i]) + 1
            gM += g[i] if g[i] - c * w[i] <= 0 else c * w[i]
            sm += min(s[i], abs(g[i] - c * w[i])) if g[i] - c * w[i] <= 0 else 0
            sM += s[i] if s[i] - c * w[i] <= 0 else c * w[i]
            gm += min(g[i], abs(s[i] - c * w[i])) if s[i] - c * w[i] <= 0 else 0

        if gM >= a and sM >= b and gM + sm >= a + b:
            end = mid - 1
            answer = min(answer, mid)
        else:
            start = mid + 1

    return answer


print(solution(10, 10, [100], [100], [7], [10]))  # 50