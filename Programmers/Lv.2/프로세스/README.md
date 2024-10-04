## 문제
[프로그래머스 - 프로세스](https://school.programmers.co.kr/learn/courses/30/lessons/42587) <br>
: 알고리즘 - 큐

## 문제 풀이
- 단순 큐와 우선순위 큐 사용 문제
- 우선순위 큐를 사용해 우선 순위에 해당하는 값이 맞는지 확인하고, 넣었다 뺐다는 그냥 큐를 이용하여 구현
- `Queue<> q = new LinkedList<>()` - 그냥 큐 선언
- `PriorityQueue<> pq = new PriorityQueue<>()` - 우선순위 큐 선언

## 알게 된 점
- `Arrays.sort()` 는 int[] 는 사용불가 이고, Integer[] 만 사용가능 하다.

## 코드
```java
public int solution(int[] priorities, int location) {
        Queue<int[]> q = new LinkedList<>(); // 인덱스와 프로세스 우선순위를 저장할 큐
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // 정렬된 프로세스 우선순위 넣을 큐
        int answer = 0;
        
        for (int i = 0; i < priorities.length; i++) {
            q.offer(new int[]{i, priorities[i]}); 
            pq.offer(priorities[i]);              
        }

        while (!q.isEmpty()) {
            int[] current = q.poll();
            
            if (current[1] == pq.peek()) { // 우선순위가 가장 높은 경우인지 확인
                pq.poll(); // 우선순위 큐에서 해당 우선순위를 제거
                answer++; // 실행된 프로세스 수 증가
                
                if (current[0] == location) { // 최종정답인 경우
                    return answer;
                }
            } else {
                // 우선순위가 가장 높지 않으면 다시 큐에 넣음
                q.offer(current);
            }
        }
        return answer;
    }
```
