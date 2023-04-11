function solution(plans) {
  const queue = plans.map((p) => {
    let [name, time, takenTime] = p;
    let [hour, minute] = time.split(":").map(Number);
    let convertedTime = hour * 60 + minute;
    return [name, convertedTime, Number(takenTime)];
  });
  // convertedTime 기준으로 오름차순 정렬
  queue.sort((a, b) => a[1] - b[1]);

  let answer = [];
  return answer;
}
