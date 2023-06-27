let fs = require("fs");
let input = fs.readFileSync("/dev/stdin").toString().split("\n");

let [a, b] = input[0].split(" ").map(Number); // a, b 입력
let flag = false; // a -> b 변환 가능 여부
let result = 1;

while (a <= b) {
  if (a == b) {
    flag = true;
    break;
  }
  if (b % 2 == 0)
    b = parseInt(b / 2); // 2로 나누어 떨어지는 경우 (b가 짝수라면)
  else if (b % 10 == 1)
    b = parseInt(b / 10); // 그렇지 않고, 일의 자릿수가 1인 경우
  else break; // 위 경우 모두 해당되지 않는 경우
  result++;
}

if (flag) console.log(result);
else console.log(-1);
