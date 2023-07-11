const [doc, word] = require("fs")
    .readFileSync("/dev/stdin")
    .toString()
    .trim()
    .split("\n");

const result = doc.split(word);
console.log(result.length - 1);
