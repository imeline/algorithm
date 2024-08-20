## 문제
[프로그래머스 - 이중우선순위큐](https://school.programmers.co.kr/learn/courses/30/lessons/42628) <br>
- 알고리즘: 우선순위 큐

## 문제 풀이
- **고민점**: 우선순위 큐는 첫번째 값(우선순위 높은 값)은 제거하거나 꺼낼 수 있지만, 마지막 값(우선순위 낮은 값)은 꺼낼 수 없음
  - 인덱스도 사용 불가
- **해결 방법**: 서로 반대의 우선순위를 가지는 우선순위 큐 2개를 생성
```java
PriorityQueue<Integer> min_pq = new PriorityQueue<>();
PriorityQueue<Integer> max_pq = new PriorityQueue<>(Collections.reverseOrder());
```
- **주의점**: 한 큐에서 값을 제거할 때, 다른 큐에서도 해당 값을 제거해야함
```java
min_pq.remove(max_pq.poll());
```
-> `poll` 이 첫번째 값을 제거하고 그 값을 리턴 <br>
-> 그 리턴된 값을 min 큐에서도 지움
