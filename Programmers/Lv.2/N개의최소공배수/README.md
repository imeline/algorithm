## 문제 
- [프로그래머스 - N개의 최소공배수](https://school.programmers.co.kr/learn/courses/30/lessons/12953) <br>
  : 알고리즘 - 유클리드 호재법

## 문제 풀이
- 단순 `최소공배수, 최대공약수 구하는 법` + `세 수의 최소공배수 = (두 수의 최소공배수)와 (나머지 한 수)의 최소공배수` 라는 논리 더 함 

```java
class Solution {
    public int solution(int[] arr) {
        int answer = arr[0];
         // 세 수의 최소공배수 = (두 수의 최소공배수)와 (나머지 한 수)의 최소공배수 
        for(int i = 1; i < arr.length; i++) {
            answer = lcm(answer, arr[i]);   
        }      
        return answer;
    }
  
    private int gcd(int a, int b) { // 최대 공약수
        if (a > b)
            return (a % b == 0) ? b : gcd(b, a % b);
        else
            return (b % a == 0) ? a : gcd(a, b % a);
    }
    
    private int lcm(int a, int b) { // 최소 공배수
        return a * b / gcd(a, b); 
    }
}
```
