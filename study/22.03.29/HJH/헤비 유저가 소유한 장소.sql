-- 헤비 유저가 소유한 장소
-- 코드를 입력하세요
 
# SELECT HOST_ID FROM PLACES
# GROUP BY HOST_ID HAVING COUNT(*)>1
# 760849, 30900122

SELECT * FROM PLACES
WHERE HOST_ID IN 
(SELECT HOST_ID FROM PLACES
GROUP BY HOST_ID HAVING COUNT(*)>1)
