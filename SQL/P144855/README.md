## 문제
[프로그래머스 - 카테고리 별 도서 판매량 집계하기](https://school.programmers.co.kr/learn/courses/30/lessons/144855) <br>
: GROUP BY

## 문제 풀이
- 단순 join 후 그룹화 문제
- 1월만 해당하는 데이터 뽑을 땐, `like '2022-01-%'`
  - 만약 1월~3월 해당하는 데이터 뽑을 땐,
    `BETWEEN '2022-01-01' AND '2022-03-31'` <br>
    혹은 `date >= '2022-01-01' AND date <= '2022-03-31'`

## 답안 코드
```sql
select a.CATEGORY, sum(b.SALES) as TOTAL_SALES
from BOOK A
join BOOK_SALES B
on a.BOOK_ID = b.BOOK_ID
where b.SALES_DATE like '2022-01-%'
group by a.CATEGORY
order by a.CATEGORY
```
