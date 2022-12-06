import sys
sys.setrecursionlimit(10**9)


def sell(parents, revenue, seller, money):
    if seller == "-":
        return
    up_money = money // 10
    revenue[seller] += money - up_money
    if up_money > 0:
        sell(parents, revenue, parents[seller], up_money)


def solution(enroll, referral, seller, amount):
    answer = []
    revenue = {}
    parents = {}

    for i in range(len(enroll)):
        revenue[enroll[i]] = 0
        parents[enroll[i]] = referral[i]

    for i in range(len(seller)):
        sell(parents, revenue, seller[i], amount[i] * 100)
    for r in revenue:
        answer.append(revenue[r])
    return answer




print(solution(["john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"],
               ["-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"],
               ["young", "john", "tod", "emily", "mary"],
               [12, 4, 2, 5, 10]))
