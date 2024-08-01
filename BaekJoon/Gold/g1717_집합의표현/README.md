## 문제

[백준 1717번 - 집합의 표현](https://www.acmicpc.net/problem/1717) <br>
-> 알고리즘 - 유니온 파인드

## 문제 해석

- 명령어가 0 일 땐, 두 집합 연결 (union)
- 명령어가 1 일 땐, 두 집합이 연결되어 있는지 확인 후, 결과에 따라 YES, NO 출력

## 풀이

1. union 함수와 findParent 함수를 구현해서 <br>
   명령어가 0이면, union 함수 <br>
   명령어가 1이면, 각각 findParent 해서 같은지 비교 후 결과 출력
2. union 함수 구현은 <br>
   각각 최상위 부모를 찾고 그 부모가 다르다면(같은 집합에 속하지 않는다면) <br>
   각 최상위 부모가 x,y 라고 가정했을 시,
   둘 중 큰 수의 부모에 작은 수를 넣는다 (ex) x<y, parent[y] = x;)
3. find 구현은 <br>
   재귀 함수를 통해 가장 상단의 부모를 찾고 자신과 부모가 일치하면 그 수를 리턴 
   - ```java
      return parent[x] = find(parent[x]);
      ```
     에서 
      ```java
      return find(parent[x]);
      ``` 
      가 아닌 이유는, x의 부모를 최상위 부모로 설정하여 경로를 압축해 <br>
      이후 다시 사용시 연산을 더 빠르게 하기위해 <br>
      ex) <br>
      ```
       1
      /|\
      2 3 4
      \
      5
     ```
     를
      ```
       1
      /|\ \
     2 3 4 5
     ```
     로 만듦
## 궁금한 점
- **find 함수와 union 함수를 non-static 으로 만들면 안되나?** <br>
   -> main 함수가 static 이기 때문에, non-static 으로 만들시 <br>
      class 객체를 생성해서 사용해야함 `ex) {className}.union`

      