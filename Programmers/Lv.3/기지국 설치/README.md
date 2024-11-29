## 문제
[프로그래머스 - 기지국 설치](https://school.programmers.co.kr/learn/courses/30/lessons/12979) <br>
: 알고리즘 - 그리디

## 문제 풀이
- 그리디 : 최선이라고 생각되는 해를 선택하고, 해가 전체 문제의 제약 조건에 벗어나지 않는지 검사한다. <br>

1. 기존 기지국을 만나거나, 새 기지국 설치 시 <br>
  전파 전달되는 가장 오른쪽 배열 인덱스 + 1(전파 범위 밖)로 보내, 범위 검사를 한다.
2. 만약 기존 기지국 범위 내에 해당하면, 다음 기존 기지국으로 넘어가게 `s_idx++` 해주고, <br>
     기존 기지국 범위 밖이라면, 새 기지국을 설치함  `answer++`
3. 다시 1.부터 반복한다.

## 오답 개선
### 이전 코드
```java
class Solution {
    public int solution(int n, int[] stations, int w) {
        int[] apt = new int[n + 1];
        int answer = 0;
        
        for(int i = 0; i < stations.length; i++) {
            for(int j = stations[i] - w; j <= stations[i] + w; j++) {
                if(j > n) break;
                apt[j] = 1;
            }
        }
        
        for(int i = 1; i < n + 1; i++) {
            if(apt[i] == 0) {
                installStation(n, w, apt, i);
                answer++;
            }
        }
        return answer;
    }
    
    void installStation(int n, int w, int[] apt, int i) {
        for(int j = i; j <= i + w * 2; j++) {
            if(j > n || apt[j] == 1) return; 
            apt[j] = 1;
        }
    }
}
```
- 모든 배열 인덱스와 기지국을 설치하는 곳 범위 내 인덱스를 방문함 <br>
  -> 런타임 에러, 시간 초과

### 개선 코드
```java
class Solution {
    public int solution(int n, int[] stations, int w) {
        int now = 1; // 현재 위치
        int s_idx = 0; // stations 인덱스
        int answer = 0; // 새 기지국 개수
        
        while(now <= n) {
            // 새 기지국 설치 시, stations[s_idx] 보다 왼쪽에 설치 됐으므로, stations[s_idx] 보다 최대 전파 인덱스가 작음
            // now >= stations[s_idx] - w 하면, stations[s_idx] - w <= now <= stations[s_idx] + w 한거나 마찬가지
            // 기존 기지국의 전파 범위 내
            if(s_idx < stations.length && now >= stations[s_idx] - w) {
                s_idx++;
                now = stations[s_idx] + w + 1;
            }
            else { // 기존 기지국의 전파가 닿지 않는 곳 - 기존 기지국의 전파 범위 왼쪽, 오른쪽 부분
                answer++;
                now += w * 2 + 1;
            }
        }     
        return answer;
    }
}
```
- 그리디를 이용해 가장 최선의 해만 고려 <br>
  -> 새 기지국 설치 시 와, 기존 기지국 범위 내를 만나면 <br>
  -> 해당 기지국 전파 밖(오른쪽)으로 현재 위치를 옮김 
  
