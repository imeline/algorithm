## 문제
[프로그래머스 - 조건에 맞는 도서 리스트 출력하기](https://school.programmers.co.kr/learn/courses/30/lessons/144854) 

## 문제 풀이
- `join A on B` 을 통해 두 테이블을 합치기
- date 형식 지정 안하면 `2020-01-10 00:00:00` 형식으로 나오므로, <br>
`DATE_FORMAT(B.PUBLISHED_DATE, '%Y-%m-%d') AS PUBLISHED_DATE` 으로 지정해주기 <br>
-> `AS` 지정 안해주면 `DATE_FORMAT(B.PUBLISHED_DATE, '%Y-%m-%d')` 로 필드 이름 출력 됨

## 코드
```sql
SELECT B.BOOK_ID, A.AUTHOR_NAME, DATE_FORMAT(B.PUBLISHED_DATE, '%Y-%m-%d') AS PUBLISHED_DATE
FROM BOOK B
JOIN AUTHOR A ON B.AUTHOR_ID = A.AUTHOR_ID
WHERE B.CATEGORY = '경제'
ORDER BY B.PUBLISHED_DATE;
```
