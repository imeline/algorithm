// 더 좋은 코드
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (int move : moves) {
            for (int j = 0; j < board.length; j++) {
                if (board[j][move - 1] != 0) {
                    if (stack.isEmpty()) {
                        stack.push(board[j][move - 1]);
                        board[j][move - 1] = 0;
                        break;
                    }
                    if (board[j][move - 1] == stack.peek()) {
                        stack.pop();
                        answer += 2;
                    } else
                        stack.push(board[j][move - 1]);
                    board[j][move - 1] = 0;
                    break;
                }
            }
        }
        return answer;
    }
}

// 처음 푼 코드
class Solution {
    public int solution(int[][] board, int[] moves) {
        Map<Integer, Stack<Integer>> map = new HashMap<>();
        Stack<Integer> jo = new Stack<>(); // 크레인을 움직여 인형 모으는 곳
        Stack<Integer> stack; 
        int answer = 0;
        for(int j = 0; j < board[0].length; j++) { // 열
            stack = new Stack<>();
            for(int i = board.length - 1; i >= 0; i--) { // 행
                if(board[i][j] != 0) stack.push(board[i][j]);
            }
            map.put(j + 1, stack);
        }
        for(int k = 0; k < moves.length; k++) {
            stack = map.get(moves[k]); 
            if(stack.isEmpty()) continue; // 인형이 없는 곳에 크레인이 갔을 때
            if(!jo.isEmpty() && stack.peek() == jo.peek()) {
                jo.pop(); // 같은 거 제거
                stack.pop();
                answer += 2;
            }
            else jo.push(stack.pop());
        }
        return answer;
    }
}
