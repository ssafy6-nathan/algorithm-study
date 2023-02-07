function solution(id_list, report, k) {
    //key: 신고 당한 유저의 id
    //value: 신고를 한 유저의 id 배열
  const answer = new Array(id_list.length).fill(0); // 처리 결과 메일을 받은 횟수(최종 결과)
    const report_list = {};
    id_list.map((user)=>{//key는 user의 id 값을, value는 신고한 사람을 담기위한 빈 배열을 추가한다.
        report_list[user] = [] //key로 userid를 value로 빈 배열을 가지는 객체
    });

  report.map((user)=>{
        const [user_id, report_id] = user.split(' ')// 띄어쓰기로 구분된 문자열 split
        if(!report_list[report_id].includes(user_id)){// 배열 포함 여부 확인하고 신고자의 이름 배열에 추가
            report_list[report_id].push(user_id)
        }
    })

    for(const key in report_list){
        if(report_list[key].length >= k){ //이용정지 유저
            report_list[key].map((user)=>{
                answer[id_list.indexOf(user)] += 1
            })
        }
    }
    return answer;
    //각 유저별 처리 결과 메일을 받은 횟수를 담은 배열
}
