function solution(today, terms, privacies) {
  let deleteTerm = [];
  let termInfo = {};
  let [year, month, date] = today.split('.').map((v) => Number(v));
  let todayCount = year * 12 * 28 + month * 28 + date;

  terms.forEach((term) => {
    let [type, period] = term.split(' ');
    termInfo[type] = Number(period);
  });

  privacies.forEach((privacy, i) => {
    let [day, type] = privacy.split(' ');
    day = day.split('.').map(Number);
    let dateCount = day[0] * 12 * 28 + day[1] * 28 + day[2] + termInfo[type] * 28;
    if (dateCount <= todayCount) deleteTerm.push(i + 1);
  });

  return deleteTerm;
}
