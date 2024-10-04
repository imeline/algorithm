import java.util.*;

class Solution {
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
}
