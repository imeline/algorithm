## 문제
[프로그래머스 - 정수 삼각형](https://school.programmers.co.kr/learn/courses/30/lessons/43105) <br>
: 알고리즘 - 동적 계획법(DP)

## 문제 풀이
- 가장 왼쪽, 가장 오른쪽, 나머지 중간 3개 부분으로 나누어 각 상단 노드와 자신의 값을 더해감 -> 누적값
- 중간 부분은 왼쪽, 오른쪽 상단 노드 중 큰 값과 자신의 값을 더해감
- 리프 노드 중 가장 큰 값이 답

## 알게 된 것
- 배열에서 최대/최소값 stream 으로 구하기
```java
// 최대
Arrays.stream(arr).max().getAsInt();
// 최소
Arrays.stream(arr).min().getAsInt();
```

## 코드 개선
```java
for(int i = 1; i < triangle.length; i++) { 
    dp[i][0] = dp[i-1][0] + triangle[i][0];
    dp[i][i] = dp[i-1][i-1] + triangle[i][i];
    for(int j = 1; j < i; j++) {
        dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
    }
}
```

⬇️

```java
 for (int i = 1; i < triangle.length; i++) {
    triangle[i][0] += triangle[i-1][0];
    triangle[i][i] += triangle[i-1][i-1];
    for (int j = 1; j < i; j++) 
        triangle[i][j] += Math.max(triangle[i-1][j-1], triangle[i-1][j]);
}
```

- 새로운 배열 DP를 만들지 않고, 기존 배열 triangle 로 해결
