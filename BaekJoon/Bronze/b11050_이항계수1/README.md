## 문제
- [백준 11050번 - 이항 계수 1](https://www.acmicpc.net/problem/11050)
    - 알고리즘 : 조합
  
## 문제 풀이
- 단순 조합 알고리즘의 '점화식' 구현 문제 ([정리 블로그](https://velog.io/@imeline/%EC%A1%B0%ED%95%A9))
- 아래 부분만 주의
```java
for (int i = 3; i <= N; i++) { // 0,1,2 는 초기화된 수들이 자리
    for (int j = 2; j < i; j++) { // arr[i][i] 는 초기화 했으므로, 그 전까지
        arr[i][j] = arr[i-1][j] + arr[i-1][j-1];
    }
}
```