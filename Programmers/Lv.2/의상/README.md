## 문제
[프로그래머스 - 의상](https://school.programmers.co.kr/learn/courses/30/lessons/42578) <br>
: 알고리즘 - 해시

## 문제 풀이
- 단순 해시 사용
- **주의점** : (A, B)의 조합을 찾지만 B 없이 A만 있는 경우도 가능하기 때문에, <br>
  각 개수에 공집합을 고려해 +1 해주기

### 해시 함수
- `getOrDefault(키, 기본값)` : key에 해당하는 value를 찾되, 해당 키가 없으면 0을 리턴
- `get(키)` : key 의 value 를 리턴
- `keySet()` : HashMap에 있는 key 들의 집합, 배열을 리턴


### 전체 코드
```java
import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        int answer = 1; // 아래에서 곱하기를 할꺼라서 0 이면 곱해도 0이기 때문에 1을 씀
        // 의상(clothes[i][1])별 갯수 저장 (키 = 의상 종류, 값 = 그 의상 개수)
        for(int i = 0; i < clothes.length; i++) {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
            // map.getOrDefault(clothes[i][1], 0) 은 clothes[i][1]의 value 를 찾돼, 
            // clothes[i][1]인 key 가 없으면 0을 기본으로 리턴
        }
        // 경우의 수 계산
        for(String key : map.keySet()) {
            answer *= (map.get(key) + 1);
            // A가 3개, B가 2개 있을 경우 (A, B) 의 쌍은 3 * 2 개 
            // + 1 을 하는 이유는 (A, 없음) 처럼, A나 B가 단일로 있는 경우도 가능하기 때문에
            // A가 [1, 2, 3] 이라면 [공잡합, 1, 2, 3] 으로 생각하기 때문에 전체 개수 + 1
        }
        
        return answer - 1;
        // [공집합, 공집합] 처럼 공집합끼리 만난, 요소가 하나도 없는 1개의 경우를 뺌
    }
}
```
