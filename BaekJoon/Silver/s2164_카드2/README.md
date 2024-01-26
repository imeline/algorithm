# 문제
[백준 2164번 - 카드2](https://www.acmicpc.net/problem/2164)

# idea
- 큐 함수만 이용하면 간단한 문제

# 알게 된 것
- 큐 선언은 linkedlist 로 : `Queue<Integer> queue = new LinkedList<>();`
- 큐 함수
  + 값 추가 : `q.add()` 나 `q.offer()`
  + 첫 번째 값 반환 및 제거 : `q.poll()`
  + 첫 번째 값 제거 : `q.remove()`
  + 첫 번째 값 반환 : `q.peek()`
  + 초기화 : `q.clear()`
  + 크기 : `q.size()`
