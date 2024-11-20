## 문제
[프로그래머스 - 멀쩡한 사각형](https://school.programmers.co.kr/learn/courses/30/lessons/62048) <br>
: 알고리즘 - 최대공약수(gcd)

## 문제 풀이
![image](https://github.com/user-attachments/assets/7c0e733a-4bb5-4602-adb8-861f026424ee)
- 가로(w), 세로(h) <br>
  = `a x gcd`, `b x gcd`
- 직선이 지나가는 일정한 모양 개수 (위 사진의 검정 테두리 사각형) <br>
  = gcd 개수
- 한 검정 테두리 사각형에서 대각선이 지나가는 사각형 수 <br>
  = a + b - 1 <br>

=> 직선이 지나가지 않는 전체 사각형 수 <br>
  = w x h - gcd(a + b - 1) <br>
  = w x h - gcd x a + gcd x b - gcd x 1 <br>
  = w x h - w + h - gcd

## 코드
```java
import java.math.BigInteger;

class Solution {
    public long solution(int w, int h) {
        long total = (long) w * (long) h;
        long blank = w + h - BigInteger.valueOf(w).gcd(BigInteger.valueOf(h)).longValue();

        return total - blank;
    }
}
```
- `java.math.BigInteger` 를 통해 gcd 를 쉽게 구할 수 있음 <br>
-> `BigInteger.valueOf(w).gcd(BigInteger.valueOf(h))`
