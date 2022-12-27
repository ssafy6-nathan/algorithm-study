def solution(fees, records):
    answer = []
    cars_log = {}
    cars_pay = {}
    for record in records:
        time, car, IO = record.split()
        hour, minute = map(int, time.split(":"))
        if car not in cars_log:
            cars_log[car] = []
            cars_pay[car] = 0
        if IO == "IN":
            cars_log[car].append([hour * 60 + minute, 0])
        elif IO == "OUT":
            cars_log[car][-1][1] = hour * 60 + minute

    for car in cars_log:
        time = 0
        for s, e in cars_log[car]:
            if e == 0:
                e = 24 * 60 - 1
            time += e - s
        cars_pay[car] += fees[1]
        if time <= fees[0]:
            continue
        time -= fees[0]

        overtime = time // fees[2]
        if time % fees[2] > 0:
            overtime += 1
        cars_pay[car] += overtime * fees[3]

    for car in sorted(cars_pay):
        answer.append(cars_pay[car])

    return answer


print(solution([180, 5000, 10, 600],
               ["05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN",
                "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"]))
print(solution([120, 0, 60, 591],
               ["16:00 3961 IN", "16:00 0202 IN", "18:00 3961 OUT", "18:00 0202 OUT", "23:58 3961 IN"]))
print(solution([1, 461, 1, 10], ["00:00 1234 IN"]))
