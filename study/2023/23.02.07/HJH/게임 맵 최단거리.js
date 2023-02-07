function solution(maps) {
    const dx = [0,0,1,-1];
    const dy = [1,-1,0,0];
    const queue = [[0,0,1]];

    while ( queue.length ) {
        const cur = queue.shift();
        if ( cur[0] === maps.length - 1 && cur[1] === maps[0].length - 1) 
            return cur[2]
        for(let i=0;i<4;i+=1){
            const yy = cur[0] + dy[i]
            const xx = cur[1] + dx[i]
            if(xx >= 0 && yy >= 0 && xx < maps[0].length && yy < maps.length && maps[yy][xx] === 1 ) {
                maps[yy][xx] = 0;
                queue.push([yy, xx, cur[2] + 1]);    
            }
        }
    }
    return -1;
}
