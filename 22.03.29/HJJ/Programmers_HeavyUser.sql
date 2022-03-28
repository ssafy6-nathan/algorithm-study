/**
 * 문제이름 : 헤비 유저가 소유한 장소
 * 링크 : https://programmers.co.kr/learn/courses/30/lessons/77486
 */

SELECT *
FROM PLACES
WHERE HOST_ID IN (
    SELECT HOST_ID
    FROM PLACES
    GROUP BY HOST_ID
    HAVING COUNT(HOST_ID) >= 2
)
ORDER BY ID;


