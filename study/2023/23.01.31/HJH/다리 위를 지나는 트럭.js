function solution(bridge_length, weight, truck_weights) {
    let answer = 0;
    let bridge = [];
    let sum =0;
    let q = new Array(bridge_length);
    q.fill(0);
    while(q.length>0){
        answer++;
        sum -= q.shift();
        if(truck_weights.length > 0){
            if(sum + truck_weights[0] <= weight){
                let truck = truck_weights.shift();
                sum += truck;
                q.push(truck);
            } else q.push(0);
        }
    }
    return answer;
}
