## 문제
[프로그래머스 - 물고기 종류 별 대어 찾기](https://school.programmers.co.kr/learn/courses/30/lessons/293261) <br>
: SUM, MAX, MIN

## 문제 풀이
- 서브 쿼리를 사용해 `FISH_TYPE, max(LENGTH)` 을 찾고,
- `where` 절에서 `in` 을 통해 비교

## 오답 개선
### 초기 코드
```sql
select a.ID, b.FISH_NAME, a.LENGTH
from FISH_INFO a 
join FISH_NAME_INFO b on a.FISH_TYPE = b.FISH_TYPE
group by FISH_TYPE
having LENGTH = max(LENGTH)
order by ID
```
- `group by` 와 `having` 에 대한 개념이 잘못 잡혀 있었음

#### 💡 group by 와 having
```sql
SELECT department, COUNT(*) AS employee_count
FROM employees
GROUP BY department
HAVING employee_count > 5;
```
- 위에 코드 처럼 `group by` 는 보통 `select` 절의 집계함수와 같이 쓰임 <br>
  -> `group by` 로 묶은 그룹과 다른 컬럼을 출력하고 싶다면 <br>
  -> 묶은 그룹에서 한 컬럼 데이터를 뽑기 위한 **집계함수**를 사용해줘야 함 <br>
  -> 위의 예: `department` 로 묶고, `count` 를 통해 `department` 당 모든 컬럼 수를 세서, 하나의 데이터로 만듦

- `having` 은 그룹화된 결과에 조건을 추가할 때 사용 <br>
  -> `select` 절에서 한 데이터로 묶은 컬럼에 비교식으로 조건 추가 가능 <br>
  -> 위의 예: `having`의 `employee_count` 는 `select` 절의 `employee_count` <br>
    -> `employee_count > 5` = `COUNT(*) > 5`

### 최종 개선 코드
```sql
select a.ID, b.FISH_NAME, a.LENGTH
from FISH_INFO a 
join FISH_NAME_INFO b on a.FISH_TYPE = b.FISH_TYPE
where (a.FISH_TYPE, a.LENGTH) in (
    select FISH_TYPE, max(LENGTH)
    from FISH_INFO
    group by FISH_TYPE
)
order by ID
```
