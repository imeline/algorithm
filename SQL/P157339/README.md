## ✔️ 문제
[프로그래머스 - 특정 기간동안 대여 가능한 자동차들의 대여비용 구하기](https://school.programmers.co.kr/learn/courses/30/lessons/157339) <br>
: JOIN

## ✔️ 알게 된것
- `select` 절에서 정의한 `as` 는 `where` 절에서 쓰지 못한다. <br>
  다만, `having` 과 `order by` 절에서는 사용 가능
- `select` 에 사용되지 않는 필드를 가진 테이블은 굳이 `join` 할 필요가 없다. <br>
  -> where 절에서 서브쿼리로 조건을 걸면 된다.

## ✔️ 트러블 슈팅
** 11월에 렌트된 기록이 있는 차들을 찾는 조건문 작성 시
  
### 처음
`month(START_DATE) = 11 or month(END_DATE) = 11` 을 했으나, <br>
 위의 식은 `2022-10-28 ~ 2022-12-05` 같은 렌트 기간을 가진 차를 찾지 못 함

### 수정 후
`where START_DATE <= '2022-11-30' and END_DATE >= '2022-11-01'` <br>
이렇게 하면 11월에 렌트한 기간이 하루라도 있는 차를 찾아낼 수 있음

## ✔️ 코드 개선
### 이전 코드
```sql
c.CAR_ID not in (
   select distinct CAR_ID
   from CAR_RENTAL_COMPANY_RENTAL_HISTORY
   where START_DATE <= '2022-11-30' and END_DATE >= '2022-11-01'
) 
```
- `where` 절에서 `not in`를 사용했는데, 이러면 `null` 인 경우도 포함될 수 있음 <br>
  -> `null` 이 `not in` 을 통해 비교되면, `UNKNOWN` 결과가 나올 수 있기 때문에 좋지 않음

### 수정 후
```sql
NOT EXISTS (
    select 1
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY h
    where h.CAR_ID = c.CAR_ID
    and h.START_DATE <= '2022-11-30' AND h.END_DATE >= '2022-11-01'
)
```
- `NOT EXISTS` 를 사용
- `NOT EXISTS` 는 서브쿼리가 행이 존재하는지 여부만 확인 <br>
  -> `null` 을 포함한 값들이 있어도 결과에 영향을 주지 않음

## ✔️ 최종 코드
```sql
select c.CAR_ID, c.CAR_TYPE, round(30 * c.DAILY_FEE * (1 - p.DISCOUNT_RATE / 100)) as FEE
                                    
from CAR_RENTAL_COMPANY_CAR c
join CAR_RENTAL_COMPANY_DISCOUNT_PLAN p on c.CAR_TYPE = p.CAR_TYPE
                                    
where c.CAR_TYPE in ('세단', 'SUV') 
    and NOT EXISTS (
        select 1
        from CAR_RENTAL_COMPANY_RENTAL_HISTORY h
        where h.CAR_ID = c.CAR_ID
        and h.START_DATE <= '2022-11-30' AND h.END_DATE >= '2022-11-01'
    )
    and p.DURATION_TYPE = '30일 이상'
    and round(30 * c.DAILY_FEE * (1 - p.DISCOUNT_RATE / 100)) between 500000 and 1999999
                                    
order by FEE desc, CAR_TYPE, CAR_ID desc
```
