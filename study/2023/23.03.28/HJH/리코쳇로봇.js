function solution(board) {
  let answer = 0;
  board = board.map((items) => items.split(""));

  const q = [];
  const n = board.length;
  const m = board[0].length;
  const dx = [-1, 1, 0, 0];
  const dy = [0, 0, -1, 1];

  board.forEach((items, i) => {
    items.forEach((item, j) => {
      if (item === "R") q.push([i, j]);
    });
  });

  board[q[0][0]][q[0][1]] = "O";

  while (q.length) {
    const size = q.length;

    for (let i = 0; i < size; i++) {
      const [x, y] = q.shift();

      for (let j = 0; j < 4; j++) {
        let nx = x + dx[j];
        let ny = y + dy[j];

        while (
          nx >= 0 &&
          nx < n &&
          ny >= 0 &&
          ny < m &&
          board[nx][ny] !== "D"
        ) {
          nx += dx[j];
          ny += dy[j];
        }

        nx -= dx[j];
        ny -= dy[j];

        if (board[nx][ny] === "G") return answer + 1;

        if (board[nx][ny] !== "O") {
          board[nx][ny] = "O";
          q.push([nx, ny]);
        }
      }
    }
    answer++;
  }

  return -1;
}
