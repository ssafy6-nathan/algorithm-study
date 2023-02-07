const x = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : '/input.txt', 'utf-8');

console.log((+x).toString(2).match(/1/g).length);
