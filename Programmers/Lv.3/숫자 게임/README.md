## 문제
[프로그래머스 - 숫자 게임](https://school.programmers.co.kr/learn/courses/30/lessons/12987) <br>
: 알고리즘 - 그리디

## 문제 풀이
- 두 배열을 정렬해서 큰 수엔 큰 수를 매치해서, 만약 A 큰 수보다 B 큰 수가 작다면<br>
  B의 가장 작은 수를 A 큰 수와 매치해줌. B 큰 수는 다음 매치에서 사용
  
### 알게 된 것
- `Arrays.sort()` 에서 `int[]` 는 오름차순 만 가능 <br>
  내림차순은 `Integer[]` 만 가능 -> `Arrays.sort(arr, Collections.reverseOrder())`


## 코드 개선
### 이전 코드
```java
public int solution(int[] A, int[] B) {
        A = Arrays.stream(A)
            .boxed() // int를 Integer로 변환
            .sorted(Collections.reverseOrder()) // 내림차순 정렬
            .mapToInt(Integer::intValue) // 다시 int로 변환
            .toArray();
        B = Arrays.stream(B)
            .boxed()
            .sorted(Collections.reverseOrder())
            .mapToInt(Integer::intValue)
            .toArray();
        
        int answer = 0;
        int b_idx = 0;
        for(int a : A) {
            if(a < B[b_idx]) {
                answer++;
                b_idx++;
            }
        }
        return answer;
}
```
- 내림차순 으로 정렬해서 비교

### 개선 코드
```java
public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);

        int answer = 0;
        for (int i = A.length - 1, j = B.length - 1; i >= 0; i--) {
            if(A[i] < B[j]) {
                answer++;
                j--;
            }
        }

        return answer;
}
```
- 오름차순으로 정렬하고, for문 배열을 마지막 인덱스부터 시작해서 작아지면 됨
