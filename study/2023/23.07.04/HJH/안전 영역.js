const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

const N = Number(input[0]);
const arr = input.slice(1).map((el) => el.split(" ").map(Number));

let limit = 0;

arr.forEach((row) =>
    row.forEach((el) => {
        limit = Math.max(el, limit);
    })
);

const dx = [0, 0, -1, 1];
const dy = [-1, 1, 0, 0];

function solution(height) {
    const visited = Array.from(new Array(N + 1), () =>
        new Array(N + 1).fill(false)
    );
    let cnt = 0;

    function dfs(x, y, h) {
        if (visited[x][y]) return;
        visited[x][y] = true;
        visitedCoords[[x, y]] = true;
        if (arr[x][y] > h) cnt += 1;

        for (let i = 0; i < 4; i++) {
            const nx = dx[i] + x;
            const ny = dy[i] + y;

            if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            if (arr[nx][ny] > h && !visited[nx][ny]) dfs(nx, ny, h);
        }

        return cnt;
    }

    const visitedCoords = {};
    const safeZone = [];

    for (let i = 0; i < N; i++) {
        for (let j = 0; j < N; j++) {
            if (!visitedCoords[[i, j]] && arr[i][j] > height) {
                safeZone.push(dfs(i, j, height));
                cnt = 0;
            }
        }
    }

    return safeZone.length;
}

let answer = 0;

for (let i = 0; i < limit; i++) {
    answer = Math.max(answer, solution(i));
}

console.log(answer);
