# 문제
[백준 11286번 - 절댓값 힙](https://www.acmicpc.net/problem/11286)

## 참조
[do it! 알고리즘](https://www.inflearn.com/course/lecture?courseSlug=두잇-알고리즘-코딩테스트-자바&unitId=148350&tab=curriculum)

## 사용 자료구조
- 우선순위 큐
  - ` PriorityQueue<Student> getPriorityQueueOfStudents() {}`<br>
  -> 밑에 함수 구현 후 `()`에 함수 이름을 넣어주거나<br> 
  -> 람다식 이용해서 `((o1,o2)->{});` 하거나<br>
  -> `(new compare<>() {});` 해서, <br>
  -> compareTo() 구현

# idea
1. 우선순위 큐로 절댓값을 기준으로 큐에 삽입되도록 함 <br>
   (절댓값이 같은 경우는 음수가 우선 순위)
2. N번 동안
3. if절을 통해 x가 0이라면, 큐 `poll()`
4. else는 큐에 `add()`

# 알게 된 것 
- `Comparator` 에서 오름차순을 원할 때,<br>
  + 기준 값(o1, 선행 값)과 비교대상(o2, 후행 값)이 동일한 값일 경우 0 
  + 기준 값이 비교대상 보다 작은 경우 -1 
  + 기준 값이 비교대상 보다 큰 경우 1 


- `Comparator` 에서 `return` 값이 **양수**일 경우, 두 수의 자리를 바꾼다. <br>
  -> (선행 값 - 후행 값)이 (-)이면, 후행 값이 더 크니까(오름차순에 맞음) 자리 안 바뀜


- 자바에서 `queue`는 `linkedlist` 이므로 <br>
  -> `poll()`은 head를 제거 및 리턴 <br>
  -> `add()`는 tail에 추가 <br>
  -> 그래서 `comparator`할 때도, 절댓값 큰 수는 뒤로가고 (먼저 제거 되어야하는)작은수는 앞으로 오는, 오름차순으로 정렬