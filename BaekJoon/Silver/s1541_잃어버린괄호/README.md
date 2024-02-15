# 문제

- [백준 1541번 - 잃어버린 괄호](https://www.acmicpc.net/problem/1541)

## 알고리즘

- 그리디 알고리즘

## 참고 사이트

[Stranger's LAB의 Tistory](https://st-lab.tistory.com/148)

# 문제 풀이 idea

- 빼지는(-) 숫자가 클수록 수식의 결과는 최소가 됨<br>
  -> a-b 에서 b가 클수록 좋음 <br>
  -> (-) 가 나올 때 까지의 값들을 모두 괄호로 묶어주면 됨 <br>
  -> `100-10+20+30-50+12` 일 경우, `100-(10+20+30)-(50+12)` 로 괄호 쳐 줌
  <br><br>

- 문자열을 +,- 기준으로 나누는데에 `split`함수와 `StringTokenizer` 두 가지 방식을 사용할 수 있다. <br>
    1. `split()` : `String[] addition = subtraction[i].split("\\+");` <br>
    2. `StringTokenizer` : `StringTokenizer addition = new StringTokenizer(subtraction.nextToken(), "+");`