## 문제

[백준 11404번 - 플로이드](https://www.acmicpc.net/problem/11404) <br>
-> 알고리즘 : 플로이드-워셜 (그래프)

---

## 문제 풀이

- 단순 플로이드-워셜 문제
- **주의점** : 출발 도시와 도착 도시가 같지만 시간이 다른 입력값이 들어올 수 있음. <br>
  예를 들어 "1 4 1"과 "1 4 2"가 입력으로 들어왔으면, "1 4 1"을 택해야 함.

--- 

## 트러블 슈팅

### 문제

```java
        -2147483647-2147483646-2147483645-2147483647 4
	-2147483638-2147483647-2147483646-2147483648-2147483645
	-2147483646-2147483646-2147483645-2147483647 1
	-2147483647-2147483647-2147483646-2147483648-2147483645
	-2147483642-2147483643-2147483641-2147483643 0 
```

입력 값이 위와 같이 `-2147483642` 가 나오는 현상

### 원인

```java
short_distance[i][j]=Math.min(short_distance[i][j], 
        short_distance[i][k] + short_distance[k][j]);
```

에서 두 거리를 더할 때,<br>
`short_distance[i][k]` 나 `short_distance[k][j]` 가`Integer.MAX_VALUE` 이면 <br>
-> **오버플로우**가 발생

### 해결

```java
if(short_distance[i][k]!=Integer.MAX_VALUE &&short_distance[k][j]!=Integer.MAX_VALUE){
    short_distance[i][j] = Math.min(short_distance[i][j], 
        short_distance[i][k] + short_distance[k][j]);
}
```

두 거리가 `Integer.MAX_VALUE` 가 아닐때만 실행

---

## 코드 개선

1. `Integer.MAX_VALUE` 싱수화 - 코드 가독성 ⬆️
2. `print` 대신 `BufferedWriter` 사용 - 입출력 속도 ⬆️