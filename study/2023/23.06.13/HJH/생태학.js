let fs = require("fs");
let input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

const trees = {};
const len = input.length;
input.forEach((t) => {
  if (!trees[t]) trees[t] = 0;
  trees[t]++;
});

Object.keys(trees)
  .sort()
  .forEach((tree) => console.log(tree, ((trees[tree] / len) * 100).toFixed(4)));
