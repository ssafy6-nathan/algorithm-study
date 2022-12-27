function solution(n, paths, gates, summits) {
  const graph = Array.from(Array(n + 1), () => new Array());
  const intensity = Array(n + 1).fill(Infinity);
  const queue = new Array();

  let isSummit = new Array(n).fill(false);
  let isGate = new Array(n).fill(false);

  for (g of gates) {
    isGate[g] = true;
    intensity[g] = 0;
    queue.push([g, 0]);
  }

  for (s of summits) {
    isSummit[s] = true;
  }

  paths.forEach((path) => {
    const [start, end, weight] = path;
    if (!isSummit[start] && !isGate[end]) graph[start].push([end, weight]);
    if (!isSummit[end] && !isGate[start]) graph[end].push([start, weight]);
  });

  while (queue.length !== 0) {
    const [current] = queue.shift();
    for (const [next, nextWeight] of graph[current])
      if (intensity[next] > Math.max(intensity[current], nextWeight)) {
        intensity[next] = Math.max(intensity[current], nextWeight);
        queue.push([next, nextWeight]);
      }
  }

  return intensity
    .map((value, index) => [index, value])
    .filter(([num]) => isSummit[num])
    .sort(([a1, b1], [a2, b2]) => (b1 === b2 ? a1 - a2 : b1 - b2))[0];
}
