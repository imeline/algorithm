## 문제
[프로그래머스 - 저자 별 카테고리 별 매출액 집계하기](https://school.programmers.co.kr/learn/courses/30/lessons/144856) <br>
: GROUP BY

## 알게된 점
- `b.AUTHOR_ID` 에서 `b.` 같은 별칭을 `group by` 나 `order by`에선 안 붙여도 되지만 `select` 문에서는 꼭 붙여야한다.
  - `select` 에서는 충돌을 방지하기 위해 꼭 붙이도록 설정되있음
  - `group by` 나 `order by` 절에서는 없으면 `select` 문을 참고해서 별칭을 가져옴
- 한 테이블에 `join` 절 두개 가능
- `year(SALES_DATE) = 2022 and month(SALES_DATE) = 1` 로도 날짜 필터 가능
- `sum(SALES) * PRICE` 처럼 집계 함수와 일반 컬럼의 곱은 불가능하니, `sum(SALES * PRICE)` 로 사용 (분배법칙으로 최종 값은 똑같음)

### SQL 쿼리 실행 순서
1. FROM
2. JOIN
3. WHERE
4. GROUP BY
5. HAVING
6. SELECT
7. ORDER BY
8. LIMIT


## 코드
```sql
select b.AUTHOR_ID, AUTHOR_NAME, CATEGORY, sum(SALES * PRICE) as TOTAL_SALES
from BOOK b
join AUTHOR a on a.AUTHOR_ID = b.AUTHOR_ID
join BOOK_SALES bs on bs.BOOK_ID = b.BOOK_ID
where SALES_DATE like '2022-01-%'
group by AUTHOR_ID, CATEGORY
order by AUTHOR_ID, CATEGORY desc
```
