## 문제
[프로그래머스 - 5월 식품들의 총매출 조회하기](https://school.programmers.co.kr/learn/courses/30/lessons/131117) <br>
: JOIN

## 문제 풀이
- 기본 join 문제

### 오답 개선
- 처음엔 `having TOTAL_SALES` 으로 having 절을 썼었는데, 해당 문제에선 <br>
  이미 조건을 만족하는 데이터를 WHERE 절과 GROUP BY를 통해 처리하고 있기 때문에 필요 없음 <br>
  -> HAVING 절은 일반적으로 GROUP BY로 집계한 결과를 추가로 필터링할 때 사용

## 코드
```sql
select a.PRODUCT_ID, a.PRODUCT_NAME, sum(b.AMOUNT * a.PRICE) as TOTAL_SALES
from FOOD_PRODUCT a
join FOOD_ORDER b on a.PRODUCT_ID = b.PRODUCT_ID
where PRODUCE_DATE like '2022-05%'
group by PRODUCT_ID
order by TOTAL_SALES desc, PRODUCT_ID
```
