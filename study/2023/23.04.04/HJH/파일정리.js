let fs = require("fs");
let input = fs.readFileSync("/dev/stdin").toString().split("\n");

let n = Number(input[0]);

let fileMap = new Map();
for (let i = 1; i <= n; i++) {
  let [fileName, extension] = input[i].split(".");
  let values = fileMap.get(extension);
  if (!values) {
    fileMap.set(extension, 1);
  } else fileMap.set(extension, values + 1);
}

let sortedMap = new Map([...fileMap].sort());

let answer = "";
for (let [key, value] of sortedMap) {
  answer += `${key} ${value}\n`;
}

console.log(answer);
