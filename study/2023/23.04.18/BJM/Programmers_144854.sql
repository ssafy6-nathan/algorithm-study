/**
 * 프로그래머스 144854번
 * 조건에 맞는 도서와 저자 리스트 출력하기
 * (https://school.programmers.co.kr/learn/courses/30/lessons/144854)
 **/

SELECT B.BOOK_ID AS BOOK_ID, A.AUTHOR_NAME AS AUTHOR_NAME, DATE_FORMAT(B.PUBLISHED_DATE, '%Y-%m-%d') AS PUBLISHED_DATE
FROM BOOK AS B, AUTHOR AS A
WHERE B.CATEGORY = '경제' AND B.AUTHOR_ID = A.AUTHOR_ID
ORDER BY B.PUBLISHED_DATE ASC;