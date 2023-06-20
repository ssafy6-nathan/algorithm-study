let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().split('\n');
let N = Number(input.shift());
let RANK = input.map((v, i) => ({
  weight: v.split(' ')[0],
  height: v.split(' ')[1],
  rank: 1, // 1로 초기화
}));

for (let i = 0; i < N; i++) {
  for (let j = 0; j < N; j++) {
    if (i != j && RANK[i].weight < RANK[j].weight && RANK[i].height < RANK[j].height) {
      RANK[i].rank++;
    }
  }
}

console.log(RANK.map((i) => i.rank).join(' '));
