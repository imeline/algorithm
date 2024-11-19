## 문제
[프로그래머스 - 가장 많이 받은 선물](https://school.programmers.co.kr/learn/courses/30/lessons/258712) <br>
: 알고리즘 - 배열

## 문제 풀이
- 이차원 배열을 사용하여 서로 주고 받은 선물 횟수와 선물 지수 기록
  - 해시맵을 사용하여 사람에 대한 인덱스 저장

## 코드 개선
### 이전 코드
```java
int[] answer = new int[f_len]; // 다음달 선물 받을 갯수 
for(int i = 0; i < f_len - 1; i++) {
    for(int j = i + 1; j < f_len; j++) {
        int result = gift[i][j] - gift[j][i];
        if(result > 0) answer[i]++;
        else if(result < 0) answer[j]++;
        else {
            result = gift[i][f_len] - gift[j][f_len];
            if(result > 0) answer[i]++;
            else if(result < 0) answer[j]++;
        }
    }
}
int max = -1;
for(int a : answer) {
    if(a > max) max = a;
}
        
return max;
```
- `i` 는 `0 ~ f_len - 2` 까지, `j` 는 `i + 1 ~ f_len - 1` 까지 <br>
  -> [ i ][ j ] 인 경우와 [ j ][ i ] 인 경우, 둘 중 하나만 실행되도록 함 <br>
  -> 한 `i`에 대한 구문을 실행 할때, `j`의 선물 지수까지 계산
- 그 후, for 문을 한 번 더 해서 max를 찾음

### 개선 코드
```java
int max = 0;
for (int i = 0; i < f_len; i++) {
    int cnt = 0;
    for (int j = 0; j < f_len; j++) {
        if(i == j) continue;
        if (gift[i][j] > gift[j][i]) cnt++;
        else if (gift[i][j] == gift[j][i] && gift[i][f_len] > gift[j][f_len]) cnt++; 
    }
    max = Math.max(cnt, max);
}
return max;
```
- `i` 와 `j` 둘 다, `0 ~ f_len - 1` 까지 <br>
  -> [ i ][ j ] 인 경우와 [ j ][ i ] 인 경우, 둘 중 실행 <br>
  -> 모든 `i` 에 대한 선물 지수를 각각 따로 계산해서, 바로 max 와 비교 가능
- 그 후, for 문을 한 번 더 사용할 필요 x
