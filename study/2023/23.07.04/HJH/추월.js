let fs = require("fs");
let input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

const N = Number(input[0]);
const tunnelIn = input.slice(1, N + 1);
const tunnelOut = input.slice(N + 1, N * 2 + 1);

function solution(tunnelIn, tunnelOut) {
    const enterCar = new Map();
    tunnelIn.forEach((car, i) => {
        enterCar.set(car, i);
    });

    const exitCar = new Map();
    tunnelOut.forEach((car, i) => {
        exitCar.set(car, enterCar.get(car));
    });

    let cnt = 0;
    for (const [exitCarName, exitIndex] of exitCar) {
        const [firstValue] = enterCar.values();

        if (exitIndex > firstValue) {
            cnt++;
        }
        enterCar.delete(exitCarName);
    }
    return cnt;
}

console.log(solution(tunnelIn, tunnelOut));
