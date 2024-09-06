## 문제
[프로그래머스 - 디스크 컨트롤러](https://school.programmers.co.kr/learn/courses/30/lessons/42627) <br>
: 알고리즘 - 힙 heap

## 문제 풀이
- **job 실행의 우선 순위 조건** : <br>
(1) 기다리지 않고 바로 실행 가능한 job (2) 소요 시간이 작은 job
- 다음 요청까지 기다리는 시간을 없애기 위해, 먼저 요청 시간을 기준으로 job을 먼저 거르고, 큐를 통해 소요 시간으로 다시 정렬
  - 전의 job이 끝나는 시간인 end 보다 요청 시간이 전이거나 같으면, 해당 조건 job들은 다 바로 실행 가능하므로
  - 그 job 들 중 소요 시간이 더 작게 걸리는 job 부터 시작
- 만약 바로 실행 가능한 job 이 없으면, 마지막 실행 job의 다음 job이, 기다리더라도 남은 job 중 가장 빨리 실행가능하므로 그 job 을 실행
 
```java
class Solution {
    public int solution(int[][] jobs) {
        // 작업 요청 시점으로 정렬, 요청 시점으로 먼저 거르고 큐를 통해 소유 시간으로 정렬
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        // 작업 소유 시간으로 정렬
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
         // 완료한 job 갯수, 현재 job index, 마지막 job 종료시간, 전체 소요시간
        int count = 0, index = 0, end = 0, total = 0;
        int len = jobs.length;
        // count 는 처리한 작업 수를 의미하므로, len 과 같으면 모든 job을 다 처리했다는 뜻
        while(count < len) { 
            // 기다리지 않고 바로 실행가능한 job 들을, 큐에 소요시간 순으로 넣음
            while(index < len && jobs[index][0] <= end) {
                pq.add(jobs[index++]); // 큐에 넣고, index + 1 해줌
            }
            // 위의 index++ 에 의해, 큐에 들어가지 않은 job 중 
            // 가장 요청 시점이 빠른 job의 요청 시점을 end에 넣어서 
            // 다시 위의 while문의 jobs[index][0] <= end 에 걸려서 pd.add 되게 함
            if(pq.isEmpty()) end = jobs[index][0];
            else {
                int[] new_job = pq.poll(); // pq 에 있는 job 중 가장 소요시간 빠른 job
                total += end - new_job[0] + new_job[1];
                end += new_job[1];
                count++;
            }
        }
        return total / len;
    }
}
```
