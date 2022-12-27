function solution(queue1, queue2) {
  // let answer = -2;
  let answer = 0;
  let cnt = (cnt1 = cnt2 = qsum1 = qsum2 = 0);
  for (q in (queue1, queue2)) {
    qsum1 += queue1[q];
    qsum2 += queue2[q];
  }
  if (qsum1 === qsum2) return answer;

  let sum = (qsum1 + qsum2) / 2;

  // Q2 -> Q1
  for (q in queue2) {
    while (true) {
      let s = queue2.shift();
      let p = queue1.push(s);
      qsum1 += s;
      qsum2 -= s;
      cnt1++;
      if (qsum1 === sum) break;
    }
  }

  // Q1 -> Q2
  for (q in queue1) {
    while (true) {
      let s = queue1.shift();
      let p = queue2.push(s);
      qsum2 += s;
      qsum1 -= s;
      cnt2++;
      if (qsum1 === sum) break;
    }
  }

  answer = Math.min(cnt1, cnt2);

  return answer;
}
