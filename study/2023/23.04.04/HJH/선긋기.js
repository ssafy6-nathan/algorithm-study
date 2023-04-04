let fs = require("fs");
let input = fs.readFileSync("/dev/stdin").toString().split("\n");

let n = Number(input[0]);
let lines = new Array(n);
for (let i = 0; i < n; i++) {
  let [a, b] = input[i + 1].split(" ").map(Number);
  lines[i] = [a, b];
}

// x좌표를 기준으로 오름차순 정렬
lines.sort((a, b) => a[0] - b[0]);

let answer = 0;

let left = lines[0][0];
let right = lines[0][1];

for (let i = 1; i < n; i++) {
  if (lines[i][0] <= right && lines[i][1] > right) {
    right = lines[i][1];
  } else if (lines[i][0] > right) {
    answer += right - left;
    right = lines[i][1];
    left = lines[i][0];
  }
}

answer += right - left;

console.log(answer);
