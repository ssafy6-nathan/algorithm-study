// let fs = require('fs');
// let input = fs.readFileSync('/dev/stdin').toString().split('\n');

const input = ['5', '55 185', '58 183', '88 186', '60 175', '46 155'];
// let N = Number(input.shift());
let N = Number(input[0]);
let RANK = input.map((v, i) => ({
  weight: v.split(' ')[0],
  height: v.split(' ')[1],
  rank: 1, // 1로 초기화
}));
console.log(N);
console.log(RANK);
console.log(RANK.length);
for (let i = 1; i <= N; i++) {
  for (let j = 1; j <= N; j++) {
    if (i != j && RANK[i].weight < RANK[j].weight && RANK[i].height < RANK[j].height) {
      //if ((i != j) && (RANK[i].weight < RANK[j].weight && RANK[i].height < RANK[j].height)) {
      RANK[i].rank++;
    }
  }
}

console.log(RANK.map((i) => i.rank).join(' '));
