## 문제
[프로그래머스 - 가격이 제일 비싼 식품의 정보 출력하기](https://school.programmers.co.kr/learn/courses/30/lessons/131115) <br>
: SUM, MAX, MIN

## 문제 풀이
- where 절에서 max 함수 사용 불가능하므로 <br>
-> 사용 가능한 order 절에서 사용 후 <br>
-> 내림차순으로 정렬하고 <br>
-> 가장 위에 것 1개 출력을 통해 가장 큰 값을 구함 <br>

### 알게 된 것
- where 절에서 max 함수 사용 불가능
- order과 having 절은 사용 가능
- 정렬 후 limit 로 원하는 것만 출력 가능

## 코드
```sql
select *
from food_product
order by price desc
limit 1
```

### 다른 구현 방법
```sql
SELECT *
FROM FOOD_PRODUCT
WHERE PRICE = (SELECT MAX (PRICE)
                FROM FOOD_PRODUCT)
```
