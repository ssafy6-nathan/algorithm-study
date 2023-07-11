let fs = require("fs");
let input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

const N = Number(input[0]);
let arr = [];
for (let i = 1; i <= N; i++) {
    arr.push(input[i]);
}
arr.sort((a, b) => b.length - a.length);
const answer = [];
for (const str of arr) {
    if (answer.every((e) => e.indexOf(str) !== 0)) answer.push(str);
}
console.log(answer.length);
