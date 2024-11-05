## 문제
[프로그래머스 - 크레인 인형뽑기](https://school.programmers.co.kr/learn/courses/30/lessons/64061) <br>
: 알고리즘 - 스택

## 코드 개선
### 처음 푼 코드 
```java
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
```
- Map 을 굳이 사용할 필요없이, key = index 이므로 ArrayList 사용하면 됨
- 인형 뽑기 기계의 처음 상태를 만들 필요 없이, 바로 `for(int k = 0; k < moves.length; k++)`을 for문 돌려서 <br>
  `board` 의 가장 상단 인형을 찾아 비교하고, 사용한 후 `0` 으로 업데이트해서 없애면 됨
  
⬇️

### 개선 코드
```java
public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (int move : moves) {
            for (int j = 0; j < board.length; j++) { // 가장 상단 인형 찾을 때까지
                int now = board[j][move - 1];
                if (now != 0) { // true 시 가장 상단 인형, 0은 인형이 없는 칸이니 다음 j 로
                    if (stack.isEmpty() || now != stack.peek()) {
                        stack.push(now);  
                    }
                    else { 
                        stack.pop();
                        answer += 2;
                    } 
                    board[j][move - 1] = 0; // 사용 후 없애줌
                    break;
                }
            }
        }
        return answer;
    }
```
