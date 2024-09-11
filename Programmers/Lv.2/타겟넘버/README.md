## 문제
[프로그래머스 - 타켓 넘버](https://school.programmers.co.kr/learn/courses/30/lessons/43165)
: 알고리즘 - DFS/BFS

## 문제 풀이
- +, - 했을 경우를 각 DFS/BFS를 생성해 따로 나아가 모든 경우의 수를 구한다.

## 코드 개선
```java
class Solution {
    int count = 0;
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        
        return count;
    }
    
    private void dfs(int[] numbers, int target, int index, int result) {
        if(index == numbers.length) {
            if(result == target) {
                count++;
            }
            // 여기다 return을 해줘야 index 가 범위를 넘어선 경우가 아래로 안감
            return;
        }
        int plus = result + numbers[index];
        int minus = result - numbers[index];
        
        dfs(numbers, target, index + 1, plus);
        dfs(numbers, target, index + 1, minus);
    }
}
```
⬇️

```java
class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }
    
    private int dfs(int[] numbers, int target, int index, int result) {
        if (index == numbers.length) {
            return result == target ? 1 : 0;
        }
        
        int plus = dfs(numbers, target, index + 1, result + numbers[index]);
        int minus = dfs(numbers, target, index + 1, result - numbers[index]);

        // 두 가지 경로를 통해, 구해진 target 도달 경우의 수를 전체 합침
        return plus + minus;
    }
}
```

- 전역 변수인 count 대신, DFS 호출에서 반환 값을 사용 <br>
-> 이렇게 하면 함수 호출 사이의 의존성이 줄어들어 코드가 더 직관적으로 보이고, 부작용을 피할 수 있음
