const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const [A, B, C] = fs
  .readFileSync(filePath)
  .toString()
  .trim()
  .split(" ")
  .map(BigInt);

function pow(a, b) {
  if (b == 0) {
    return BigInt(1);
  } else {
    const temp = pow(a, BigInt(parseInt(b / BigInt(2))));
    if (b % BigInt(2) == 0) {
      return (temp * temp) % C;
    } else {
      return (temp * temp * a) % C;
    }
  }
}

console.log(parseInt(pow(A, B)));
