import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> min_pq = new PriorityQueue<>();
        PriorityQueue<Integer> max_pq = new PriorityQueue<>(Collections.reverseOrder());

        for(String operation : operations) {
            String[] oper = operation.split(" ");
            String command = oper[0];
            int number = Integer.parseInt(oper[1]);
            
            if(command.equals("I")) {
                min_pq.offer(number);
                max_pq.offer(number);
            }
            else {
                if(!min_pq.isEmpty()) {
                    if(number == 1) min_pq.remove(max_pq.poll());
                    else max_pq.remove(min_pq.poll());
                }
            }
        }
    
        return (min_pq.isEmpty())? new int[]{0,0} : new int[] {max_pq.peek(), min_pq.peek()};
    }
}
