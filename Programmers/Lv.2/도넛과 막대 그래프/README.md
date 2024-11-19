## 문제
[프로그래머스 - 도넛과 막대 그래프](https://school.programmers.co.kr/learn/courses/30/lessons/258711) <br>
: 정점의 개수 = 그래프 개수

## 문제 풀이
- 그래프당 정점이 1개씩 존재 <br>
  -> 정점의 개수 = 그래프의 개수 <br>
  -> 정점의 특성을 파악해, 그것으로 정점 판단 <br>
  -> 나가는 간선(out), 들어오는 간선(out) 개수로 특성 판단

### 정점 특징
1. 모든 그래프들을 이어주는 임의의 정점
   - out : 전체 그래프의 개수와 같음, 2개 이상
   - in : 0개
2. 도넛 그래프
   - 모든 노드가 out, in 1개씩 <br>
   -> 막대 그래프 나머지 노드의 특성과 동일해, 구분 불가 <br>
   -> `전체 그래프의 개수(= 임의의 정점의 out 개수) - 막대 그래프 개수 - 8자 그래프 개수` <br>
      로 개수 구함
3. 막대 그래프
   - 정점만 out 0개, in 1개
   - 나머지 노드 out, in 1개씩
4. 8자 그래프
   - 정점만 out, in 2개씩
   - 나머지 노드 out, in 1개씩

#### 정리
- `out >= 2` 인데,
  - `in = 0` 이면 **임의의 정점**
  - 아니면 **8자 그래프**
- `in = 1 && out = 0`(= in에는 node 가 있는데, out에는 node가 없음) <br>
  면 **막대 그래프**  
- `임의의 정점의 out 개수 - 막대 그래프 개수 - 8자 그래프 개수` 는 **도넛 그래프**

### 코드
```java
public int[] solution(int[][] edges) {
        HashMap<Integer, Integer> out = new HashMap<>();
        HashMap<Integer, Integer> in = new HashMap<>();
        
        for(int[] edge : edges) {
            out.put(edge[0], out.getOrDefault(edge[0], 0) + 1);
            in.put(edge[1], out.getOrDefault(edge[1], 0) + 1);
        }
        
        int[] answer = new int[4];
        
        for(int node : out.keySet()) {
            if(out.get(node) >= 2) {
                if(!in.containsKey(node)) answer[0] = node;
                else answer[3]++;
            }
        }
        
        for(int node : in.keySet()) {
            if(!out.containsKey(node)) answer[2]++;
        }
        
        
        answer[1] = out.get(answer[0]) - answer[2] - answer[3];
        
        return answer;
    }
```

- 배열로 사용해서도 풀 수 있지만, 노드의 개수를 알 수 없어 배열의 크기를 최댓값 1,000,000 으로 지정해야 함 <br>
  -> 정점 조건 확인 시, for 문으로 사용되지 않는 가능성이 큰 1,000,000 인덱스 까지 모두 확인해야하므로 <br>
  -> 배열로 풀지 않음
