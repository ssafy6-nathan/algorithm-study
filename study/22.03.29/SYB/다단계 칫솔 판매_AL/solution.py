def solution(enroll, referral, seller, amount):
    answer = [0] * len(enroll)

    def find_ref(seller_name, cost):
        ref_i = enroll.index(seller_name)
        ref = referral[ref_i]

        if ref == "-":
            answer[ref_i] += round(cost * 0.9)
            return

        if cost * 0.1 < 1:
            answer[ref_i] += cost
        else:
            answer[ref_i] += round(cost * 0.9)
            find_ref(ref, round(cost * 0.1))

        return

    for i in range(len(seller)):
        benefit = amount[i] * 100
        find_ref(seller[i], benefit)

    return answer


print(solution(["john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"], ["-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"], ["young", "john", "tod", "emily", "mary"], [12, 4, 2, 5, 10]))
print(solution(["john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"], ["-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"], ["sam", "emily", "jaimie", "edward"], [2, 3, 5, 4]))