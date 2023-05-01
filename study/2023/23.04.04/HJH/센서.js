let fs = require("fs");
let input = fs.readFileSync("/dev/stdin").toString().split("\n");

let n = Number(input[0]);
let k = Number(input[1]);
const sensors = input[2]
  .split(" ")
  .map(Number)
  .sort((a, b) => a - b);

const solution = (n, k, sensors) => {
  if (k >= n) return 0;
  const distance = [];
  let answer = 0;
  for (let i = 0; i < n - 1; i++) distance.push(sensors[i + 1] - sensors[i]);
  distance.sort((a, b) => b - a);
  for (let i = k - 1; i < n - 1; i++) answer += distance[i];
  return answer;
};

console.log(solution(n, k, sensors));
