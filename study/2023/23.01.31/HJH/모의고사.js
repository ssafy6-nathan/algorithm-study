function solution(answers) {
    let answer = [];
    const one = [1, 2, 3, 4, 5];
    const two = [2, 1, 2, 3, 2, 4, 2, 5];
    const three = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5];
    let score = [0,0,0];
    let alen = answers.length;
    for(let i = 0; i < alen; i++){
        if (answers[i] === one[i % one.length]) score[0]++;
        if (answers[i] === two[i % two.length]) score[1]++;
        if (answers[i] === three[i % three.length]) score[2]++;
    }
    const max = Math.max(...score);
    let slen = score.length;
    for (let i = 0; i < slen; i++) {
        if (max === score[i]) answer.push(i + 1);
    }
    return answer;
}
