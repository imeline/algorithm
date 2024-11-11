// 큐 사용 o
public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < progresses.length; i++) {
            int day = (int) Math.ceil((100 - progresses[i]) / (double) speeds[i]);
            if(!q.isEmpty() && q.peek() < day) {
                answer.add(q.size());
                q.clear();
            }
            q.offer(day);
        }
        answer.add(q.size());
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

// 큐 사용 x
 public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        int prior = (int) Math.ceil((100 - progresses[0]) / (double) speeds[0]);
        int cnt = 1;
        
        for(int i = 1; i < progresses.length; i++) {
            int day = (int) Math.ceil((100 - progresses[i]) / (double) speeds[i]);
            if(prior < day) {
                answer.add(cnt);
                prior = day;
                cnt = 1;
            }
            else {
                cnt++;
            }
        }
        answer.add(cnt); // 마지막 꺼 추가
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
